package frc.robot.commands.auto.routines;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class kLeftAuto extends CommandBase {
  public kLeftAuto() {
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    RobotContainer.at.readFile();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
