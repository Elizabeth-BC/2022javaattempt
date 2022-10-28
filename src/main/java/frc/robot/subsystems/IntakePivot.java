package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;


public class IntakePivot extends SubsystemBase implements HardwareAdapter{

  public IntakePivot() {

  }

  public void runIntakePivot() {
    intakePivot.set(intakePivotPowerIn);
  }

  public void reverseIntakePivot() {
    intakePivot.set(intakePivotPowerOut);
  }

  public void stopPivot() {
    intakePivot.stopMotor();
  }
}