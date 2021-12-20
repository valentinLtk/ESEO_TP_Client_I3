package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Ville;
import dao.VilleDAOImpl;

/**
 * Servlet implementation class getDistance
 */
@WebServlet("/getDistance")
public class GetDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VilleDAOImpl villeDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setAttribute("villes", villeDAO.getVille());
		
		// Calling JSP getDistance.jsp
		this.getServletContext().getRequestDispatcher("/getDistance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Ville villeDepart = new Ville();
		Ville villeArrivee = new Ville();

		// Retrieving Ville inputs from JSP
		villeDepart.setCode_commune_INSEE(request.getParameter("villeDepart"));
		villeArrivee.setCode_commune_INSEE(request.getParameter("villeArrivee"));
		
		// Setting attribute "distance" to value returned by DAO getDistance() 
		request.setAttribute("distance", villeDAO.getDistance(villeDepart, villeArrivee));
		
		doGet(request, response);
	}

}
