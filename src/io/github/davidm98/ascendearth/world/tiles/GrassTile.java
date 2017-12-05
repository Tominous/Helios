package io.github.davidm98.ascendearth.world.tiles;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.graphics.sprites.Sprite;
import io.github.davidm98.ascendearth.graphics.sprites.Spritesheet;

public class GrassTile extends Tile {

	public GrassTile(GameManager manager, int x, int y) {
		super(manager, x, y);
	}


	@Override
	protected Sprite initSprite() {
		return new Sprite(Spritesheet.tiles, 0);
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
