package carte;

import enumeration.Couleur;

public class CarteCouleur extends Carte {
	private Couleur couleur;
	
	public CarteCouleur(int num, Couleur c) {
		super(num);
		this.couleur = c;
	}

	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - Couleur : " + couleur;
	}
}
