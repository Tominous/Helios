package io.github.davidm98.ascendearth.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.graphics.Camera;

public class KeyInput implements KeyListener {

	private GameManager manager;
	private Camera camera;

	public KeyInput(GameManager manager) {
		this.manager = manager;
		this.camera = manager.getGame().getDisplay().getCamera();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		camera.handleKeyInput(true, e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		camera.handleKeyInput(false, e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
