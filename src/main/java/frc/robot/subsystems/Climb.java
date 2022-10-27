package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import frc.robot.HardwareAdapter;

public class Climb implements HardwareAdapter{

  public Climb() {

  }

  void ClimbUp() {
    climbLead.set(CLIMB_SPEED2);
    climbFollower.set(CLIMB_SPEED2);
  }

  void ClimbDown() {
    climbLead.set(CLIMB_SPEED);
    climbFollower.set(CLIMB_SPEED);
  }

  void ClimbStop() {
    climbLead.stopMotor();
    climbFollower.stopMotor();
  }

  void ClimbHighUP() {
    climbHigh.set(-CLIMB_SPEED);
  }

  void ClimbHighDOWN() {
    climbHigh.set(CLIMBHIGH_SPEED);
  }

  void ClimbHighStop() {
    climbHigh.stopMotor();
  }
}