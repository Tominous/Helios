package uk.davidmoyse.ascendearth.world.tiles;

import java.awt.Color;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;

public class StoneTile extends Tile {

	public StoneTile(GameManager manager, int x, int y) {
		super(manager, x, y);
	}

	@Override
	protected Sprite initSprite() {
		return new Sprite(Color.GRAY);
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
