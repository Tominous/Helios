package uk.davidmoyse.ascendearth.world.tiles;

import java.awt.Color;

import uk.davidmoyse.ascendearth.Entity;
import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;

public abstract class Tile extends Entity {

	public static final int TILE_SIZE =32;

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
