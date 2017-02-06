package nuage;

import java.util.ArrayList;

public class Cloud {

	protected ArrayList<Point> graphe = new ArrayList<Point>();
	protected float resPx = 1000f;
	protected float marges = 50f;
	
	public ArrayList<Point> getGraphe() {
		return this.graphe;
	}
}
