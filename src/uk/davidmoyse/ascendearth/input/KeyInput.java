package uk.davidmoyse.ascendearth.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.graphics.Camera;

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
