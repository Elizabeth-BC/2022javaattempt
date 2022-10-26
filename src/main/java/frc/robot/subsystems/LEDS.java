package frc.robot.subsystems;

import frc.robot.HardwareAdapter;

class LEDS implements HardwareAdapter{
  LEDS() {
  }

  void ChangeLEDColors(double SetColor) {
    BlinkinLEDDriver.set(SetColor);
  }
}