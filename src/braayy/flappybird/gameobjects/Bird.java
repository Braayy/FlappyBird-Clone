package braayy.flappybird.gameobjects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import braayy.flappybird.GameCanvas;
import braayy.flappybird.textures.Textures;

public class Bird extends GameObject {

	private Image sprite;
	private short spriteStep;
	public float angle;
	private GameCanvas canvas;
	
	public Bird(int x, int y, int w, int h, GameCanvas canvas) {
		super(x, y, w, h, true);
		
		this.sprite = Textures.aberto;
		this.canvas = canvas;
	}

	@Override
	public void render(Graphics2D g) {
		angle += 0.2f;
		if (angle > 45) angle = 45;
		AffineTransform old = g.getTransform();
			g.rotate(Math.toRadians(angle), x + w / 2, y + h / 2);
			g.drawImage(this.sprite, x, y, w, h, null);
		g.setTransform(old);
	}

	@Override
	public void update(Graphics2D g) {
		this.spriteStep++;
		if (this.spriteStep > 100) {
			this.spriteStep = 0;
			
			if (this.sprite.equals(Textures.aberto)) {
				this.sprite = Textures.fechado;
			} else {
				this.sprite = Textures.aberto;
			}
		}
		
		if (y + h >= canvas.getHeight()) {
			canvas.gameOver();
			y = canvas.getHeight() - h;
			v = 0;
		}
		
		if (y < 0) {
			canvas.gameOver();
			y = 0;
			v = 0;
		}
		
		Cano[] canos = canvas.getCanos();
		
		for (int i = 0; i < canos.length; i++) {
			if (canos[i] != null && x > canos[i].x + canos[i].w && !canos[i].passado) {
				canvas.pontos++;
				canos[i].passado = true;
			}
		}
	}

	public void jump() {
		v = 0;
		applyForce(10);
		angle = -45;
	}

}