package com.supinfo;

public class Hotel {
	private Chambre[] chambres;

	/**
	 * Constructeur pour créer un nouvel hotel
	 * @param chm Le tableau des chambres de l'hotel
	 */
	public Hotel(Chambre[] chm) {
		this.chambres = chm;
	}

	/**
	 * Affiche les chambre de l'hotel pour le nombre de personnes donné
	 * @param nbPeople le nombre de personnes à loger
	 * @param prices Le tableau des prix
	 * @param descriptions Le tableau des descriptions
	 */
	public void displayRooms(int nbPeople, int[][] prices, String[] descriptions) {
		// On boucle sur toutes les chambres
		for (Chambre b : this.chambres) {
			// Si le nombre de personne correspond
			if (b.getNbPeople() == nbPeople) {
				// On récupère le prix
				int price = b.getPrice(prices);
				// Si la chambre existe
				if (price != 0) {
					//On affiche une description de la chambre
					System.out.println("Room " + b.getNumber() + ": " + price + "€ with " + b.getDescription(descriptions));
				}
			}
		}
	}
}
