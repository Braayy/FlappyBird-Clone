package braayy.flappybird.gameobjects;

import java.awt.Graphics2D;

import braayy.flappybird.GameCanvas;
import braayy.flappybird.textures.Textures;

public class Cano extends GameObject {

	private short step;
	private GameCanvas canvas;
	public boolean passado;
	
	public Cano(int x, int y, int w, int h, GameCanvas canvas) {
		super(x, y, w, h, false);
		
		this.canvas = canvas;
		this.y = -randomY();
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(Textures.cima, x, y, w, h, null);
		
		g.drawImage(Textures.baixo, x, y + h + 130, w, h, null);
	}
	
	@Override
	public void update(Graphics2D g) {
		step++;
		if (step > 1) {
			step = 0;
			x -= 1;
			
			if (x + w < 0) {
				x = canvas.getWidth() + w * 2;
				y = -randomY();
				passado = false;
			}
		}
		
		if (canvas.getBird() != null && isColliding(canvas.getBird())) canvas.gameOver();
	}
	
	private boolean isColliding(GameObject gameObject) {
		return x < gameObject.x + gameObject.w &&
				x + w > gameObject.x &&
				y < gameObject.y + gameObject.h &&
				y + h > gameObject.y;
	}

	private int randomY() {
		int min = 150;
		int max = 450;
		
		return canvas.random.nextInt(max - min + 1) + min;
	}
	
}