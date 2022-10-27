package frc.robot.subsystems;

//import com.ctre.phoenix.;
// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogEncoder;

public class Turret {
  // Constants
  static final double[] GOAL_ANGLE = {0.01, 90.0, 180.0, 270.0, 359.9};
  static final double ANGLE_THRESH = 8.0;
  static final int kTurretEncoderID = 0;
  static final int kTurretMotorID = 12;
  //Turret turn rate limit
  static final double kTURRENT_POWER = 0.4;               //normal turn power
  static final double kTURRENT_AUTOPOWER = 0.3;           //autotargeting turn power
  static final double kMAX_TURRET_POWER = 0.5;            //max turret turn power
  //Turret Limits
  static final double kMAX_RANGE = 180.0;
  static final double kENCODER_RATIO = 73.17;
  static final double kNOMINAL_TX_ERROR = 1;

  // Turret devices
  private WPI_TalonSRX m_turretMotor;
  private AnalogEncoder m_turEncoder;

  public Turret() {
    m_turretMotor = new WPI_TalonSRX(kTurretMotorID);
    m_turEncoder = new AnalogEncoder(kTurretEncoderID);

    ResetTurretEncoder();
    m_turretMotor.clearStickyFaults();
  }

  void ResetTurretEncoder() {
    m_turEncoder.reset();
    Debug.debugCons("Encoder Reset");
  }

  // void Turn(double setPower) {
  //   Debug.debugDashNum("(Tur) Turret Power", setPower);

  //   double encoderAngle = (m_turEncoder.getAbsolutePosition() * 360) - 180;
  //   Debug.debugCons("TURRET POSITION: " + encoderAngle);

  //   // Limit turn angles
  //   if ((setPower < 0 && encoderAngle > -90) || (setPower > 0 && encoderAngle < 90)) {
  //     // Need to figure out if percentoutput is right!!!
  //     m_turretMotor.set(TalonSRXControlMode.PercentOutput, Util.clamp(setPower, -kMAX_TURRET_POWER, kMAX_TURRET_POWER));
  //   }
  // }

  // double GetAngle() {
  //   double encoderAngle = m_turEncoder.getAbsolutePosition();
  //   if (encoderAngle > 180) {
  //     encoderAngle -= 180;
  //   }
  //   return encoderAngle;
  // }
}