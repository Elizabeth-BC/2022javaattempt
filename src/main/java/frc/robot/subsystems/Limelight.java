package frc.robot.subsystems;

import frc.robot.HardwareAdapter;

class Limelight implements HardwareAdapter{
  double distanceFromLimeLightToGoalInches;
  double horizontalAngleToTarget;
  double angleForPivot;

  Limelight() {

  }

  boolean HaveTarget() {
    double m_target = GetDistance();
    if (m_target > 0) {
      return true;
    } else {
      return false;
    }
  }

  double GetDistance() {
    return table.getEntry("tv").getDouble(0.0);
  }

  double getXoffset() {
    return table.getEntry("tx").getDouble(0.0);
  }

  double getYoffset() {
    return table.getEntry("ty").getDouble(0.0);
  }
}