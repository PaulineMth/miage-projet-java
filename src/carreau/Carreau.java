package carreau;

import position.Position;

public class Carreau {
	private int hauteur;
	private int largeur;
	private char symbole;
	private Position[] coord;
	
	public Carreau(int haut, int largeur, char symb) {
		this.hauteur = haut;
		this.largeur = largeur;
		this.symbole = symb;
		this.coord = new Position[this.hauteur*this.largeur];
		this.remplirCoordonnees();
	}

	public int getHauteur() {
		return hauteur;
	}
	
	public int getLargeur() {
		return largeur;
	}

	public char getSymbole() {
		return symbole;
	}

	public Position getCoord(int i) {
		return(this.coord[i]);
	}

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

	public String toStringCoord() {
		String s = "";
		for(Position p : this.coord) {
			s+= "("+p.toString()+")";
		}
		s+="\n";
		return s;
	}
	
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