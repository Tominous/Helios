package io.github.davidm98.ascendearth.graphics.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import io.github.davidm98.ascendearth.world.tiles.Tile;

public class Spritesheet {

	public static Spritesheet tiles = new Spritesheet("tiles");

	private BufferedImage spritesheet;
	private ArrayList<int[][]> images;

	public Spritesheet(String path) {
		try {
			this.spritesheet = ImageIO.read(this.getClass().getResourceAsStream("/" + path + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.images = new ArrayList<int[][]>();

		loadImages();
	}

	// Loads the images into the image array from left to right and top to
	// bottom.
	private void loadImages() {

		int[][] pixels = createNewPixelsArray();

		// Add a loop here for the height
		for (int iy = 1; iy < spritesheet.getHeight() / Tile.TILE_SIZE; iy++) {
			for (int ix = 1; ix < spritesheet.getWidth() / Tile.TILE_SIZE; ix++) {
				for (int x = 0; x < Tile.TILE_SIZE; x++) {
					for (int y = 0; y < Tile.TILE_SIZE; y++) {
						int actualIX = ix - 1;
						int actualIY = iy - 1;
						int actualX = (Tile.TILE_SIZE * actualIX) + x;
						int actualY = (Tile.TILE_SIZE * actualIY) + y;

						int colour = spritesheet.getRGB(actualX, actualY);

						// Colour of transparency = -65286

						pixels[x][y] = colour;
					}
				}

				images.add(pixels);
				System.out.println(images.size());
				pixels = createNewPixelsArray();
			}
		}
	}

	private int[][] createNewPixelsArray() {
		return new int[Tile.TILE_SIZE][Tile.TILE_SIZE];
	}

	public ArrayList<int[][]> getImages() {
		return images;
	}

}
