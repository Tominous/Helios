package uk.davidmoyse.ascendearth.world.tiles;

import java.awt.Color;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;

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
