package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.SparkMaxPIDController;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.revrobotics.SparkMaxRelativeEncoder;
// import com.revrobotics.CANSparkMax.ControlType;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Shooter extends SubsystemBase implements HardwareAdapter{

  public Shooter() {
    flyWheelUpperOne.restoreFactoryDefaults();
    flyWheelUpperTwo.restoreFactoryDefaults();


    // pidControllerShooterOne = flyWheelUpperOne.getPIDController();
    pidControllerShooterOne.setP(shooter_kP);
    pidControllerShooterOne.setI(shooter_kI);
    pidControllerShooterOne.setD(kD);
    // pidControllerShooterOne.setIZone(kIz);
    // pidControllerShooterOne.setFF(kFF);
    // pidControllerShooterOne.setOutputRange(kMinOutput, kMaxOutput);

    // pidControllerShooterTwo = flyWheelUpperTwo.getPIDController();
    pidControllerShooterTwo.setP(shooter_kP);
    pidControllerShooterTwo.setI(shooter_kI);
    pidControllerShooterTwo.setD(kD);
    pidControllerShooterTwo.setIZone(kIz);
    pidControllerShooterTwo.setFF(kFF);
    pidControllerShooterTwo.setOutputRange(kMinOutput, kMaxOutput);
  }

  void stopShooter() {
    flyWheelUpperOne.stopMotor();
    flyWheelUpperTwo.stopMotor();
  }

  // double getRPMS() {
  //   return m_encoderShooterOne.getVelocity();
  // }

  // void runShooterAuto(double RPM1) {
  //   double shooter_type = SmartDashboard.getNumber("Shooter Power/RPM", 0);
  //   if (shooter_type == 0) {
  //     double RPM2 = RPM1 * rearShooterPercent;
  //     m_pidControllerShooterOne.setReference(RPM1, ControlType.kVelocity);
  //     m_pidControllerShooterTwo.setReference(RPM2, ControlType.kVelocity);
  //     Debug.debugCons("RPM VALUES: " + m_encoderShooterOne.getVelocity());
  //   }
  // }
}