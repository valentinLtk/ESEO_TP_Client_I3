package dao;

import java.util.ArrayList;
import beans.Ville;

public interface VilleDAO {
	
	/**
	 * Returning all 'Ville' method
	 * 
	 * @param start 
	 * @param total
	 */
	 ArrayList<Ville> getVille();
	
	/**
	 * Returning all ville with param:
	 * 
	 * @param id
	 */
	Ville getVilleById(String id);

	/**
	 * Returning distance between two Ville objects
	 * 
	 * @param villeDepart
	 * @param villeArrivee
	 */
	float getDistance(Ville villeDepart, Ville villeArrivee);
	
	/*
	 * Editing Ville oject in param:
	 * 
	 * @param ville the Ville object to edit
	 */
	void editVille(Ville ville);
	
}