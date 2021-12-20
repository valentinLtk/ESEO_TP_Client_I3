<%@ page language="java" 
		 contentType="text/html; charset=UTF-8" 
		 pageEncoding="UTF-8"%>
		 
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Accueil | Web app Ville</title>
</head>
<body>
	<h1>Web app Ville</h1><br>
	
	<div class="home">
	
		<h3>
			Cette application permet de consulter la liste des villes françaises avec <br> 
			la possibilité de modifier les données ainsi que de calculer la distance <br>
			entre deux villes sélectionnées.
		</h3>
		
		<br>
		<br> 

		<form action="getVille" method="post">
			<input type="submit" value="Voir/modifier la liste"/>
		</form>
		
		<br> 
		
		<form action="getDistance" method="post">
			<input type="submit" value="Calculer une distance"/>
		</form>
	</div>
	
	<br>
	<br> 
	
	<footer>
		 Application web réalisée par Valentin LATANSKA et Simon MOLARD<br/>
		 Copyright ESEO 2021<br>
		 [TWIC][Mickael MORISSEAU]<br>	
	</footer>
</body>


</html>