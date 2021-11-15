package carreau;

public class Carreau {
	private int hauteur;
	private int largeur;
	private char symbole;
	private Position[] coord;
	
	/**
	 * Constructeur de Carreau
	 * @param haut : Hauteur du carreau
	 * @param largeur : Largeur du carreau
	 * @param symb : Symbole/Charactère du carreau
	 */
	public Carreau(int haut, int largeur, char symb) {
		this.hauteur = haut;
		this.largeur = largeur;
		this.symbole = symb;
		this.coord = new Position[this.hauteur*this.largeur];
		this.remplirCoordonnees();
	}
	
	/**
	 * Rempli le tableau des coordonnées du Carreau en fonction de ses dimensions,
	 * en prenant pour point d'origine, le point en bas a gauche du carreau (égal à (0,0))
	 */
	public void remplirCoordonnees() {
		for(int i = 0, j=0,k=0; i < (largeur*hauteur); ++i) {
				coord[i] = new Position(j,k);
				++k;
			if (k%largeur == 0) {
				++j;
				k=0;
			}
		}
	}
	
	/**
	 * Renvoie la hauteur du carreau
	 * @return hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}
	
	/**
	 * Renvoie la largeur du carreau
	 * @return largeur
	 */
	public int getLargeur() {
		return largeur;
	}
	
	/**
	 * Renvoie le symbole du carreau
	 * @return symbole
	 */
	public char getSymbole() {
		return symbole;
	}
	
	/**
	 * Renvoi la Coordonée à l'indice i dans la liste de coordonée
	 * @param i
	 * @return Position(i)
	 */
	public Position getCoord(int i) {
		return(this.coord[i]);
	}

	/**
	 * Fixe une valeur hauteur
	 * @param hauteur
	 */
	protected void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	/**
	 * Fixe une valeur largeur
	 * @param largeur
	 */
	protected void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * toString du tableau des coordonnées d'un Carreau
	 * @return String : la liste des coordonnées
	 */
	public String toStringCoord() {
		String s = "";
		for(Position p : this.coord) {
			s+= "("+p.toString()+")";
		}
		s+="\n";
		return s;
	}
	
	/**
	 * toString qui dessine la représentation 2D du Carreau
	 * @return String : le carreau
	 */
	public String toString() {
		String s ="";
		for(int i=0 ; i < hauteur ; i++) {
			for(int j=0 ; j < largeur ; j++) {
				s+= this.symbole;
			}
			s+="\n";
		}
		s+="\n";
		return s;
	}
	
}