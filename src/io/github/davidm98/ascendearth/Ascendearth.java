package io.github.davidm98.ascendearth;

import javax.swing.JFrame;

public class Ascendearth {

	// The starting class file.

	public static void main(String[] args) {
		Game game = new Game();

		JFrame frame = new JFrame();
		frame.add(game);
		frame.setTitle("Ascendearth");
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}

}
