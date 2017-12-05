package io.github.davidm98.ascendearth.world;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.world.tiles.GrassTile;
import io.github.davidm98.ascendearth.world.tiles.StoneTile;
import io.github.davidm98.ascendearth.world.tiles.TestTile;
import io.github.davidm98.ascendearth.world.tiles.Tile;

public class World {

	/*
	 * The length of the world in tiles. The world is square. Multiply by the
	 * tile width to get the amount of pixels the world covers.
	 */
	public static final int WORLD_WIDTH = 75;
	public static final int WORLD_HEIGHT = 40;

	private int[][] pixels;
	private GameManager manager;
	private ArrayList<Tile> tiles;

	public World(GameManager manager) {
		this.pixels = new int[World.WORLD_WIDTH * Tile.TILE_SIZE][World.WORLD_HEIGHT * Tile.TILE_SIZE];
		this.manager = manager;
		this.tiles = new ArrayList<Tile>();

		generate();
	}

	public void generate() {
		// Subtract the tile size to make sure that there is not an
		// ArrayIndexOutOfBounds exception.
		for (int x = 0; x < pixels.length - Tile.TILE_SIZE; x += Tile.TILE_SIZE) {
			for (int y = 0; y < pixels[x].length - Tile.TILE_SIZE; y += Tile.TILE_SIZE) {
				if (new Random().nextInt(2) == 0) {
					tiles.add(new GrassTile(manager, x, y));
				} else {
					tiles.add(new StoneTile(manager, x, y));
				}
			}
		}

		for (Tile tile : tiles) {
			manager.addGameObject(tile);
		}
	}

	public int[][] getPixels() {
		return pixels;
	}

	public void setColourAtCoordinates(Color colour, int x, int y) {
		pixels[x][y] = colour.getRGB();
	}

	public Tile getTileFromCoordinates(int x, int y) {
		for (Tile tile : tiles) {
			if (tile.getLocation().getX() == x && tile.getLocation().getY() == y) {
				return tile;
			}
		}

		return null;
	}

	public int getWorldWidth() {
		return WORLD_WIDTH;
	}

	public int getWorldHeight() {
		return WORLD_HEIGHT;
	}

	public int getTotalNumberOfPixels() {
		return getWorldWidth() * Tile.TILE_SIZE * getWorldHeight() * Tile.TILE_SIZE;
	}

}
