package carte;

public  class Carte {
	protected int numero;
	
	/**
	 * Constructeur de Carte
	 * @param numero : Numero de la Carte
	 */
	public Carte(int numero) {
		this.numero = numero;
	}
	
	/**
	 * Renvoie le numero de la Carte
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}	
	
}
