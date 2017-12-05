package io.github.davidm98.ascendearth.graphics.sprites;

import java.awt.Color;

import io.github.davidm98.ascendearth.world.tiles.Tile;

public class Sprite {

	private int[][] pixels;

	public Sprite(Spritesheet sheet, Integer... imageNumbers) {
		int[][] pixels = new int[Tile.TILE_SIZE * (imageNumbers.length + 1)][Tile.TILE_SIZE
				* (imageNumbers.length + 1)];
		for (int i = 0; i < imageNumbers.length; i++) {
			int[][] temp = sheet.getImages().get(imageNumbers[i]);
			for (int x = 0; x < temp.length; x++) {
				for (int y = 0; y < temp[x].length; y++) {
					int multiplyBy = i == 0 ? 1 : i;
					pixels[x * multiplyBy][y * multiplyBy] = temp[x][y];
				}
			}
		}

		this.pixels = pixels;
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
