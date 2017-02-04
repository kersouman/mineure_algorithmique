package instance;

public class RandomCloud extends Cloud {
	
	public RandomCloud(int size) {
		for (int i = 0; i < size; i++)
			this.graphe.add(
					new Point((float)(size*Math.random()), 
							(float)(size*Math.random())));
	}
	
}
