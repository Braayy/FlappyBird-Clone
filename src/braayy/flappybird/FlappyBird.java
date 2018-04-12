package braayy.flappybird;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.Timer;

public class FlappyBird {
	
	private static final int GRAVITY = 1;
	public static int highscore;
	
    public static void main(String[] args) {
    	GameWindow game = new GameWindow();
    	load();
    	game.getCanvas().init();
    	game.start();
    	
    	new Timer(21, (e) -> {
    		if (game.getCanvas().isGameOver()) return;
			if (game.getCanvas().getBird() == null) return;
			game.getCanvas().getBird().v += GRAVITY;
			game.getCanvas().getBird().applyGravity();
    	}).start();
    }
    
    public static void load() {
    	try {
    		FileInputStream in = new FileInputStream("highscore.txt");
			byte[] buffer = new byte[128];
			int c = in.read(buffer);
			
			highscore = Integer.parseInt(new String(buffer, 0, c));
			in.close();
		} catch (Exception e) {
			if (e instanceof FileNotFoundException) {
				try {
					new FileOutputStream("highscore.txt").close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
    }
    
    public static void save() {
    	try {
			FileOutputStream out = new FileOutputStream("highscore.txt");
			
			out.write(String.valueOf(highscore).getBytes());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}