import java.util.ArrayList;

import algorithm.Algorithm;
import algorithm.DeuxApprox;
import graphics.GUI;
import graphics.Panel;
import instance.Cloud;
import instance.Instance;
import instance.RandomCloud;

public class Main {

	public static void main(String args[]) {
		
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
		}
		/*
		RandomCloud cloud = new RandomCloud(1000);
		Instance instance = new Instance(cloud.getGraphe(), 100);
		Algorithm deuxApprox = new DeuxApprox(instance);
		
		ArrayList<Integer> solution = deuxApprox.resoudre();
		
		Panel panel = new Panel(cloud.getGraphe(), solution);
		GUI frame = new GUI(panel);
		frame.setVisible(true);
		*/
	}
	
}
