package instance;

import java.util.ArrayList;
import java.util.Collections;

import nuage.Point;

public class Instance {
	
	private ArrayList<Point> graphe = new ArrayList<Point>();
	private ArrayList<ArrayList<Float>> distances =
			new ArrayList<ArrayList<Float>>();
	private ArrayList<Float> distancesTriees = new ArrayList<Float>();
	int nbCentres = 0; 
	
	public Instance(ArrayList<Point> graphe, int nbCentres) {
		this.graphe = graphe;
		this.nbCentres = nbCentres;
		this.initiateDistances();
	}
	
	private void initiateDistances() {
		for (int i = 0; i < this.graphe.size(); i++) {
			ArrayList<Float> tmp = new ArrayList<Float>();
			
			for (int j = 0; j < this.graphe.size(); j++) {
				float distance = 
						this.graphe.get(i).getDistance(this.graphe.get(j));
				tmp.add(distance);
				if (!(this.distancesTriees.contains(distance))) {
					this.distancesTriees.add(distance);
				}
			} this.distances.add(tmp);
			
		}
		Collections.sort(this.distancesTriees);
	}
	
	// Pour un point, quel est le centre le plus proche ?
	public int getCentreLePlusProche(int j, ArrayList<Integer> listeCentres) {
		float distMin = Float.MAX_VALUE;
		int indexCentre = 0;
		
		for (int i = 0; i < listeCentres.size(); i++) {
			float tmp = this.getDistance(j, listeCentres.get(i));
			
			if (tmp < distMin) {
				distMin = tmp;
				indexCentre = listeCentres.get(i);
			}

		}		
		return indexCentre;
	}

	
	public ArrayList<Point> getGraphe() {
		return this.graphe;
	}
	
	public int getSizeGraph() {
		return this.graphe.size();
	}
	
	public int getNbCentres() {
		return this.nbCentres;
	}
	
	public float getDistance(int i, int j) {
		return this.distances.get(i).get(j);
	}
	
	public ArrayList<Float> getListeDistances() {
		return this.distancesTriees;
	}
	
}
