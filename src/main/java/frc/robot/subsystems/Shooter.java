package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
  // Constants
  //IDs
  static final int kUpperFWOneID = 5;
  static final int kUpperFWTwoID = 6;
  //PID
  static final double shooter_kP = 6e-5;
  static final double shooter_kI = 1e-6;
  static final double shooter_kD = 0;
  static final double shooter_kIz = 0;
  static final double shooter_kFF = 0.000015;
  //Limits
  static final double kMaxOutput = 1.0;
  static final double kMinOutput = -1.0;
  static final double MANUAL_RPM = 4000;
  static final double MaxRPM = 5676;
  static final double REAR_SHOOTER_PERCENT = 0.6;
  static final double SHOOTER_SLOPE = 11.9;
  static final double SHOOTER_CONST = 2215; // previously 2190
  static final double EXTRARPM = 25.0;

  // Shooter devices
  private CANSparkMax flyWheelUpperOne;
  private CANSparkMax flyWheelUpperTwo;
  private SparkMaxRelativeEncoder m_encoderShooterOne;
  //private SparkMaxRelativeEncoder m_encoderShooterTwo;
  private SparkMaxPIDController m_pidControllerShooterOne;
  private SparkMaxPIDController m_pidControllerShooterTwo;

  public Shooter() {
    flyWheelUpperOne = new CANSparkMax(kUpperFWOneID, MotorType.kBrushless);
    flyWheelUpperTwo = new CANSparkMax(kUpperFWTwoID, MotorType.kBrushless);
    flyWheelUpperOne.restoreFactoryDefaults();
    flyWheelUpperTwo.restoreFactoryDefaults();

    /// !!! This need to change to getEncoder(type,revsperturn) !!!
    m_encoderShooterOne = (SparkMaxRelativeEncoder) flyWheelUpperOne.getEncoder();
    //m_encoderShooterTwo = (SparkMaxRelativeEncoder) flyWheelUpperTwo.getEncoder();

    m_pidControllerShooterOne = flyWheelUpperOne.getPIDController();
    m_pidControllerShooterOne.setP(shooter_kP);
    m_pidControllerShooterOne.setI(shooter_kI);
    m_pidControllerShooterOne.setD(shooter_kD);
    m_pidControllerShooterOne.setIZone(shooter_kIz);
    m_pidControllerShooterOne.setFF(shooter_kFF);
    m_pidControllerShooterOne.setOutputRange(kMinOutput, kMaxOutput);

    m_pidControllerShooterTwo = flyWheelUpperTwo.getPIDController();
    m_pidControllerShooterTwo.setP(shooter_kP);
    m_pidControllerShooterTwo.setI(shooter_kI);
    m_pidControllerShooterTwo.setD(shooter_kD);
    m_pidControllerShooterTwo.setIZone(shooter_kIz);
    m_pidControllerShooterTwo.setFF(shooter_kFF);
    m_pidControllerShooterTwo.setOutputRange(kMinOutput, kMaxOutput);
  }

  void stopShooter() {
    flyWheelUpperOne.stopMotor();
    flyWheelUpperTwo.stopMotor();
  }

  double getRPMS() {
    return m_encoderShooterOne.getVelocity();
  }

  void runShooterAuto(double RPM1) {
    double shooter_type = SmartDashboard.getNumber("Shooter Power/RPM", 0);
    if (shooter_type == 0) {
      double RPM2 = RPM1 * REAR_SHOOTER_PERCENT;
      m_pidControllerShooterOne.setReference(RPM1, ControlType.kVelocity);
      m_pidControllerShooterTwo.setReference(RPM2, ControlType.kVelocity);
      Debug.debugCons("RPM VALUES: " + m_encoderShooterOne.getVelocity());
    }
  }
}