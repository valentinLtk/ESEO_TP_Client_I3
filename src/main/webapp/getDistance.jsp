<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		   prefix="c" %>
		   
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Calculer une distance | Web App Ville</title>
</head>
<body>
	<h1>Calculer une distance</h1><br>	
	
	<h3>Sélectionner deux villes pour calculer la distance les séparant</h3><br>	
	
	<form class="distance" action="getDistance" method="post">
		
		<!-- Ville choice #1  -->
		<label for="select1">Choisissez une ville de départ</label> 
		<select name="villeDepart" id="select1">
			<option value="">-</option>
			<c:forEach items="${getVille}" var="current" varStatus="status">
				<option value="${current.getCode_commune_INSEE()}">
					${current.getNom_commune()} (${current.getCode_postal()})
				</option>
			</c:forEach>
		</select> 
		
		<br><br> 
			
		<!-- Ville choice #2  -->
		<label for="select2">Choisissez une ville d'arrivée</label> 
		<select name="villeArrivee" id="select2" onchange="">
			<option value="">-</option>
			<c:forEach items="${getVille}" var="current" varStatus="status">
				<option value="${current.getCode_commune_INSEE()}">
					${current.getNom_commune()} (${current.getCode_postal()})
				</option>
			</c:forEach>
		</select>
	
		<br><br>
			
		<input type="submit" value="Calculer"/>		
		
		<br><br>
	
		<h3>
			Distance calculée :<strong>${distance} km</strong>
		</h3>
	</form>

	<!-- Return home button -->
	<form action="home" method="post">
		<input type="submit" value="Retour"/>
	</form>
	
</body>
</html>