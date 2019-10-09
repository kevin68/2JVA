package com.supinfo;

public class Main {

	// Tableau des prix
	public static final int[][] PRICES = {
			{ 100, 130, 170, 200 },
			{ 120, 160, 200, 230 },
			{ 130, 170, 210, 240 },
			{ 150, 190, 230, 260 },
			{ 0, 0, 270, 300 },
			{ 0, 0, 350, 400 }
		};

	// Tableau des descriptions
	public static final String[] DESCRIPTIONS = { 
			"Lavabo",
			"WC, Télévision",
			"Cabine douche, Télévision",
			"WC, Cabine douche, Télévision",
			"WC, Salle de bain + Douche, Télévision",
			"2 pièces, Salle de bain + Douche, WC, Télévision" 
		};

	public static void main(String[] args) {
		// On créer des chambres
		Chambre c1 = new Chambre(1, 1, 1);
		Chambre c2 = new Chambre(2, 1, 1);
		Chambre c3 = new Chambre(3, 2, 1);
		Chambre c4 = new Chambre(4, 2, 1);
		Chambre c5 = new Chambre(5, 3, 2);
		Chambre c6 = new Chambre(6, 3, 2);
		Chambre c7 = new Chambre(7, 4, 3);
		Chambre c8 = new Chambre(8, 5, 3);
		Chambre c9 = new Chambre(9, 6, 4);

		// On créer un hotel avex des chambres
		Hotel h = new Hotel(new Chambre[] { c1, c2, c3, c4, c5, c6, c7, c8, c9 });
		
		// On affiche les chambres pour 1 personne
		h.displayRooms(1, PRICES, DESCRIPTIONS);
	}

}
