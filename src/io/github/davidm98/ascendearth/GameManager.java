package io.github.davidm98.ascendearth;

import java.util.ArrayList;

public class GameManager {

	private Game game;
	private ArrayList<GameObject> gameObjects;

	public GameManager(Game game) {
		this.game = game;
		this.gameObjects = new ArrayList<GameObject>();
	}

	public Game getGame() {
		return game;
	}

	public void update() {
		for (GameObject object : gameObjects) {
			object.update();
		}
	}

	public void render() {
		for (GameObject object : gameObjects) {
			if (game.getDisplay().getCamera().isInView(object)) {
				object.render();
			}
		}
	}

	public void addGameObject(GameObject object) {
		gameObjects.add(object);
	}

	public void removeGameObject(GameObject object) {
		gameObjects.remove(object);
	}

}
