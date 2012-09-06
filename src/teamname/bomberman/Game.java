package teamname.bomberman;

import teamname.bomberman.entity.Player;

/**
 * Runs a Bomberman game.
 *
 */
public class Game extends Thread {

	private final long SLEEP_TIME = 50;

	private boolean gameRunning;

	private final World world;

	private GamePainter painter;

	public Game(int worldWidth, int worldHeight, Player[] players) {
		world = new World(worldWidth, worldHeight, players);
	}

	public void setPainter(GamePainter painter) {
		this.painter = painter;
	}

	/**
	 * Start or stop the game from running.
	 */
	public void setRunning(boolean running) {
		gameRunning = running;
		if (gameRunning && !isAlive()) start();
	}

	/**
	 * Maintains the update/render cycle.
	 */
	@Override
	public void run() {
		while (gameRunning) {
			update();
			render();

			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	}

	/**
	 * Take input and update the game state.
	 */
	private void update() {

	}

	/**
	 * Draw the game state.
	 */
	private void render() {
		painter.repaint();
	}

	public World getWorld() {
		return world;
	}
}