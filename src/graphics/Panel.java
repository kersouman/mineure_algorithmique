package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import nuage.Point;

@SuppressWarnings("serial")
public class Panel extends JPanel {

	private ArrayList<Point> graphe = new ArrayList<Point>();
	private ArrayList<Integer> solution = new ArrayList<Integer>();
	private float rayon = 0f;
	
	public Panel(ArrayList<Point> graphe, 
			ArrayList<Integer> solution,
			float rayon) {
		super();
		this.graphe = graphe;
		this.solution = solution;
	}
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < this.graphe.size(); i++) {
			float x = this.graphe.get(i).getCoordX();
			float y = this.graphe.get(i).getCoordY();
			g.fillOval((int) x, (int) y, 10, 10);
		}
		
		if (!this.solution.isEmpty()) {
			for (int i = 0; i < this.solution.size(); i++) {
				float x = this.graphe.get(this.solution.get(i)).getCoordX();
				float y = this.graphe.get(this.solution.get(i)).getCoordY();
				g.setColor(Color.red);
				g.fillOval((int) x, (int) y, 10, 10);
				g.fillOval(((int)x)-(int)(Math.round(rayon)), ((int)y)-(int)(Math.round(rayon)), (int)Math.round(rayon)*2, (int)Math.round(rayon)*2);
			}

/*
			g.setColor(Color.green);
			g.fillOval((int) this.graphe.get(this.solution.get(0)).getCoordX(), 
					(int) this.graphe.get(
							this.solution.get(0)).getCoordY(), 10, 10);
			g.setColor(Color.blue);
			g.fillOval((int) this.graphe.get(this.solution.get(1)).getCoordX(),
					(int) this.graphe.get(
							this.solution.get(1)).getCoordY(), 10, 10);
*/		}
	}
	
}
