<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="beans.Ville"%>
         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier une ville | Web App Ville</title>
</head>
<body>
	<h1>Modifier une ville</h1>
	
	<%Ville edited_Ville = (Ville) session.getAttribute("edited_Ville"); %>
	
	<form class="edit" action="editVille" method="post">

		<p>Code commune INSEE :
		<input type="text" 
			   id=Code_Commune_INSEE 
			   name="Code_Commune_INSEE" 
			   value="<%=edited_Ville.getCode_commune_INSEE()%>">
		</p>

		<p>Commune :
		<input type="text" 
			   id="Nom_commune" 
			   name="Nom_commune"
			   value="<%=edited_Ville.getNom_commune()%>">			   
		</p>
			
		<p>Code postal :
		<input type="text" 
			   id="Code_postal" 
			   name="Code_postal"
			   value="<%=edited_Ville.getCode_postal()%>"> 
		</p>
			
		<p>Libellé :
		<input type="text" 
			   id="libelle" 
			   name="libelle"
			   value="<%=edited_Ville.getLibelle_acheminement()%>"> 
	    </p>
			
		<p>Longitude :
		<input type="text" 
			   id="Longitude" 
			   name="Longitude"
			   value="<%=edited_Ville.getLongitude()%>"> 
	    </p>
			
		<p>Latitude :
		<input type="text" 
			   id="Latitude" 
			   name="Latitude"
			   value="<%=edited_Ville.getLatitude()%>"> 
		</p>

		<input type="submit" value="Enregistrer"/>
	</form>
	
	<!-- Return home button -->
	<form action="home" method="post" >
		<input type="submit" value="Retour"/>
	</form>
</body>
</html>