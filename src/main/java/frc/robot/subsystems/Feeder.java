package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Feeder {
  
  public Feeder() {

  }

  void runFeeder() {
    m_feederMotor.set(FEEDER_POWER_IN);
  }

  void reverseFeeder() {
    m_feederMotor.set(FEEDER_POWER_OUT);
  }

  void stopFeeder() {
    m_feederMotor.stopMotor();
  }
}

class UpperFeeder {

  UpperFeeder() {
    m_upperfeederMotor.clearStickyFaults();
  }

  void runUpperFeeder() {
    m_upperfeederMotor.set(UPPER_FEEDER_POWER_IN);
  }

  void stopUpperFeeder() {
    m_upperfeederMotor.stopMotor();
  }
}