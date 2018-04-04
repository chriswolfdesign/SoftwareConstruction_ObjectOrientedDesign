package model.instruments;

import model.Orchestra;

public abstract class BrassInstrument implements Instrument {
	protected Orchestra orchestra;

	public BrassInstrument(Orchestra orchestra) {
		this.orchestra = orchestra;
	}

	public void setOrchestra(Orchestra orchestra) {
		if(!this.orchestra.equals(orchestra)) {
			this.orchestra = orchestra;
			orchestra.addBrassInstrument(this);
		}
	}

	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof BrassInstrument))
			return false;

		BrassInstrument other = (BrassInstrument) o;

		if(orchestra != null)
			return orchestra.equals(other.orchestra);
		else
			return other.orchestra == null;
	}

	@Override
	public int hashCode() {
		if(orchestra != null)
			return orchestra.hashCode();
		else
			return 0;
	}
}
