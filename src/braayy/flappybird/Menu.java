package braayy.flappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import braayy.flappybird.textures.Textures;

public class Menu {
	
	private GameCanvas canvas;
	public boolean highscore;
	
	public Menu(GameCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void render(Graphics2D g) {
		int twidth = Textures.titulo.getWidth(null) * 2;
		int theight = Textures.titulo.getHeight(null) * 2;
		int tx = canvas.getWidth() / 2 - twidth / 2;
		
		g.drawImage(Textures.titulo, tx, 50, twidth, theight, null);
		
		int dwidth = Textures.dica.getWidth(null) * 2;
		int dheight = Textures.dica.getHeight(null) * 2;
		int dx = canvas.getWidth() / 2 - dwidth / 2;
		
		g.drawImage(Textures.dica, dx, theight + 70, dwidth, dheight, null);
		
		if (highscore) {
			String text = "NEW HIGHSCORE!";
			
			g.setColor(Color.BLACK);
			g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 50));
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.drawString(text, canvas.getWidth() / 2 - g.getFontMetrics().stringWidth(text) / 2, dheight + 260);
		}
	}
	
}