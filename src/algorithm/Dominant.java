package algorithm;

import java.util.ArrayList;

import instance.Instance;
import nuage.Point;

public class Dominant extends Algorithm {

	public Dominant(Instance instance) {
		super(instance);
	}

	@Override
	public ArrayList<Integer> resoudre() {
		if (this.instance.getNbCentres() > this.instance.getSizeGraph())
			return new ArrayList<Integer>();
		ArrayList<Float> distancesTriees = this.instance.getListeDistances();
		for (int i = 0; i < distancesTriees.size(); i++) {
			float distance = distancesTriees.get(i);
			ArrayList<Point> grapheLocal = 
					new ArrayList<Point>(this.instance.getGraphe());
			this.centres = new ArrayList<Integer>();
			
			while ((!grapheLocal.isEmpty()) || 
					(this.centres.size() < this.instance.getNbCentres())) {
				ArrayList<ArrayList<Point>> pointsCercle = 
					this.genererPointsDansCercle(distance, grapheLocal);
				int index = this.getPlusGrandRecouvrement(pointsCercle);
				if (index != -1) {
					this.centres.add(
							pointsCercle.get(index).get(0).getIndexInGraph());
					this.enleverPoints(grapheLocal, pointsCercle.get(index));
				} else {

					break;
				}
			}
			if (grapheLocal.isEmpty() && 
					(this.centres.size() == this.instance.getNbCentres())) {
				this.rayon = distance;
				break;
			}
		}
		if (this.centres.size() == this.instance.getNbCentres()) {
			return this.centres;
		} else {
			return new ArrayList<Integer>();
		}
	}

	private ArrayList<ArrayList<Point>> genererPointsDansCercle(
			float distance, 
			ArrayList<Point> graphe) {
		ArrayList<ArrayList<Point>> pointsDansCercle = 
				new ArrayList<ArrayList<Point>>();
		
		for (Point point1: graphe) {
			ArrayList<Point> tmpPoints = new ArrayList<Point>();
			tmpPoints.add(point1);
			for (Point point2: graphe) {
				if ((this.instance.getDistance(point1.getIndexInGraph(), 
						point2.getIndexInGraph()) <= distance)
						&& !point1.equals(point2)) {
					tmpPoints.add(point2);
				}
			}
			pointsDansCercle.add(tmpPoints);
		}
		
		return pointsDansCercle;
	}
	
	private int getPlusGrandRecouvrement(
			ArrayList<ArrayList<Point>> graphes) {
		int index = 0;
		int plusGrandRecouvrement = 0;

		for (int i = 0; i < graphes.size(); i++) {
			if (graphes.get(i).size() > plusGrandRecouvrement) {
				plusGrandRecouvrement = graphes.get(i).size();
				index = i;
			}
		}
		if (plusGrandRecouvrement > 0)
			return index;
		else
			return -1;
	}
	
	private void enleverPoints(ArrayList<Point> graphe,
			ArrayList<Point> pointsRetires) {
		for (Point point: pointsRetires) {
			int index = graphe.indexOf(point);
			graphe.remove(index);
		}
	}
	
	@Override
	public float getMaxDistance(ArrayList<Integer> listeCentres) {
		// Déjà fixé dans la méthode resoudre
		return 0f;
	}

}
