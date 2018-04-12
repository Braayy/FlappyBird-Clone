package braayy.flappybird.threads;

import braayy.flappybird.GameCanvas;

public class GameThread extends Thread {
	
	private GameCanvas canvas;
	
	public GameThread(GameCanvas canvas) {
		super("GameThread");
		
		this.canvas = canvas;
	}
	
	@Override
	public void run() {
		while (true) {
			canvas.render();
			canvas.update();
		}
	}
	
}