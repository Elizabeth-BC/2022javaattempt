package frc.libs;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.InternalButton;

public final class DpadButton extends InternalButton {
	public static final int UP = 0, DOWN = 180, LEFT = 270, RIGHT = 90;
	private GenericHID hid;
	private int pov;

	public DpadButton(GenericHID hid, int pov) {
		super();
		this.hid = hid;
		this.pov = pov;
	}

	@Override
	public boolean get() {
		return hid.getPOV() == pov;
	}

	public void setPOV(int pov) {
		this.pov = pov;
	}

	public void setHID(GenericHID hid) {
		this.hid = hid;
	}
}
