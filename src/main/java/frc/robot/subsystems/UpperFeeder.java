package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class UpperFeeder extends SubsystemBase implements HardwareAdapter{

  public UpperFeeder() {

  }

  public void runUpperFeeder() {
    upperFeederMotor.set(upperFeederPowerIn);
  }

  public void stopUpperFeeder() {
    upperFeederMotor.stopMotor();
  }
}