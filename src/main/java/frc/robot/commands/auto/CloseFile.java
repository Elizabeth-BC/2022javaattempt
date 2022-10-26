package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class CloseFile extends CommandBase {
  public CloseFile() {
    addRequirements(RobotContainer.at);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    RobotContainer.at.closeFile();
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
