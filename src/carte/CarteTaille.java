package carte;

public class CarteTaille extends Carte {
	private int taille;
	
	public CarteTaille (int num, int taille) {
		super(num);
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - Taille : " + this.taille;
	}
}
