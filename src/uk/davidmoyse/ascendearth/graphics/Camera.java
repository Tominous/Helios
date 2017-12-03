package uk.davidmoyse.ascendearth.graphics;

import java.awt.event.KeyEvent;

import uk.davidmoyse.ascendearth.Game;
import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.GameObject;
import uk.davidmoyse.ascendearth.world.World;
import uk.davidmoyse.ascendearth.world.util.Helper;

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

}
