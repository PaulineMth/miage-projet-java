package carte;

import enumeration.Type;

public class CarteMystere extends Carte {
	private Type type;
	private String intitule;
	
	public CarteMystere (int num, Type type, String intitule) {
		super(num);
		this.type = type;
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		return "Carte n°" + this.numero + " - " + this.type + " : " + this.intitule;
	}
}
