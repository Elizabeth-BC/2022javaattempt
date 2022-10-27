// Pivot Class

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogEncoder;
// import java.lang.Math;

public class Pivot {
  // Constants
  //IDs
  static final int kPivotEncoderID = 1;
  static final int kPivotMotorID = 8;
  //Pivot turn rate limit
  static final double kMAX_PIVOT_POWER = 0.15;  //max pivot turn power 2 percent
  static final double kMAX_PIVOT_CORRECT_POWER = 0.15;  //correct when turret goes beyond max range
  //Pivot Limits
  static final double kMAX_RANGE = 30.0;
  static final double kENCODER_RATIO = 73.17;
  static final double kNOMINAL_TX_ERROR = 1.0;
  static final int MIN_PIVOT_ANGLE = 0;
  static final int MAX_PIVOT_ANGLE = 58700;
  //PID
  static final double kP = .05;
  static final double kI = 0;
  static final double kD = 0;

  // Pivot devices
  private WPI_TalonSRX m_pivotMotor;
  private PIDController m_pivotPID;
  private AnalogEncoder m_pivotEncoder;

  public Pivot() {
    m_pivotMotor = new WPI_TalonSRX(kPivotMotorID);
    m_pivotPID = new PIDController(kP, kI, kD);
    m_pivotEncoder = new AnalogEncoder(kPivotEncoderID);
    m_pivotPID.setTolerance(kNOMINAL_TX_ERROR);
    m_pivotEncoder.reset();

    m_pivotMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10); //ctre mag encoder
    m_pivotMotor.setSensorPhase(true);
    m_pivotMotor.setSelectedSensorPosition(0);
    m_pivotMotor.clearStickyFaults();
  }

  // void Turn(double setPower) {
  //   if (Math.abs(GetAngle() - MAX_PIVOT_ANGLE) > 500) {
  //     m_pivotMotor.set(Util.clamp(-setPower,-kMAX_PIVOT_POWER,kMAX_PIVOT_POWER));
  //   } else if (Math.abs(GetAngle() - MIN_PIVOT_ANGLE) > 500) {
  //     m_pivotMotor.set(Util.clamp(setPower,-kMAX_PIVOT_CORRECT_POWER,kMAX_PIVOT_CORRECT_POWER));
  //   }
  // }

  double GetAngle() {
    return m_pivotMotor.getSelectedSensorPosition();
  }
}