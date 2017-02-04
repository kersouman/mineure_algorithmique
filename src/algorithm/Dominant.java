package algorithm;

import java.util.ArrayList;

import instance.Instance;
import instance.Point;

public class Dominant extends Algorithm {

	public Dominant(Instance instance) {
		super(instance);
	}

	@Override
	public ArrayList<Integer> resoudre() {
		/*Principe
		 * On trie la liste des distances par ordre croissant et on enlève les doublons
		 * On prend une distance (en parcourant la liste dans l'ordre croissant)
		 * On génère pour chaque point la liste des voisins à cette distance
		 * On met dans les centres le point qui a la liste la plus grande
		 * On ajoute l'index de tous les points couverts par ces centres dans une liste annexe
		 * On régénère la liste des voisins, on fait l'intersection avec les points déjà couverts
		 * On continue comme ça jusqu'à atteindre k
		 * S'il reste encore des points une fois k atteint, on s'arrête et on passe à la distance suivante
		 * S'il n'y a plus de points à couvrir, on s'arrête et on renvoie k
		 */
		ArrayList<Float> distancesTriees = this.instance.getListeDistances();
		for (Float distance: distancesTriees) {
			ArrayList<Point> grapheLocal = this.instance.getGraphe();
			
			while (!grapheLocal.isEmpty() || 
					this.centres.size() < this.instance.getNbCentres()) {
				ArrayList<ArrayList<Point>> pointsCercle = 
					this.genererPointsDansCercle(distance, grapheLocal);
				int index = this.getPlusGrandRecouvrement(pointsCercle);
				if (index >= 0) {
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
			} else {
				continue;
			}
		}
		return this.centres;
	}

	private ArrayList<ArrayList<Point>> genererPointsDansCercle(
			float distance, 
			ArrayList<Point> graphe) {
		ArrayList<ArrayList<Point>> pointsDansCercle = 
				new ArrayList<ArrayList<Point>>();
		
		for (int i = 0; i < graphe.size(); i++) {
			Point point1 = graphe.get(i);
			ArrayList<Point> tmpPoints = new ArrayList<Point>();
			tmpPoints.add(point1);
			for (int j = 0; j < graphe.size(); j++) {
				Point point2 = graphe.get(j);
				if ((this.instance.getDistance(point1.getIndexInGraph(), 
						point2.getIndexInGraph()) < distance)
						&& (i != j)) {
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
		
		if (plusGrandRecouvrement > 1) {
			return index;
		} else {
			return -1;
		}
	}
	
	private void enleverPoints(ArrayList<Point> graphe,
			ArrayList<Point> pointsRetires) {
		for (Point point: pointsRetires) {
			graphe.remove(graphe.indexOf(point));
		}
	}
	
	@Override
	public float getMaxDistance(ArrayList<Integer> listeCentres) {
		// TODO Auto-generated method stub
		return 0;
	}

}
