package uk.davidmoyse.ascendearth.world.tiles;

import java.awt.Color;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;
import uk.davidmoyse.ascendearth.world.util.Helper;

public class GrassTile extends Tile {

	public GrassTile(GameManager manager, int x, int y) {
		super(manager, x, y,
				new Sprite(new Color(Helper.getRandomNumberBetween(11, 7), Helper.getRandomNumberBetween(83, 57), 0)));
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
	}

}
