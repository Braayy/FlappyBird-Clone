package braayy.flappybird;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import braayy.flappybird.threads.GameThread;

public class GameWindow extends JFrame {

	private static final long serialVersionUID = -4301762219102812266L;
	private GameCanvas canvas;
	
	public GameWindow() {
		canvas = new GameCanvas();
		
		this.setTitle("FlappyBird");
		this.setResizable(false);
		this.add(canvas);
		this.pack();
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void start() {
		new GameThread(canvas).start();
		
		this.setVisible(true);
	}

	public GameCanvas getCanvas() {
		return canvas;
	}
	
}