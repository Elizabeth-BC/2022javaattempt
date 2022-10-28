package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;


public class Drivetrain extends SubsystemBase implements HardwareAdapter{
  
  private final DifferentialDrive dt = new DifferentialDrive(leftSideMotors, rightSideMotors);

  public Drivetrain() { 
    leftMotor1.setClosedLoopRampRate(driveRampTime);
    leftMotor2.setClosedLoopRampRate(driveRampTime);
    rightMotor1.setClosedLoopRampRate(driveRampTime);
    rightMotor2.setClosedLoopRampRate(driveRampTime);

    dt.setSafetyEnabled(false);
  }

  public void arcadeDrive(double Y, double X, double Z) {
    dt.arcadeDrive(-Y, X);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    dt.tankDrive(leftSpeed, rightSpeed, false); 
  }

  // public void timedTurn(TurnMode mode, double throttle) {
	// 	if (mode == TurnMode.Left) tankDrive(-throttle, throttle);
	// 	if (mode == TurnMode.Right) tankDrive(throttle, -throttle);
	// }

  public void Stop() {
    dt.stopMotor();
  }
}
