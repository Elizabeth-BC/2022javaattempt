package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Climb extends SubsystemBase implements HardwareAdapter{

  public Climb() {

  }

  public void ClimbUp() {
    climbMotors.set(climbSpeed2);
  }

  public void ClimbDown() {
    climbMotors.set(climbSpeed);
  }

  public void ClimbStop() {
    climbMotors.stopMotor();
  }

  public void ClimbHighUP() {
    climbHigh.set(-climbSpeed);
  }

  public void ClimbHighDOWN() {
    climbHigh.set(climbHighSpeed);
  }

  public void ClimbHighStop() {
    climbHigh.stopMotor();
  }
}