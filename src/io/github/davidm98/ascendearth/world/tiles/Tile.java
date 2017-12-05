package io.github.davidm98.ascendearth.world.tiles;

import java.awt.Color;

import io.github.davidm98.ascendearth.Entity;
import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.graphics.sprites.Sprite;

public abstract class Tile extends Entity {

	public static final int TILE_SIZE = 16;

	public Tile(GameManager manager, int x, int y) {
		super(manager, x, y, TILE_SIZE, TILE_SIZE);
	}

	protected void paintSprite(Sprite sprite) {
		int px = location.getX(), py = location.getY();

		for (int ix = px; ix < px + TILE_SIZE; ix++) {
			for (int iy = py; iy < py + TILE_SIZE; iy++) {
				Color colour = new Color(sprite.getPixels()[ix - px][iy - py]);

				// Colour of transparency = -65286

				if (colour.getRGB() != -65286) {
					manager.getGame().getWorld().setColourAtCoordinates(colour, ix, iy);
				}
			}
		}
	}

}
