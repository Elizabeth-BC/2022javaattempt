package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SetupPlayback extends CommandBase {
  public static final SendableChooser<Command> chooser = new SendableChooser<>();
  public SetupPlayback(String inputFileName) {
    addRequirements(RobotContainer.at);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    RobotContainer.at.setupPlayback(chooser.getSelected());
  }

  @Override
  public void end(boolean interrupted) {
    
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
