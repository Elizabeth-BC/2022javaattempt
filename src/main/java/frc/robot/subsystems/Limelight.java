package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Limelight extends SubsystemBase implements HardwareAdapter{
  double distanceFromLimeLightToGoalInches;
  double horizontalAngleToTarget;
  double angleForPivot;

  public Limelight() {

  }

  public boolean HaveTarget() {
    double m_target = GetDistance();
    if (m_target > 0) {
      return true;
    } else {
      return false;
    }
  }

  public double GetDistance() {
    return table.getEntry("tv").getDouble(0.0);
  }

  public double getXoffset() {
    return table.getEntry("tx").getDouble(0.0);
  }

  public double getYoffset() {
    return table.getEntry("ty").getDouble(0.0);
  }
}