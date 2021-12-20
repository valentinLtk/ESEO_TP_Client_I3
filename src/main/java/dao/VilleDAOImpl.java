package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Ville;


public class VilleDAOImpl implements VilleDAO {
	
	public static Connection getConnection() {  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(
            		"jdbc:mysql://localhost:8889/Projet_TWIC", "root", "root");  
        } catch(Exception e) {
        	System.out.println(e);
        }  
        return con;  
    }

	@Override
	public ArrayList<Ville> getVille() {		
		
		ArrayList<Ville> villes = new ArrayList<Ville>();

		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM ville_france;");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Ville ville = new Ville();
								
				ville.setNom_commune(rs.getString("Nom_commune"));
				ville.setCode_postal(rs.getString("Code_postal"));

				villes.add(ville);
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public Ville getVilleById(String id) {

		Ville ville = new Ville();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM ville_france WHERE Code_commune_INSEE = " + id + ";");
			ResultSet rs = ps.executeQuery();
						
			ville.setNom_commune(rs.getString("Nom_commune"));
			ville.setCode_postal(rs.getString("Code_postal"));			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ville;
	}
	
	@Override
	public float getDistance(Ville villeDepart, Ville villeArrivee) {
		
		float distance = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"SELECT Latitude, Longitude FROM ville_france WHERE Code_commune_INSEE = "
					+ villeDepart.getCode_commune_INSEE() + ";");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PreparedStatement ps2 = con.prepareStatement(
						"SELECT Latitude, Longitude FROM ville_france WHERE Code_commune_INSEE = "
						+ villeDepart.getCode_commune_INSEE() + ";");
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {
					float deltaX = 
							(float) Math.pow(Math.abs(rs.getFloat("Latitude") - rs2.getFloat("Latitude")), 2.0);
					float deltaY = 
							(float) Math.pow(Math.abs(rs.getFloat("Longitude") - rs2.getFloat("Longitude")), 2.0);
					distance = (float) Math.sqrt(deltaX + deltaY);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return distance;
	}
	
	@Override
	public void editVille(Ville ville) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ville_france SET Nom_commune = '" + ville.getNom_commune()
							+ "' WHERE Code_commune_INSEE = " + ville.getCode_commune_INSEE() 
							+ ";");

			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
