package beans;

/**
 * Class Ville 
 * 
 * @author Valentin Latanska 
 */
public class Ville {
	public String Code_commune_INSEE;
	public String Nom_commune;
	public String Code_postal;
	public String Libelle_acheminement;
	public String Ligne_5;
	public String Latitude;
	public String Longitude;
	
	/*
	 * Ville contrustructor without param
	 */
	public Ville() {
		super();
	}
	
	/*
	 * Ville constructor with param:
	 * 
	 *@param latitude
	 *@param longitude
	 */
	public Ville(String latitude, String longitude) {
		this.Latitude = latitude;
		this.Longitude = longitude;
	}
	
	/*
	 * Ville constructor with param:
	 * 
	 * @param Nom_commune
	 */
	public Ville(String Nom_commune) {
		this.Nom_commune = Nom_commune;
	}

	/**
	 * @return the code_commune_INSEE
	 */
	public String getCode_commune_INSEE() {
		return Code_commune_INSEE;
	}

	/**
	 * @param code_commune_INSEE the code_commune_INSEE to set
	 */
	public void setCode_commune_INSEE(String code_commune_INSEE) {
		Code_commune_INSEE = code_commune_INSEE;
	}

	/**
	 * @return the nom_commune
	 */
	public String getNom_commune() {
		return Nom_commune;
	}

	/**
	 * @param nom_commune the nom_commune to set
	 */
	public void setNom_commune(String nom_commune) {
		Nom_commune = nom_commune;
	}

	/**
	 * @return the code_postal
	 */
	public String getCode_postal() {
		return Code_postal;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		Code_postal = code_postal;
	}

	/**
	 * @return the libelle_acheminement
	 */
	public String getLibelle_acheminement() {
		return Libelle_acheminement;
	}

	/**
	 * @param libelle_acheminement the libelle_acheminement to set
	 */
	public void setLibelle_acheminement(String libelle_acheminement) {
		Libelle_acheminement = libelle_acheminement;
	}

	/**
	 * @return the ligne_5
	 */
	public String getLigne_5() {
		return Ligne_5;
	}

	/**
	 * @param ligne_5 the ligne_5 to set
	 */
	public void setLigne_5(String ligne_5) {
		Ligne_5 = ligne_5;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return Latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return Longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	
}
