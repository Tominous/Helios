package uk.davidmoyse.ascendearth.civilisation;

import java.awt.Color;

public class Civilisation {

	private String name;
	private Color colour;

	public Civilisation(String name, Color colour) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Color getColour() {
		return colour;
	}

}
