package io.github.davidm98.ascendearth.world.tiles;

import java.awt.Color;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.graphics.sprites.Sprite;

public class TestTile extends Tile {

	public TestTile(GameManager manager, int x, int y) {
		super(manager, x, y);
	}

	@Override
	protected Sprite initSprite() {
		return new Sprite(Color.RED);
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
