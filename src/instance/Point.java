package instance;

public class Point {

	private float coordX = 0f;
	private float coordY = 0f;
	
	public Point(float coordX, float coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	public float getCoordX() {
		return this.coordX;
	}
	
	public float getCoordY() {
		return this.coordY;
	}
	
	public float getDistance(Point p1) {
		float distX = this.getCoordX() - p1.getCoordX();
		float distY = this.getCoordY() - p1.getCoordY();
		return (float) Math.sqrt(distX*distX + distY*distY);
	}
	
}
