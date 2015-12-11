package com.adventofcode.day6;

public class Ligth {
	
	private boolean turn;
	
	
	private Integer brightness;
	
	public Ligth(Integer brightness) {
		super();
		this.brightness = brightness;
	}

	public Integer getBrightness() {
		return brightness;
	}

	public void setBrightness(Integer brightness) {
		this.brightness = brightness;
	}
	
	

	public Ligth() {
		super();
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean state) {
		this.turn = state;
	}

	public void toggle() {
		if (isTurn()){
			setTurn(false);
		}else{
			setTurn(true);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (turn ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligth other = (Ligth) obj;
		if (turn != other.turn)
			return false;
		return true;
	}
	
	
	
	
	

}
