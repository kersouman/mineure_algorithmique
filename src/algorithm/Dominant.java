package algorithm;

import java.util.ArrayList;

import instance.Instance;

public class Dominant extends Algorithm {

	public Dominant(Instance instance) {
		super(instance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Integer> resoudre() {
		/*Principe
		 * On trie la liste des distances par ordre croissant et on enlève les doublons
		 * On prend une distance (en parcourant la liste dans l'ordre croissant)
		 * On génère pour chaque point la liste des voisins à cette distance
		 * On met dans les centres le point qui a la liste la plus grande
		 * On ajoute l'index de tous les points couverts par ces centres dans une liste annexe
		 * On régénère la liste des voisins, on fait l'intersection avec les points déjà couverts
		 * On continue comme ça jusqu'à atteindre k
		 * S'il reste encore des points une fois k atteint, on s'arrête et on passe à la distance suivante
		 * S'il n'y a plus de points à couvrir, on s'arrête et on renvoie k
		 */
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getMaxDistance(ArrayList<Integer> listeCentres) {
		// TODO Auto-generated method stub
		return 0;
	}

}
