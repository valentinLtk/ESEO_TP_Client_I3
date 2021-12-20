<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 import="java.util.*,dao.*,beans.*" %>  

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		   prefix="c" %>
		      
<!DOCTYPE html>
    
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes | Web App Ville</title>
</head>
<body>
	<h1>Liste des villes</h1><br>	

	<form action="getVille" method="post">
		<div>
			<div>
				<c:set var="size" scope="session" value="${villes.size()}"/>
				<c:set var="rowsPerPage" scope="session" value="50"/>
				<c:set var="start" value="${param.start}"/>
	
				<c:if test="${empty start or start < 0}">
					<c:set var="start" value="0" />
				</c:if>
				
				<c:if test="${size < start}">
					<c:set var="start" value="${start - 50}" />
				</c:if>
	
				<!-- Display of all Ville elements -->
				<table class="table table-striped table-bordered" style="width: 100%">
					<tbody>
						<tr>
							<th>Commune</th>
							<th>Code postal</th>
						</tr>
	
						<c:forEach var="current" 
								   items="${villes}" 
								   varStatus="status" 
								   begin="${start}" 
								   end="${start + rowsPerPage - 1}">
							<tr>
								<td>${current.getNom_commune()}</td>
								<td>${current.getCode_postal()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 			
			</div>
		</div>
	</form>
			
	<!-- Edit Ville element -->
	<label for="selectVille">Sélectionnez une ville pour la modifier</label> 
	<select name="edited_ville" id="selectVille">
		<option value="">-</option>
		<c:forEach items="${villes}" var="current" varStatus="status">
			<option value="${current.getCode_commune_INSEE()}">
				${current.getNom_commune()} (${current.getCode_postal()})
			</option>
			
			<input type="submit" value="Modifier"/>
			
		</c:forEach>
	</select>
	
	<br><br>		

	<!-- Page number management -->
	<a class="page-link" href="?startParam=${start - 50}">Précédent</a>
	<a class="page-link">
	Page ${Math.round((start/50) + 1)} / ${Math.round((getVilleNumber/50) + 1)}
	</a>
	<a class="page-link" href="?startParam=${start + 50}">Suivant</a>

	<!-- Return home button -->
	<form action="home" method="post">
		<input type="submit" value="Retour"/>
	</form>

</body>
</html>