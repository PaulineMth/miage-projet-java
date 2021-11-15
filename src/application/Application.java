package application;

import java.util.Scanner;

import carreau.Carreau;
import carreau.CarreauChiffre;
import carreau.Position;
import carte.Carte;
import enumeration.Couleur;

public class Application {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		
		System.out.println("* Mur au début du jeu :\n");
		System.out.println(jeu.toStringMur());
		
		System.out.println("* Le paquet de cartes initial : \n");
		jeu.creerCartes();
		System.out.println(jeu.toStringCartes());
		
		System.out.println("* Le paquet de cartes mélangé : \n");
		jeu.trierCarte();
		System.out.println(jeu.toStringCartes());
		
		
		System.out.println("* Le paquet de carreaux initial : \n");
		jeu.creerCarreaux();
		System.out.println(jeu.toStringCarreaux());

		
		System.out.println("* Tirage d'un carreau au hasard (test) : \n");
		jeu.trierCarreaux();
		
		Carreau c2 = jeu.tirerCarreau();
		Position p2 = new Position(0,2);
		System.out.println(c2.toString());
		
		System.out.println("* Les coordonnées du carreau tiré : \n");
		System.out.println(c2.toStringCoord());
		
		System.out.println("* Le placement du carreau à la position p2(0,2) : \n");
		jeu.placerCarreau(c2, p2);
		System.out.println(jeu.toStringMur());
		
	
		
		System.out.println("* La carte tirée est (test) : \n");
		Carte carteTiree = jeu.tirerCarte();
		System.out.println(carteTiree + "\n");
		
		System.out.println("* La carte tirée a bien été enlevée du paquet de cartes : \n");
		System.out.println(jeu.toStringCartes());
		
		System.out.println("* Le coup d'état : toutes les cartes implémentant l'interface ICarte changent de valeurs \n");
		jeu.coup_d_etat();
		System.out.println(jeu.toStringCartes());
	
	}
}
