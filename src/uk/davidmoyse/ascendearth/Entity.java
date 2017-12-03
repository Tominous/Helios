package uk.davidmoyse.ascendearth;

import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;

public abstract class Entity extends GameObject {

	protected Sprite sprite;

	public Entity(GameManager manager, int x, int y, int width, int height) {
		super(manager, x, y, width, height);
		this.sprite = initSprite();
	}

	protected abstract Sprite initSprite();

}
