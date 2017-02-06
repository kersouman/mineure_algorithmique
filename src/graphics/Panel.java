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
	// Différent de 1 seulement avec un RandomCloud pour prendre toute la
	// largeur de la fenêtre
	private float facteurEchelle = 1f;
	
	public Panel(ArrayList<Point> graphe, 
			ArrayList<Integer> solution,
			float rayon, boolean randomCloud) {
		super();
		this.graphe = graphe;
		this.solution = solution;
		if (randomCloud)
			this.facteurEchelle = 1000f/((float)this.graphe.size());
	}
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < this.graphe.size(); i++) {
			float x = this.graphe.get(i).getCoordX()*this.facteurEchelle;
			float y = this.graphe.get(i).getCoordY()*this.facteurEchelle;
			g.fillOval((int) x, (int) y, 10, 10);
		}
		
		if (!this.solution.isEmpty()) {
			for (int i = 0; i < this.solution.size(); i++) {
				float x = this.graphe.get(this.solution.get(i))
							.getCoordX()*this.facteurEchelle;
				float y = this.graphe.get(this.solution.get(i))
							.getCoordY()*this.facteurEchelle;
				g.setColor(Color.red);
				g.fillOval((int) x, (int) y, 10, 10);
				/*g.fillOval(((int)x)-(int)(Math.round(rayon)), 
						((int)y)-(int)(Math.round(rayon)),
						(int)Math.round(rayon)*2, 
						(int)Math.round(rayon)*2);*/
			}
		}
	}
	
}
