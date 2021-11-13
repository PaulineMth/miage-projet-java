package position;

public class Position {
	private int x;
	private int y;
	
	public Position() {
		this(0,0);
	}

	public Position(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "y :" + this.y + " - x :" + this.x;
	}
}
