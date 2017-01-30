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
		 * On trie la liste des distances par ordre croissant et on enl�ve les doublons
		 * On prend une distance (en parcourant la liste dans l'ordre croissant)
		 * On g�n�re pour chaque point la liste des voisins � cette distance
		 * On met dans les centres le point qui a la liste la plus grande
		 * On ajoute l'index de tous les points couverts par ces centres dans une liste annexe
		 * On r�g�n�re la liste des voisins, on fait l'intersection avec les points d�j� couverts
		 * On continue comme �a jusqu'� atteindre k
		 * S'il reste encore des points une fois k atteint, on s'arr�te et on passe � la distance suivante
		 * S'il n'y a plus de points � couvrir, on s'arr�te et on renvoie k
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
