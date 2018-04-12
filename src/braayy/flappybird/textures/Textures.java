package braayy.flappybird.textures;

import java.awt.Image;
import java.lang.reflect.Field;

import javax.imageio.ImageIO;

import braayy.flappybird.GameCanvas;

public class Textures {
	
	public static Image aberto, fechado, chao, titulo, dica, cima, baixo;
	public static Image n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;
	
	static {
		try {
			aberto = ImageIO.read(Textures.class.getResource("aberto.png"));
			fechado = ImageIO.read(Textures.class.getResource("fechado.png"));
			chao = ImageIO.read(Textures.class.getResource("chao.png"));
			titulo = ImageIO.read(Textures.class.getResource("titulo.png"));
			dica = ImageIO.read(Textures.class.getResource("dica.png"));
			cima = ImageIO.read(Textures.class.getResource("cima.png"));
			baixo = ImageIO.read(Textures.class.getResource("baixo.png"));
			
			n0 = ImageIO.read(Textures.class.getResource("n0.png"));
			n1 = ImageIO.read(Textures.class.getResource("n1.png"));
			n2 = ImageIO.read(Textures.class.getResource("n2.png"));
			n3 = ImageIO.read(Textures.class.getResource("n3.png"));
			n4 = ImageIO.read(Textures.class.getResource("n4.png"));
			n5 = ImageIO.read(Textures.class.getResource("n5.png"));
			n6 = ImageIO.read(Textures.class.getResource("n6.png"));
			n7 = ImageIO.read(Textures.class.getResource("n7.png"));
			n8 = ImageIO.read(Textures.class.getResource("n8.png"));
			n9 = ImageIO.read(Textures.class.getResource("n9.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void drawPoints(GameCanvas canvas) {
		try {
			char[] chars = String.valueOf(canvas.pontos).toCharArray();
			int x = 0;
			for (char c : chars) {
				Field f = Textures.class.getDeclaredField("n" + c);
				f.setAccessible(true);
				
				Image number = (Image) f.get(null);
				canvas.getGraphics2D().drawImage(number, getCenter(canvas, number, x), 2, number.getWidth(null) * 2, number.getHeight(null) * 2, null);
				x += number.getWidth(null) * 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int getCenter(GameCanvas canvas, Image img, int offset) {
		return canvas.getWidth() / 2 - img.getWidth(null) / 2 + offset;
	}
	
}