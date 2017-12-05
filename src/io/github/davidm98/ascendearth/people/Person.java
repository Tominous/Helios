package io.github.davidm98.ascendearth.people;

import java.awt.Color;

import io.github.davidm98.ascendearth.Entity;
import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.civilisation.Civilisation;
import io.github.davidm98.ascendearth.world.tiles.Tile;
import io.github.davidm98.ascendearth.world.util.Helper;

public abstract class Person extends Entity {

	// General
	private Sex sex;
	private Civilisation civilisation;

	private boolean alive = true;

	// Appearance
	private Color hairColour;
	private Color eyeColour;

	// Creating a random person.
	public Person(GameManager manager, int spawnX, int spawnY, Civilisation civilisation) {
		super(manager, spawnX, spawnY, Tile.TILE_SIZE, Tile.TILE_SIZE * 2);

		this.sex = Sex.values()[Helper.getRandomNumberBetween(Sex.values().length, 0)];
		this.civilisation = civilisation;
		
		this.hairColour = initHairColour();
		this.eyeColour = initEyeColour();
	}

	private Color initEyeColour() {
		// Based on information from ScotlandsDNA

		int random = Helper.getRandomNumberBetween(100, 0);
		int colour = 0;

		if (random <= 15) {
			// Green
			colour = 0x407847;
		} else if (random > 15 && random <= 30) {
			// Hazel
			colour = 0xA13C00;
		} else if (random > 30 && random <= 60) {
			// Dark brown
			colour = 0x4B200D;
		} else {
			// Blue
			colour = 0x588394;
		}

		return new Color(colour);
	}

	private Color initHairColour() {
		// Data based on information from Wikipedia.

		int random = Helper.getRandomNumberBetween(100, 0);
		int colour = 0;

		if (random <= 4) {
			// Red
			colour = 0xAE5F26;
		} else if (random > 4 && random <= 14) {
			// Blond(e)
			colour = 0xA2805A;
		} else if (random > 14 && random <= 20) {
			// Black
			colour = 0x0F0E0C;
		} else {
			// Brown/brunette
			colour = 0x3D2F2E;
		}

		return new Color(colour);
	}

	public Civilisation getCivilisation() {
		return civilisation;
	}

	public void setCivilisation(Civilisation civilisation) {
		this.civilisation = civilisation;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Sex getSex() {
		return sex;
	}

	public Color getEyeColour() {
		return eyeColour;
	}

	public Color getHairColour() {
		return hairColour;
	}

}
