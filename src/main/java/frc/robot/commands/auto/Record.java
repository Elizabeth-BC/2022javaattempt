package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.HardwareAdapter;
// import frc.robot.HardwareAdapter.ControllerInputs;
import frc.robot.RobotContainer;

public class Record extends CommandBase implements HardwareAdapter.ControllerInputs{
  public Record() {
    addRequirements(RobotContainer.at);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    // RobotContainer.at.record(inputs);
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
