package uk.davidmoyse.ascendearth.world.tiles;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;
import uk.davidmoyse.ascendearth.graphics.sprites.Spritesheet;

public class TestTile extends Tile {

	public TestTile(GameManager manager, int x, int y) {
		super(manager, x, y, new Sprite(Spritesheet.characters, 0));
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
