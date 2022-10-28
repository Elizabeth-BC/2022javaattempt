package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;

public class Feeder extends SubsystemBase implements HardwareAdapter{
  
  public Feeder() {

  }

  public void runFeeder() {
    mainFeederMotor.set(mainFeederPowerIn);
  }

  public void reverseFeeder() {
    mainFeederMotor.set(mainFeederPowerOut);
  }

  public void stopFeeder() {
    mainFeederMotor.stopMotor();
  }
}