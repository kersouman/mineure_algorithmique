package algorithm;

import java.util.ArrayList;

import instance.Instance;

public abstract class Algorithm {

	protected Instance instance;
	protected ArrayList<Integer> centres = new ArrayList<Integer>();
	protected float rayon = 0f;
	
	public Algorithm(Instance instance) {
		this.instance = instance;
	}
	
	public abstract ArrayList<Integer> resoudre();
	public abstract float getMaxDistance(ArrayList<Integer> listeCentres);
	
	public ArrayList<Integer> getCentres() {
		return this.centres;
	}
	
	public float getRayon() {
		return this.rayon;
	}
	
	public Instance getInstance() {
		return this.instance;
	}

}
