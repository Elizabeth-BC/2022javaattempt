package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Intake extends SubsystemBase implements HardwareAdapter{

  public Intake() {

  }

  public void runIntake() {
    intakeMotor.set(intakePowerIn);
  }

  public void stopIntake() {
    intakeMotor.stopMotor();;
  }
}