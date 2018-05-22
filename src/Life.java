import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Life {

	public static LifeSquare[][] grid = new LifeSquare[57][80];
	
	public static void initEnvironment() {
		
		JFrame frame = new JFrame();
		frame.setTitle("Conway's Game of Life");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);
		
		ButtonBox box = new ButtonBox();
		frame.add(box);
		
		/*
		 * Contains the life squares
		 */
		JPanel Environment = new JPanel();
		frame.add(Environment);
		Environment.setLayout(new GridLayout(57, 70));
		for(int i = 0; i < 57; i++) {
			for(int j = 0; j < 80; j++) {
				LifeSquare temp = new LifeSquare();
				Environment.add(temp);
				grid[i][j] = temp;
			}
		}
		
		box.setGrid(grid);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		initEnvironment();
		
		
		
	}

}
