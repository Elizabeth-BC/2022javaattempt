package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Auto;

public class Robot extends TimedRobot implements HardwareAdapter{
  private Command autoCommand;  
  private RobotContainer robotContainer;
  private boolean m_recordMode = true;

  @Override
  public void robotInit() {    
    robotContainer = new RobotContainer();
    ChangeLEDColors(LEDS_LOCKED_ON);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {    
    autoCommand = robotContainer.getAutonomousCommand();
    if (autoCommand != null) {
      autoCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    Auto.setupRecording(chooser.getSelected());
    if (m_recordMode) {
      teleopPeriodic();
      // Auto.record(ControllerInputs inputs);
    }
  }
  @Override
  public void testPeriodic() {
  }

  public void ChangeLEDColors(double SetColor) {
    BlinkinLEDDriver.set(SetColor);
  }
}
