package com.supinfo;

public class Chambre {
	private int number;
	private int category;
	private int nbPeople;

	/**
	 * Contructeur pour créer des chambres
	 * @param nb Numéro de la chambre
	 * @param cat Catégorie de la chambre
	 * @param pep Nombre de personne pouvant occuper la chambre
	 */
	public Chambre(int nb, int cat, int pep)
	{
		this.number = nb;
		this.category = cat;
		this.nbPeople = pep;
	}
	
	public int getNumber() {
		return number;
	}

	public int getCategory() {
		return category;
	}

	public int getNbPeople() {
		return nbPeople;
	}

	/**
	 * Donne le prix de la chambre en fonction du tableau de prix donné
	 * @param prices Le tableau de prix à utiliser pour trouver le prix
	 * @return le prix de la chambre
	 */
	public int getPrice(int[][] prices) {
		return prices[this.category - 1][this.nbPeople - 1];
	}

	/**
	 * Donne la description de la chambre en fonction des descriptions données
	 * @param descriptions Le tableau des descriptions
	 * @return la description de la chambre
	 */
	public String getDescription(String[] descriptions) {
		return descriptions[this.category - 1];
	}
}
