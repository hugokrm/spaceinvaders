package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.Dimension;
import fr.unilim.iut.spaceinvaders.Position;

public class Vaisseau {
	int x;
	int y;
	Position origine;
	Dimension dimension;
	int longueur;
	int hauteur;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}

	public Vaisseau(int longueur, int hauteur, int x, int y) {
		   this.dimension = new Dimension(longueur, hauteur);
		   this.origine = new Position (x,y);
		   }

	public boolean occupeLaPosition(int x, int y) {
		return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
	}

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusHaute() <= y) && (y <= ordonneeLaPlusBasse());
	}

	public int ordonneeLaPlusBasse() {
		return this.origine.ordonnee();
	}

	public int ordonneeLaPlusHaute() {
		return ordonneeLaPlusBasse() - this.hauteur + 1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public int abscisseLaPlusADroite() {
		return abscisseLaPlusAGauche() + this.dimension.longueur() - 1;
	}

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse()+1);

	}

	public int abscisse() {
		return abscisseLaPlusAGauche();
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse()-1);

	}

	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		  this.origine.changerOrdonnee(y);

	}

}
