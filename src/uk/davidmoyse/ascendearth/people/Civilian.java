package uk.davidmoyse.ascendearth.people;

import uk.davidmoyse.ascendearth.GameManager;
import uk.davidmoyse.ascendearth.civilisation.Civilisation;
import uk.davidmoyse.ascendearth.graphics.sprites.Sprite;

public class Civilian extends Person {

	public Civilian(GameManager manager, int spawnX, int spawnY, Civilisation civilisation) {
		super(manager, spawnX, spawnY, civilisation);
	}

	@Override
	protected Sprite initSprite() {
		int[][] pixels = new int[super.width][super.height];
		
		
	}
	
	@Override
	public void update() {

	}

	@Override
	public void render() {

	}

}
