package instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Instance {
	
	/*
	 * On va supposer qu'on a systématiquement une matrice (constituée)
	 * par un ArrayList<ArrayList<Double>> qui nous donne les distances
	 * entre deux points pour résoudre
	 */
	
	ArrayList<Point> graphe = new ArrayList<Point>();
	ArrayList<ArrayList<Float>> distances = new ArrayList<ArrayList<Float>>();
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
				tmp.add(this.graphe.get(i).getDistance(this.graphe.get(j)));
			} this.distances.add(tmp);
			
		}
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
		ArrayList<Float> tmpList = new ArrayList<Float>();
		
		for (int i = 0; i < this.distances.size(); i++) {
			for (int j = i; j < this.distances.get(i).size(); j++) {
				if (!tmpList.contains(this.distances.get(i).get(j))) {
					tmpList.add(this.distances.get(i).get(j));
				}
			}
		}
		
		Collections.sort(tmpList);

		return tmpList;
	}
	
}
