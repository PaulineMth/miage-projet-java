package application;

import java.util.ArrayList;
import java.util.Collections;

import carreau.Carreau;
import carreau.CarreauChiffre;
import carreau.CarreauCouleur;
import carte.Carte;
import carte.CarteCouleur;
import carte.CarteMystere;
import carte.CarteTaille;
import enumeration.Couleur;
import enumeration.Type;
import position.Position;

public class Jeu {
	private char[][] mur;
	private int hauteurMur;
	
	private ArrayList<Carte> cartes;
	private ArrayList<Carte> carteDeCote;
	
	private ArrayList<Carreau> carreaux;
	private ArrayList<Carreau> carreauxPose;
	private ArrayList<Carreau> carreauxPosable;

	
	private static final int HAUTEUR_MUR = 30;
	private static final int LARGEUR_MUR = 8;
	
	private static final int TAILLE_MAX = 3;
	private static final int NB_COULEUR = 2;
	private static final int NB_TAILLE = 3;
	
	private static final int NB_CARTE_COULEUR = 4;
	private static final int NB_CARTES_TAILLE = 4;
	private static final int NB_CARTES_MYSTERE = 10;



	
	public Jeu() {
		mur = new char [HAUTEUR_MUR][LARGEUR_MUR];
		hauteurMur = 0;
		cartes = new ArrayList<>();
		carreaux = new ArrayList<>();
	}
	
	public void creerMur() {
		for(int i=0; i < mur.length; i++ ) {
			for(int j=0; j < mur[1].length; j++ ) {
				mur[i][j]=' ';
			}
		}
	}
	
	public Carreau tirerCarreau() {
		return this.carreaux.get(0);
	}
	
	public Carte tirerCarte() {
		return this.cartes.get(0);
	}
	
	public void trierCarte() {
		Collections.shuffle(this.cartes);
	}
	
	public void creerCarreauxC() {
		char lettre = 'a';
		Couleur couleur = Couleur.Bleu;
		for(int k=0; k<NB_COULEUR;++k) {
			
			for (int i=1 ; i <= NB_TAILLE ; ++i) {
				for (int j=1 ; j <= NB_TAILLE ; ++j) {
					this.carreaux.add(new CarreauCouleur(j,i,lettre,couleur));
					lettre++;
				}
			}
			couleur = Couleur.Rouge;
			lettre = 'A';
		}
		
		char chiffre = '1';
		this.carreaux.add(new CarreauChiffre(5,4,chiffre));      
	}

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
		
		for (int i = 1 ; i <= NB_TAILLE ; ++i) {
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
					intitule = "Vous gagner 1 point";
					cartes.add(new CarteMystere(num,t.Bonus,intitule));
					break;
				case 2:
					num++;
					intitule = "Vous gagner 2 point";
					cartes.add(new CarteMystere(num,t.Bonus,intitule));
					break;
				case 3:
					num++;
					intitule = "Vous perder 2 point";
					cartes.add(new CarteMystere(num,t.Malus,intitule));
					break;
			}
		}
	}
	
	
	public void placerCarreau(Carreau c, Position p) {
		for(int i =0; i<(c.getHauteur()*c.getLargeur());++i) {
			int pCarreauX = c.getCoord(i).getX();
			int pCarreauY = c.getCoord(i).getY();
			this.mur[p.getY()+pCarreauY][p.getX()+pCarreauX]=c.getSymbole();
		}
		if (this.hauteurMur-(p.getY()+c.getHauteur()) < 1)
			this.hauteurMur = (p.getY()+c.getHauteur());
		//this.carreauxPose.add(c);
		//this.carreaux.remove(c);
	}
	

	
	public String toStringCartes() {
		String s = "";
		for (Carte c : cartes) {
			s += c.toString() + "\n";
		}
		return s;
	}
	
	
	public String toStringCarreauxC() {
		String s = "";
		for (Carreau c : carreaux) {
			s += c.toString() + "\n";
		}
		return s;
	}
	
	
	public String toStringMur() {
		String s = "";
		for(int i = this.hauteurMur;i>=0;--i) {
			if (i <9) {
				s+= " ";
			}
			s+= (i+1);
			for(int j=0; j<LARGEUR_MUR;++j) {
				s+= mur[i][j];
			}
			s+= "\n";
		}
		s+= "  ";
		for(int j = 1; j <= LARGEUR_MUR; ++j) {
			s+=j;
		}
		s+= "\n";
		return s;
	}
}
