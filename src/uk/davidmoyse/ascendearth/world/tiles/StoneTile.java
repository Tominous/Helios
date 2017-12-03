package uk.davidmoyse.ascendearth.world.tiles;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;
import uk.davidmoyse.ascendearth.graphics.sprites.Spritesheet;

public class StoneTile extends Tile {

	public StoneTile(GameManager manager, int x, int y) {
		super(manager, x, y);
	}

	@Override
	protected Sprite initSprite() {
		return new Sprite(Spritesheet.tiles, 1);
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
