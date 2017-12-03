package uk.davidmoyse.ascendearth.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import uk.davidmoyse.ascendearth.Game;
import uk.davidmoyse.ascendearth.GameManager;

public class Display {

	private GameManager manager;
	private int[][] pixels;

	private BufferedImage image;
	private int[] display;

	private Camera camera;

	public Display(GameManager manager) {
		this.manager = manager;
		this.pixels = new int[Game.WIDTH][Game.HEIGHT];

		this.image = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.display = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		this.camera = new Camera(manager, this);
	}

	public void render(Graphics g) {
		manager.render();

		// Copy pixel data from the world to the display.
		for (int x = 0; x < Game.WIDTH; x++) {
			for (int y = 0; y < Game.HEIGHT; y++) {
				int cameraX = x + camera.getLocation().getX(), cameraY = y + camera.getLocation().getY();

				int[][] worldPixels = manager.getGame().getWorld().getPixels();

				if (cameraX < worldPixels.length && cameraX >= 0 && cameraY < worldPixels[0].length && cameraY >= 0) {
					// Set the new pixels.
					pixels[x][y] = worldPixels[cameraX][cameraY];
				}
			}
		}

		ArrayList<Integer> copy = convert(pixels);
		for (int i = 0; i < copy.size(); i++) {
			display[i] = copy.get(i);
		}

		g.drawImage(image, 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}

	private ArrayList<Integer> convert(int[][] pixels) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int y = 0; y < pixels[0].length; y++) {
			for (int x = 0; x < pixels.length; x++) {
				list.add(pixels[x][y]);
			}
		}

		return list;
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
