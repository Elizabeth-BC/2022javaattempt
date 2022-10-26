package frc.libs;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.Button;

public final class AnalogButton extends Button {
	private GenericHID joystick;
	private int axisNumber;
	private double threshold = 0.5;

	public AnalogButton(GenericHID joystick, int axisNumber) {
		this.joystick = joystick;
		this.axisNumber = axisNumber;
	}

	public AnalogButton(GenericHID joystick, int axisNumber, double threshold) {
		this.joystick = joystick;
		this.axisNumber = axisNumber;
		this.threshold = threshold;
	}

	public void setthreshold(double threshold) {
		this.threshold = threshold;
	}

	public double getThreshold() {
		return threshold;
	}

	public boolean get() {
		if (threshold < 0)
			return joystick.getRawAxis(axisNumber) < threshold; 
		else
			return joystick.getRawAxis(axisNumber) > threshold; 
	}
}
