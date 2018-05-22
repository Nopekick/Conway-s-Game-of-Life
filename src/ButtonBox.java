import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ButtonBox extends JPanel {
	private LifeSquare[][] grid;
	private int numGen = 0;
	private JLabel gen;
	private JButton start;
	private JButton stop;
	private JComboBox select;
	
	public ButtonBox() {
		start = new JButton("Next");
		stop = new JButton("Stop simulation");
		gen = new JLabel("0");
		
		String[] presets = {"Clear", "Glider", "Small Exploder", "Exploder", "Lightweight Spaceship", "Tumbler", "Gospel Glider Gun"};
		select = new JComboBox(presets);
		
		 select.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {    
	                String s = (String) select.getSelectedItem();//get the selected item    
	               switch(s) {
	               case "Clear": clear(); break;
	               case "Glider": glider(); break;
	               case "Small Exploder": smallExploder(); break;
	               case "Exploder": exploder(); break;
	               case "Lightweight Spaceship": lightweightSpaceship(); break;
	               case "Tumbler": tumbler(); break;
	               case "Gospel Glider Gun": gospelGliderGun(); break;
	               }
	            }
	        });
		
		start.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    		generation();
		    }
		});
		
		stop.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		       System.exit(0);
		    }
		});
		
		add(start); 
		add(select);
		add(stop);
		add(gen);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void setGrid(LifeSquare[][] grid) {
		this.grid = grid;
	}
	
	public void generation(){
		boolean[][] temp = new boolean[57][80];
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[i].length; j++) {
				temp[i][j] = false;
				if(grid[i][j].isLive())
					temp[i][j] = true;
			}
		}
		int liveNeighbors;
		for(int i = 1; i < grid.length-1; i++) {
			for(int j = 1; j < grid[i].length-1; j++){		
				liveNeighbors = 0;
				if(grid[i+1][j].isLive()) {
					liveNeighbors++;
					//System.out.println("down");
				}
				if(grid[i-1][j].isLive()) {
					liveNeighbors++;
					//System.out.println("up");
				}
				if(grid[i][j-1].isLive()) {
					liveNeighbors++;
					//System.out.println("left");
				}
				if(grid[i][j+1].isLive()) {
					liveNeighbors++;
					//System.out.println("right");
				}
				if(grid[i+1][j-1].isLive()) {
					liveNeighbors++;
					//System.out.println("down left");
				}
				if(grid[i+1][j+1].isLive()) {
					liveNeighbors++;
					//System.out.println("down right");
				}
				if(grid[i-1][j+1].isLive()) {
					liveNeighbors++;
					//System.out.println("up right");
				}
				if(grid[i-1][j-1].isLive()) {
					liveNeighbors++;
					//System.out.println("up left");
				}
								
				/*
				@Game rules
				 * Any live cell with fewer than two live neighbors dies, as if caused by under population.
				 * Any live cell with two or three live neighbors lives on to the next generation.
				 * Any live cell with more than three live neighbors dies, as if by overpopulation.
				 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
				 */
				if(!(liveNeighbors == 3 || liveNeighbors == 2) && grid[i][j].isLive()) {
					temp[i][j] = false;
				}	else if(!grid[i][j].isLive() && liveNeighbors == 3) {
					temp[i][j] = true;
					//System.out.println(liveNeighbors);
				}
			}
		}
		for(int i = 1; i < grid.length-1; i++) {
			for(int j = 1; j < grid[i].length-1; j++){
				if(temp[i][j] == true) {
					grid[i][j].live();
				} else if(temp[i][j] == false) {
					grid[i][j].die();
				}
			}
			}
		gen.setText(" "+ (++numGen));
	}
	
	public void clear() {
		numGen = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j].die();
			}
		}
	}
	
	public void glider() {
		numGen = 0;
		clear();
		grid[20][30].live();
		grid[22][30].live();
		grid[22][29].live();
		grid[22][31].live();
		grid[21][31].live();
	}
	
	public void smallExploder() {
		numGen = 0;
		clear();
		grid[25][40].live();
		grid[26][40].live();
		grid[26][39].live();
		grid[26][41].live();
		grid[27][39].live();
		grid[27][41].live();
		grid[28][40].live();
	}
	
	public void exploder() {
		numGen = 0;
		clear();
		grid[25][40].live();
		grid[29][40].live();
		grid[25][38].live();
		grid[25][42].live();
		grid[26][38].live();
		grid[26][42].live();
		grid[27][38].live();
		grid[27][42].live();
		grid[28][38].live();
		grid[28][42].live();
		grid[29][38].live();
		grid[29][42].live();
	}
	
	public void tenCellRow() {
		numGen = 0;
		clear();
		grid[25][40].live();
		grid[25][39].live();
		grid[25][38].live();
		grid[25][37].live();
		grid[25][36].live();
		grid[25][41].live();
		grid[25][42].live();
		grid[25][43].live();
		grid[25][44].live();
		grid[25][45].live();
	}
	
	public void lightweightSpaceship() {
		numGen = 0;
		clear();
		grid[25][40].live();
		grid[26][39].live();
		grid[28][39].live();
		grid[28][42].live();
		grid[25][41].live();
		grid[25][42].live();
		grid[25][43].live();
		grid[26][43].live();
		grid[27][43].live();
	}
	
	public void tumbler() {
		numGen = 0;
		clear();
		grid[22][36].live();
		grid[22][37].live();
		grid[23][36].live();
		grid[23][37].live();
		grid[24][37].live();
		grid[25][37].live();
		grid[26][37].live();
		grid[27][36].live();
		grid[27][35].live();
		grid[25][35].live();
		grid[26][35].live();

		grid[22][39].live();
		grid[22][40].live();
		grid[23][39].live();
		grid[23][40].live();
		grid[24][39].live();
		grid[25][39].live();
		grid[26][39].live();
		grid[27][40].live();
		grid[27][41].live();
		grid[26][41].live();
		grid[25][41].live();
		
	}
	
	public void gospelGliderGun() {
		numGen = 0;
		clear();
		grid[12][15].live();
		grid[12][16].live();
		grid[13][15].live();
		grid[13][16].live();
		
		grid[13][23].live();
		grid[14][23].live();
		grid[14][24].live();
		grid[12][24].live();
		grid[12][25].live();
		grid[13][25].live();
		
		grid[14][31].live();
		grid[14][32].live();
		grid[15][31].live();
		grid[16][31].live();
		grid[15][33].live();
		
		grid[12][37].live();
		grid[12][38].live();
		grid[11][37].live();
		grid[10][38].live();
		grid[10][39].live();
		grid[11][39].live();
		
		grid[10][49].live();
		grid[10][50].live();
		grid[11][49].live();
		grid[11][50].live();
		
		grid[17][50].live();
		grid[18][50].live();
		grid[19][50].live();
		grid[17][51].live();
		grid[18][52].live();
		
		grid[22][41].live();
		grid[22][40].live();
		grid[22][39].live();
		grid[23][39].live();
		grid[24][40].live();
	}
}
