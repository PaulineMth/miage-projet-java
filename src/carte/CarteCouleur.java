package carte;

import enumeration.Couleur;

public class CarteCouleur extends Carte implements ICarte {
	private Couleur couleur;
	
	/**
	 * Constructeur de CarteCouleur
	 * @param num : Numero de la CarteCouleur
	 * @param couleur : Couleur de la CarteCouleur
	 */
	public CarteCouleur(int num, Couleur c) {
		super(num);
		this.couleur = c;
	}

	/**
	 * toString de la CarteCouleur
	 * @return String
	 */
	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - Couleur : " + couleur;
	}


	/**
	 * Inverse les couleurs des cartes dans le paquet
	 */
	@Override
	public void inverser() {
		if(this.couleur == Couleur.Rouge) 
			this.couleur = Couleur.Bleu;
		else
			this.couleur = Couleur.Rouge;
	
	}


}
