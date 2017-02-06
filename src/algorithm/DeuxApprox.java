package algorithm;

import java.util.ArrayList;
import java.util.Random;

import instance.Instance;

public class DeuxApprox extends Algorithm {

	public DeuxApprox(Instance instance) {
		super(instance);
	}

	// Il faudra réaliser une copie de l'instance pour pas la bousiller si jamais on veut s'en resservir
	
	@Override
	public ArrayList<Integer> resoudre() {		
		int sizePb = this.instance.getSizeGraph();
		this.centres.add((new Random()).nextInt(sizePb));
		
		while (this.centres.size() < this.instance.getNbCentres()) {
			this.centres.add(this.getNouveauCentre(this.centres));
		}
		
		return this.centres;
	}

	private int getNouveauCentre(ArrayList<Integer> indexCentres) {
		float distMax = 0f;
		int nouveauCentre = 0;
		
		for (int i = 0; i < instance.getGraphe().size(); i++) {
			float tmp = instance.getDistance(i, 
					instance.getCentreLePlusProche(i, indexCentres));
			if (tmp > distMax) {
				distMax = tmp;
				nouveauCentre = i;
			}
		}
		
		return nouveauCentre;
	}
	
	public float getMaxDistance(ArrayList<Integer> indexCentres) {
		float distMax = 0f;
		int sizePb = this.instance.getGraphe().size();
		
		for (int i = 0; i < sizePb; i++) {
			int centreTmp = 
					this.instance.getCentreLePlusProche(i, indexCentres);
			float tmp = this.instance.getDistance(i, centreTmp);
			if (tmp > distMax)
				distMax = tmp;
		}
		
		return distMax;
	}
	
}
