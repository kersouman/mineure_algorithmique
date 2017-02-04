package instance;

public class Point {

	private static int CPT_POINTS = 0;
	
	private float coordX = 0f;
	private float coordY = 0f;
	private int indexInGraph = 0;
	
	public Point(float coordX, float coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
		this.indexInGraph = Point.CPT_POINTS++;
	}
	
	public float getCoordX() {
		return this.coordX;
	}
	
	public float getCoordY() {
		return this.coordY;
	}

	public int getIndexInGraph() {
		return this.indexInGraph;
	}
	
	public float getDistance(Point p1) {
		float distX = this.getCoordX() - p1.getCoordX();
		float distY = this.getCoordY() - p1.getCoordY();
		return (float) Math.sqrt(distX*distX + distY*distY);
	}
	
}
