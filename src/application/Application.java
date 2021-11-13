package application;

import java.util.Scanner;

import carreau.Carreau;
import carte.Carte;
import enumeration.Couleur;
import position.Position;

public class Application {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		
		System.out.println(jeu.toStringMur());
		
		jeu.creerCartes();
		System.out.println(jeu.toStringCartes());
		
		jeu.creerCarreauxC();
		System.out.println(jeu.toStringCarreauxC());

		Carreau test = jeu.tirerCarreau();
		System.out.println(test.toString());

		
		Carreau c = new Carreau(3,1,'x');
		Position p = new Position(2,2);
		System.out.println(c.toString());
		System.out.println(c.toStringCoord());
		//System.out.println(c.getCoord(0));

		
		System.out.println(c.getHauteur());
		System.out.println(c.getLargeur());
		jeu.placerCarreau(c, p);
		System.out.println(jeu.toStringMur());
		
		
		Scanner sc = new Scanner(System.in);
		boolean inGame =true;
		//while (inGame) {
			jeu.trierCarte();
			Carte carteTiree = jeu.tirerCarte();
			System.out.println(carteTiree);
		//}
	}
}
