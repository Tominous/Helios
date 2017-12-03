package uk.davidmoyse.ascendearth.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import uk.davidmoyse.ascendearth.Game;
import uk.davidmoyse.ascendearth.GameManager;

public class Display {

	private GameManager manager;
	private int[][] pixels;

	private BufferedImage image;

	private Camera camera;

	public Display(GameManager manager) {
		this.manager = manager;
		this.pixels = new int[Game.WIDTH][Game.HEIGHT];

		this.image = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);

		this.camera = new Camera(manager, this);
	}

	public void render(Graphics g) {

		// Copy pixel data from the world to the display.
		for (int x = 0; x < Game.WIDTH; x++) {
			for (int y = 0; y < Game.HEIGHT; y++) {
				int cameraX = x + camera.getLocation().getX(), cameraY = y + camera.getLocation().getY();

				int colour = Color.BLACK.getRGB();

				int[][] worldPixels = manager.getGame().getWorld().getPixels();

				if (cameraX < worldPixels.length && cameraX >= 0 && cameraY < worldPixels[0].length && cameraY >= 0) {
					// Set the new pixels.
					pixels[x][y] = worldPixels[cameraX][cameraY];
					colour = pixels[x][y];
					image.setRGB(x, y, colour);
				}
			}
		}

		g.drawImage(image, 0, 0, null);

		manager.render();
	}

	public void clear() {
		for (int x = 0; x < pixels.length; x++) {
			for (int y = 0; y < pixels[x].length; y++) {
				pixels[x][y] = Color.BLACK.getRGB();
			}
		}
	}

	public int[][] getPixels() {
		return pixels;
	}

	public Camera getCamera() {
		return camera;
	}

}
