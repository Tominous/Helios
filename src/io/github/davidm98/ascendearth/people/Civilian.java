package io.github.davidm98.ascendearth.people;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.civilisation.Civilisation;
import io.github.davidm98.ascendearth.graphics.sprites.Sprite;

public class Civilian extends Person {

	public Civilian(GameManager manager, int spawnX, int spawnY, Civilisation civilisation) {
		super(manager, spawnX, spawnY, civilisation);
	}

	@Override
	protected Sprite initSprite() {
		int[][] pixels = new int[super.width][super.height];

		return null;
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {

	}

}
