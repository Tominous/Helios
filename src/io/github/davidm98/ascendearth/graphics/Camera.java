package io.github.davidm98.ascendearth.graphics;

import java.awt.event.KeyEvent;

import io.github.davidm98.ascendearth.Game;
import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.GameObject;
import io.github.davidm98.ascendearth.world.World;
import io.github.davidm98.ascendearth.world.tiles.Tile;
import io.github.davidm98.ascendearth.world.util.Helper;
import io.github.davidm98.ascendearth.world.util.Location;

public class Camera extends GameObject {

	private static final double SCROLL_INTERVAL = 2.0;

	private Display display;
	// These camera coordinates refer to tile locations.
	private int maxOffsetX, maxOffsetY;

	public Camera(GameManager manager, Display display) {
		super(manager, 0, 0, Game.WIDTH, Game.HEIGHT);
		this.display = display;

		World world = manager.getGame().getWorld();

		int tempOffsetX = world.getPixels().length - width;
		this.maxOffsetX = Helper.clamp(tempOffsetX, 0, tempOffsetX);
		int tempOffsetY = world.getPixels()[0].length - height;
		this.maxOffsetY = Helper.clamp(tempOffsetY, 0, tempOffsetY);

		manager.addGameObject(this);
	}

	public void handleKeyInput(boolean pressed, int keyCode) {
		// If the key has not been pressed, it must have been released.

		final double setVel = pressed ? SCROLL_INTERVAL : 0.0;

		switch (keyCode) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			location.setVelY(-setVel);
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			location.setVelY(setVel);
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			location.setVelX(-setVel);
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			location.setVelX(setVel);
			break;
		}

	}

	@Override
	public void update() {
		int proposedX = (int) (location.getX() + location.getVelX());
		int proposedY = (int) (location.getY() + location.getVelY());

		location.setX(Helper.clamp(proposedX, 0, maxOffsetX));
		location.setY(Helper.clamp(proposedY, 0, maxOffsetY));
	}

	@Override
	public void render() {

	}

	public int getMaxOffsetX() {
		return maxOffsetX;
	}

	public int getMaxOffsetY() {
		return maxOffsetY;
	}

	public boolean isInView(GameObject object) {
		Location location = object.getLocation();
		int lbX = this.location.getX() - Tile.TILE_SIZE, ubX = this.location.getX() + Game.WIDTH + Tile.TILE_SIZE;
		int lbY = this.location.getY() - Tile.TILE_SIZE, ubY = this.location.getY() + Game.HEIGHT + Tile.TILE_SIZE;

		lbX = Helper.clamp(lbX, 0, lbX);
		lbY = Helper.clamp(lbY, 0, lbY);

		return !(location.getX() < lbX || location.getX() > ubX || location.getY() < lbY || location.getY() > ubY);
	}

}
