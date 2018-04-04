package model.instruments;

import model.Orchestra;

public abstract class StringInstrument implements Instrument {
	protected Orchestra orchestra;

	public StringInstrument(Orchestra orchestra) {
		this.orchestra = orchestra;
	}

	public void setOrchestra(Orchestra orchestra) {
		if(!this.orchestra.equals(orchestra)) {
			this.orchestra = orchestra;
			orchestra.addStringInstrument(this);
		}
	}

	@Override
	public boolean equals(Object o) {
		if(o == this) 
			return true;
		if(!(o instanceof StringInstrument))
			return false;

		StringInstrument other = (StringInstrument) o;

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
