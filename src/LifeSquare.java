import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LifeSquare extends JPanel {
	private boolean alive = false;
	
	public LifeSquare() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.WHITE);
		setVisible(true);
		addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		       toggle();
		    }
		});
	}
	
	public void die() {
		alive = false;
		setBackground(Color.WHITE);
	}
	
	public void live() {
		alive = true;
		setBackground(Color.RED);
	}
	
	public boolean isLive() {
		return alive;
	}
	
	public void toggle() {
		if(alive) {
			die();
		}
		else {
			live();
		}
	}	
	

}
