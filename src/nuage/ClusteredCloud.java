package nuage;

import java.util.ArrayList;
import java.util.Random;

public class ClusteredCloud extends Cloud {

	private ArrayList<Point> centresClusters = new ArrayList<Point>();
	private float sigma = 0f;
	
	public ClusteredCloud(int size, int nbClusters, float sigma) {
		this.sigma = sigma;
		this.setCentresClusters(nbClusters, size);
		this.genererNuage(nbClusters, size);
	}
	
	private void setCentresClusters(int nbClusters, int size) {
		for (int i = 0; i < nbClusters; i++) {
			Point point = new Point(
					2*this.marges + 
						(float)(Math.random()*(this.resPx - 4*this.marges)),
					2*this.marges + 
						(float)(Math.random()*(this.resPx - 4*this.marges)));
			this.centresClusters.add(point);
			this.graphe.add(point);
		}
		
	}
	
	private void genererNuage(int nbClusters, int size) {
		int nbPointsClusters = (size-nbClusters)/nbClusters;
		int nbPointsHorsClusters = (size-nbClusters)%nbClusters;
		Random r = new Random();
		
		for (int i = 0; i < nbClusters; i++) {
			float coordXCentre = this.centresClusters.get(i).getCoordX();
			float coordYCentre = this.centresClusters.get(i).getCoordY();
			for (int j = 0; j < nbPointsClusters; j++) {
				float coordX = 
						(float)(r.nextGaussian()*this.sigma + coordXCentre);
				float coordY = 
						(float)(r.nextGaussian()*this.sigma + coordYCentre);
				this.graphe.add(new Point(
						Math.max(Math.min(coordX, this.resPx - this.marges),
								this.marges),
						Math.max(Math.min(coordY, this.resPx - this.marges),
								this.marges)));
			}
		}
		
		for (int i = 0; i < nbPointsHorsClusters; i++) {
			this.graphe.add(new Point((float)(this.resPx*Math.random()),
					(float)(this.resPx*Math.random())));
		}
	}

}