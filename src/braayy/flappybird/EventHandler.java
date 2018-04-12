package braayy.flappybird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandler implements KeyListener, MouseListener {
	
	private GameCanvas canvas;

	public EventHandler(GameCanvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (canvas.getBird() != null) canvas.getBird().jump();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (canvas.reset()) return;
		if (canvas.getBird() != null) canvas.getBird().jump();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
}