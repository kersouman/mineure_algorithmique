package nuage;

public class RandomCloud extends Cloud {
	
	public RandomCloud(int size) {
		for (int i = 0; i < size; i++)
			this.graphe.add(
					new Point((float)(100*Math.random()), 
							(float)(100*Math.random())));
	}
	
}
