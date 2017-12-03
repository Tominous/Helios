package uk.davidmoyse.ascendearth.world.tiles;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;
import uk.davidmoyse.ascendearth.graphics.sprites.Spritesheet;

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
