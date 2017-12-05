package io.github.davidm98.ascendearth.world.util;

import io.github.davidm98.ascendearth.world.tiles.Tile;

public class Location {

	/*
	 * Locations refer to the coordinates of a tile. In the case that an object
	 * takes up more than one tile, the location of the centre tile will be
	 * returned.
	 */

	private int x, y;
	private double velX, velY;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
		this.velX = velY = 0.0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getTileX() {
		return (int) (x / Tile.TILE_SIZE);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTileY() {
		return (int) (y / Tile.TILE_SIZE);
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

}
