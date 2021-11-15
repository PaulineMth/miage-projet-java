package application;

import java.util.ArrayList;
import java.util.Collections;

import carreau.Carreau;
import carreau.CarreauChiffre;
import carreau.CarreauCouleur;
import carreau.Position;
import carte.Carte;
import carte.CarteCouleur;
import carte.CarteMystere;
import carte.CarteTaille;
import enumeration.Couleur;
import enumeration.Type;

public class Jeu {
	private char[][] mur;
	private int hauteurMur;
	
	private ArrayList<Carte> cartes;
	
	private ArrayList<Carreau> carreaux;
	private ArrayList<Carreau> carreauxPose;

	
	private static final int HAUTEUR_MUR = 30;
	private static final int LARGEUR_MUR = 6;
	
	private static final int NB_COULEUR = 2;
	private static final int NB_TAILLE_CC = 3;
	private static final int NB_TAILLE_CT = 5;
	
	private static final int NB_CARTE_COULEUR = 4;
	private static final int NB_CARTES_TAILLE = 4;
	private static final int NB_CARTES_MYSTERE = 10;

	/**
	 * Constructeur de la partie de Jeu
	 */
	public Jeu() {
		mur = new char [HAUTEUR_MUR][LARGEUR_MUR];
		hauteurMur = 0;
		cartes = new ArrayList<>();
		carreaux = new ArrayList<>();
		carreauxPose = new ArrayList<>();
	}
	
	/**
	 * Initialise le mur
	 */
	public void creerMur() {
		for(int i=0; i < mur.length; i++ ) {
			for(int j=0; j < mur[1].length; j++ ) {
				mur[i][j]=' ';
			}
		}
	}
	
	// Pour tester
	public Carreau tirerCarreau() {
		return this.carreaux.get(0);
	}
	
	public void trierCarreaux() {
		Collections.shuffle(this.carreaux);
	}
	
	/**
	 * Tirer une Carte
	 * @return Carte 
	 */
	public Carte tirerCarte() {
		Carte carte = this.cartes.get(0);
		cartes.remove(carte);
		return carte;
	}
	
	/**
	 * Trie le paquet de cartes
	 * @return Carte 
	 */
	public void trierCarte() {
		Collections.shuffle(this.cartes);
	}
	
	/**
	 * Creer les CarreauCouleur (minuscule = carreaux bleus / Majuscule = carreaux rouges)
	 * et les CarreauxChiffre (à definir..)
	 */
	public void creerCarreaux() {
		char lettre = 'a';
		Couleur couleur = Couleur.Bleu;
		for(int k=0; k<NB_COULEUR;++k) {
			
			for (int i=1 ; i <= NB_TAILLE_CC ; ++i) {
				for (int j=1 ; j <= NB_TAILLE_CC ; ++j) {
					this.carreaux.add(new CarreauCouleur(j,i,lettre,couleur));
					lettre++;
				}
			}
			couleur = Couleur.Rouge;
			lettre = 'A';
		}
		
		char chiffre = '1';
		for (int i = 1; i < NB_TAILLE_CT; i++) {
			for (int j=2 ; j <= NB_TAILLE_CC ; ++j) {
				this.carreaux.add(new CarreauChiffre(i,j,chiffre));  
				chiffre++;
			}
		}
	}

	/**
	 * Creer le paquet de cartes avec des CarteCouleur, des CarteTaille et des CarteMystere
	 */
	public void creerCartes() {
		Couleur couleur = Couleur.Rouge;
		int num = 0;
		for (int i = 0 ; i < NB_COULEUR ; ++i) {
			for(int j = 0; j < NB_CARTE_COULEUR; ++j) {
				num++;
				this.cartes.add(new CarteCouleur(num,couleur));
			}
			couleur = Couleur.Bleu;
			}
		
		for (int i = 1 ; i <= NB_TAILLE_CC ; ++i) {
			for(int j = 0; j < NB_CARTES_TAILLE; ++j) {
				num++;
				cartes.add(new CarteTaille(num,i));
			}
		}
		
		for (int i = 0; i < NB_CARTES_MYSTERE; i++) {
			Type t = null;
			String intitule;
				switch(i) {
				case 1:
					num++;
					intitule = "Vous gagnez 5 points";
					cartes.add(new CarteMystere(num,t.Bonus,intitule));
					break;
				case 2:
					num++;
					intitule = "Vous gagnez 3 points";
					cartes.add(new CarteMystere(num,t.Bonus,intitule));
					break;
				case 3:
					num++;
					intitule = "Vous perdez 4 points";
					cartes.add(new CarteMystere(num,t.Malus,intitule));
					break;
				case 4:
					num++;
					intitule = "Vous perdez 6 points";
					cartes.add(new CarteMystere(num,t.Malus,intitule));
					break;
				case 5:
					num++;
					intitule = "Vous avez declenché un coup d'état !";
					cartes.add(new CarteMystere(num,t.Malus,intitule));
					break;
			}
		}
	}
	
	/**
	 * Place un Carreau sur le mur selon une Position
	 * @param c : le carreau à poser
	 * @param p : la position sur le mur qui correspond au carré en bas à gauche du carreau
	 */
	public void placerCarreau(Carreau c, Position p) {
		for(int i =0; i<(c.getHauteur()*c.getLargeur());++i) {
			int pCarreauX = c.getCoord(i).getX();
			int pCarreauY = c.getCoord(i).getY();
			this.mur[p.getY()+pCarreauY][p.getX()+pCarreauX]=c.getSymbole();
		}
		if (this.hauteurMur-(p.getY()+c.getHauteur()) < 1)
			this.hauteurMur = (p.getY()+c.getHauteur());
		this.carreauxPose.add(c);
		this.carreaux.remove(c);
	}
	
	/**
	 * Déclenche le coup d'état et change les cartes des classes implémentant l'interface ICarte
	 */
	public void coup_d_etat() {
		for (Carte c : cartes) {
			if (c instanceof CarteCouleur) 
				((CarteCouleur) c).inverser();
			if(c instanceof CarteTaille)
				((CarteTaille) c).inverser();
		}
	}
	
	/**
	 * toString de la liste des Cartes 
	 * @return String
	 */
	public String toStringCartes() {
		String s = "";
		for (Carte c : cartes) {
			s += c.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * toString de la liste des Carreaux
	 * @return String
	 */
	public String toStringCarreaux() {
		String s = "";
		for (Carreau c : carreaux) {
			s += c.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * toString du mur
	 * @return String
	 */
	public String toStringMur() {
		String s = "";
		for(int i = this.hauteurMur;i>=0;--i) {
			if (i <9) {
				s+= " ";
			}
			s+= (i);
			for(int j=0; j<LARGEUR_MUR;++j) {
				s+= mur[i][j];
			}
			s+= "\n";
		}
		
		s+= "  ";
		for(int j = 0; j < LARGEUR_MUR; ++j) {
			s+=j;
		}
		s+= "\n";
		return s;
	}
}
