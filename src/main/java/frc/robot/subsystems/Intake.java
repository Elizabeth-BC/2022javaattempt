package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake {

  public Intake() {

  }

  void runIntake() {
    m_intakeMotor.set(INTAKE_POWER_IN);
  }

  void stopIntake() {
    m_intakeMotor.stopMotor();;
  }
}

class IntakePivot {

  IntakePivot() {

  }

  void runIntakePivot() {
    m_intakePivot.set(INTAKE_PIVOT_POWER_IN);
  }

  void reverseIntakePivot() {
    m_intakePivot.set(INTAKE_PIVOT_POWER_OUT);
  }

  void stopPivot() {
    m_intakePivot.stopMotor();
  }
}