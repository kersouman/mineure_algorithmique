import java.util.ArrayList;

import algorithm.Algorithm;
import algorithm.Dominant;
import graphics.GUI;
import graphics.Panel;
import instance.Instance;
import nuage.Cloud;
import nuage.SRUnitCloud;

public class Main {

	public static void main(String args[]) {
		/*
		ArrayList<ArrayList<Float>> performanceChart = new ArrayList<ArrayList<Float>>();
		
		ArrayList<Integer> numberOfCenters = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++)
			numberOfCenters.add(i);
		
		for (int i = 0; i < numberOfCenters.size(); i++) {
			System.out.println("i = " + i);
			ArrayList<Float> tmpPerfChart = new ArrayList<Float>();
			for (int j = 1; j < 101; j++) {
				tmpPerfChart.add((float) j);
				ArrayList<Float> tmpMaxDistance = new ArrayList<Float>();
				
				for (int k = 0; k < 100; k++) {
					Cloud cloud = new RandomCloud(j);
					Instance instance = new Instance(cloud.getGraphe(), numberOfCenters.get(i));
					Algorithm deuxApprox = new DeuxApprox(instance);
					
					ArrayList<Integer> solution = deuxApprox.resoudre();
					
					tmpMaxDistance.add(deuxApprox.getMaxDistance(solution));
				}
				
				float sum = 0f;
				for (int k = 0; k < tmpMaxDistance.size(); k++) {
					sum += tmpMaxDistance.get(k);
				}
				sum /= tmpMaxDistance.size();
				tmpPerfChart.add(sum);
			}
			performanceChart.add(tmpPerfChart);
		}
		
		try {
			FileInterface.generatePerformanceChart(performanceChart, numberOfCenters, "test3.csv");
		} catch (Exception e) {
			System.out.println("Ca a foiré !");
			e.printStackTrace();
		}*/
		
		//Cloud cloud = new RandomCloud(100);
		//Cloud cloud = new ClusteredCloud(100, 5, 50);
		Cloud cloud = new SRUnitCloud(100, 5, 20);
		Instance instance = new Instance(cloud.getGraphe(), 5);
		Algorithm algorithme = new Dominant(instance);
		
		ArrayList<Integer> solution = algorithme.resoudre();
		/*
		ArrayList<Integer> solution = new ArrayList<Integer>();
		float rayon = 0f;
		*/
		Panel panel = new Panel(
				cloud.getGraphe(), solution, algorithme.getRayon());
		GUI frame = new GUI(panel);
		frame.setVisible(true);
		
	}
	
}
