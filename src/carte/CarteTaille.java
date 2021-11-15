package carte;

public class CarteTaille extends Carte implements ICarte {
	private int taille;
	
	/**
	 * Constructeur de CarteTaille
	 * @param num : Numero de la CarteTaille
	 * @param taille : Taille de la CarteTaille
	 */
	public CarteTaille (int num, int taille) {
		super(num);
		this.taille = taille;
	}

	/**
	 * toString de la CarteTaille
	 * @return String
	 */
	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - Taille : " + this.taille;
	}

	/**
	 * Enleve 1 point sur la taille (les cartes taille = 3 n'existent plus)
	 */
	@Override
	public void inverser() {
		this.taille--;
	}

}
