package frc.robot.subsystems;

//import com.ctre.phoenix.;
// import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Turret extends SubsystemBase implements HardwareAdapter{

  public Turret() {
    ResetTurretEncoder();
    turretMotor.clearStickyFaults();
  }

  void ResetTurretEncoder() {
    turretEncoder.reset();
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