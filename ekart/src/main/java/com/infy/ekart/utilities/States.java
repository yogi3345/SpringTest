package com.infy.ekart.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.infy.ekart.entity.State;

public class States {

	private static List<String> allStates;

	public static List<String> getAllStates() {
		if (allStates == null)
			allStates = Arrays.stream(State.values()).map(str -> str.toString().replace("_", " "))
					.collect(Collectors.toList());
		return allStates;
	}

	public static State getStateFromString(String str) {
		return State.valueOf(str.replace(" ", "_"));
	}
	
	public static String getStringFromState(State state) {
		return state.name().replace("_", " ");
	}
}
