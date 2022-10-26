package frc.robot.subsystems;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.HardwareAdapter;

public class Debug implements HardwareAdapter{

  static final void debugDashSend(String s, Sendable x) {
    if (DEBUG) {
      SmartDashboard.putData(s, x);
    }
  }
  static final void debugDashNum(String s, double x) {
    if (DEBUG) {
      SmartDashboard.putNumber(s, x);
    }
  }
  static final void debugCons(String x) {
    if (DEBUG) {
      System.out.println(x);
    }
  }
}