package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import java.lang.Math;
import frc.robot.HardwareAdapter;

public class Pivot extends SubsystemBase implements HardwareAdapter{

  public Pivot() {
    pivotPID.setTolerance(kNominalTXError);

    pivotMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //ctre mag encoder
    pivotMotor.setSensorPhase(true);
    pivotMotor.setSelectedSensorPosition(0);
    pivotMotor.clearStickyFaults();
  }

  // void Turn(double setPower) {
  //   if (Math.abs(GetAngle() - MAX_PIVOT_ANGLE) > 500) {
  //     m_pivotMotor.set(Util.clamp(-setPower,-kMAX_PIVOT_POWER,kMAX_PIVOT_POWER));
  //   } else if (Math.abs(GetAngle() - MIN_PIVOT_ANGLE) > 500) {
  //     m_pivotMotor.set(Util.clamp(setPower,-kMAX_PIVOT_CORRECT_POWER,kMAX_PIVOT_CORRECT_POWER));
  //   }
  // }

  public double GetAngle() {
    return pivotMotor.getSelectedSensorPosition();
  }
}