package algorithm;

import java.util.ArrayList;

import instance.Instance;
import instance.Point;

public abstract class Algorithm {

	Instance instance;
	
	public Algorithm(Instance instance) {
		this.instance = instance;
	}
	
	public abstract ArrayList<Integer> resoudre();
	public abstract float getMaxDistance(ArrayList<Integer> listeCentres);
	
}
