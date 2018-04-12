package braayy.flappybird;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import braayy.flappybird.gameobjects.Bird;
import braayy.flappybird.gameobjects.Cano;
import braayy.flappybird.textures.Textures;

public class GameCanvas extends Canvas {

	private static final long serialVersionUID = 2756213297999312843L;
	private boolean gameOver;
	private Menu menu;
	public Random random;
	private Cano[] canos = new Cano[3];
	private Bird bird;
	public int pontos;
	
	public GameCanvas() {
		this.setSize(800, 600);
		
		menu = new Menu(this);
		gameOver = true;
		random = new Random();
		
		EventHandler handler = new EventHandler(this);
		addKeyListener(handler);
		addMouseListener(handler);
	}
	
	public void render() {
		if (getBufferStrategy() == null) createBufferStrategy(3);
		Graphics2D g = getGraphics2D();
		
		g.setColor(new Color(155, 183, 196));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (!gameOver) {
			if (bird != null) bird.render(g);
			for (int i = 0; i < canos.length; i++) {
				if (canos[i] != null) canos[i].render(g);
			}
			
			Textures.drawPoints(this);
		} else {
			menu.render(g);
		}
		
		g.dispose();
		getBufferStrategy().show();
	}
	
	public void update() {
		if (!gameOver) {
			Graphics2D g = getGraphics2D();
			
			if (bird != null) bird.update(g);
			for (int i = 0; i < canos.length; i++) {
				if (canos[i] != null) canos[i].update(g);
			}
		}
	}
	
	public Bird getBird() {
		return bird;
	}
	
	public Cano[] getCanos() {
		return canos;
	}
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D) getBufferStrategy().getDrawGraphics();
	}
	
	public boolean reset() {
		if (!gameOver) return false;
		gameOver = false;
		
		init();
		
		return true;
	}
	
	public void init() {
		int bwidth = Textures.aberto.getWidth(null) * 3;
    	int bheight = Textures.aberto.getHeight(null) * 3;
    	bird = new Bird(50, 50, bwidth, bheight, this);
    	
    	for (int i = 0; i < canos.length; i++) {
	    	int cwidth = Textures.cima.getWidth(null) * 2;
			int cheight= Textures.cima.getHeight(null) * 2;
			canos[i] = new Cano(500 + i * 400, 0, cwidth, cheight, this);
    	}
    	
    	menu.highscore = false;
	}
	
	public void gameOver() {
		gameOver = true;
		
		bird = null;
		for (int i = 0; i < canos.length; i++) {
			canos[i] = null;
		}
		
		if (pontos > 0) {
    		if (pontos > FlappyBird.highscore) {
    			FlappyBird.highscore = pontos;
    			menu.highscore = true;
    			
    			FlappyBird.save();
    		}
    	}
    	pontos = 0;
	}

	public boolean isGameOver() {
		return gameOver;
	}

}