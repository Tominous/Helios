package io.github.davidm98.ascendearth;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import io.github.davidm98.ascendearth.graphics.Display;
import io.github.davidm98.ascendearth.input.KeyInput;
import io.github.davidm98.ascendearth.world.World;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 960, HEIGHT = WIDTH / 16 * 9;

	private boolean running;
	private Thread thread;
	private GameManager manager;
	private World world;
	private Display display;
	private KeyInput keyInput;

	public Game() {
		this.running = false;
		this.manager = new GameManager(this);
		this.world = new World(manager);
		this.display = new Display(manager);
		this.keyInput = new KeyInput(manager);

		addKeyListener(keyInput);

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();

		running = true;
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// Game updates 60 times per second and renders the game (at a higher
		// rate)

		// Credit to TheChernoProject for demonstrating this game loop.
		// https://www.youtube.com/user/TheChernoProject
		int frames = 0;

		long lastTime = System.nanoTime();
		double ns = 1_000_000_000.0 / 60.0;
		double delta = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();

			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				update();
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}

		}

		stop();
	}

	public void update() {
		this.requestFocus();
		manager.update();
	}

	public void render() {
		BufferStrategy buffer = this.getBufferStrategy();

		if (buffer == null) {
			this.createBufferStrategy(5);
			return;
		}

		// Get the BufferStrategy's graphics, not the graphics of the canvas!
		// (NOT this.getGraphics()!)
		Graphics g = buffer.getDrawGraphics();

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		display.render(g);

		g.dispose();
		buffer.show();
	}

	public Display getDisplay() {
		return display;
	}

	public World getWorld() {
		return world;
	}

}
