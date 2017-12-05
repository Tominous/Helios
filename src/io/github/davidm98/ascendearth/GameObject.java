package io.github.davidm98.ascendearth;

import io.github.davidm98.ascendearth.world.util.Location;

public abstract class GameObject {

	protected GameManager manager;
	protected Location location;
	protected int width;
	protected int height;

	public GameObject(GameManager manager, int x, int y, int width, int height) {
		this.manager = manager;
		this.location = new Location(x, y);
		this.width = width;
		this.height = height;
	}

	public abstract void update();

	public abstract void render();

	public Location getLocation() {
		return location;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
