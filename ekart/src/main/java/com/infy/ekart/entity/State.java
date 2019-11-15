package com.infy.ekart.entity;

public enum State {

	CHANDIGARH(0), PUNJAB(1), HARYANA(2), HIMACHAL_PRADESH(3), DELHI(4);

	private int value;

	State(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.name();
	}

	public static State state(int s) {

		for (State state : State.values()) {
			if (state.getValue()==s)
				return state;
		}
		throw new IllegalArgumentException("No matching State type for " + String.valueOf(s));
	}

}
