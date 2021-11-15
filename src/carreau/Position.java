package carreau;

public class Position {
	private int x;
	private int y;
	
	/**
	 * Constructeur de la Position nulle
	 */
	public Position() {
		this(0,0);
	}
	
	/**
	 * Constructeur de la Position(x,y)
	 * @param y
	 * @param x
	 */
	public Position(int y, int x) {
		this.y = y;
		this.x = x;
	}
	
	/**
	 * Retourne la coordonnée y de la position
	 * @return y
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Retourne la coordonnée x de la position
	 * @return x
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * toString de la Position 
	 * @return String
	 */
	public String toString() {
		return "y :" + this.y + " - x :" + this.x;
	}
}
