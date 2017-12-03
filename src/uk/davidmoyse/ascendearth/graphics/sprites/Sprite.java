package uk.davidmoyse.ascendearth.graphics.sprites;

import java.awt.Color;

import uk.davidmoyse.ascendearth.world.tiles.Tile;

public class Sprite {

	private int[][] pixels;

	public Sprite(Spritesheet sheet, int imageNumber) {
		this.pixels = sheet.getImages().get(imageNumber);
	}

	public Sprite(Color colour) {
		pixels = new int[Tile.TILE_SIZE][Tile.TILE_SIZE];

		for (int x = 0; x < pixels.length; x++) {
			for (int y = 0; y < pixels[x].length; y++) {
				pixels[x][y] = colour.getRGB();
			}
		}
	}

	public Sprite(int[][] pixels) {
		this.pixels = pixels;
	}

	public int[][] getPixels() {
		return pixels;
	}

}
