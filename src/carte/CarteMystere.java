package carte;

import enumeration.Type;

public class CarteMystere extends Carte {
	private Type type;
	private String intitule;
	
	/**
	 * Constructeur de CarteMystere
	 * @param num : Numero de la CarteMystere
	 * @param type : Type de la CarteMystere 
	 * @param intitule : Intitule de la CarteMystere
	 */
	public CarteMystere (int num, Type type, String intitule) {
		super(num);
		this.type = type;
		this.intitule = intitule;
	}

	/**
	 * toString de la CarteMystere
	 * @return String
	 */
	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - " + this.type + " : " + this.intitule;
	}
}
