package braayy.flappybird.gameobjects;

import java.awt.Graphics2D;

public abstract class GameObject {
	
	public int x, y, w, h, v;
	public boolean gravity;

	public GameObject(int x, int y, int w, int h, boolean gravity) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.v = 0;
		this.gravity = gravity;
	}

	public abstract void render(Graphics2D g);
	public abstract void update(Graphics2D g);

	public void applyForce(int force) {
		v -= force;
		y += v;
	}
	
	public void applyGravity() {
		y += v;
	}
	
}