package io.github.davidm98.ascendearth.world.tiles;

import io.github.davidm98.ascendearth.GameManager;
import io.github.davidm98.ascendearth.graphics.sprites.Sprite;
import io.github.davidm98.ascendearth.graphics.sprites.Spritesheet;

public class TreeTile extends Tile {

	public TreeTile(GameManager manager, int x, int y) {
		super(manager, x, y);
	}

	@Override
	protected Sprite initSprite() {
		Sprite sprite = new Sprite(Spritesheet.tiles, 11, 12, 21, 22);
//		for(int x  = 0; x < sprite.getPixels().length; x++) {
//			for(int y = 0; y < sprite.getPixels()[x].length; y++) {
//				System.out.println(sprite.getPixels()[x][y]);
//			}
//		}
		
		return sprite;
	}

	@Override
	public void update() {

	}

	@Override
	public void render() {
		paintSprite(sprite);
		
	}

}
