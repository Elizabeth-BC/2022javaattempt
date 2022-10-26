package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;

public class LightOff extends CommandBase implements HardwareAdapter{
  public LightOff() {
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    ledMode.setNumber(LL_OFF);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}