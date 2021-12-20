package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Ville;
import dao.VilleDAOImpl;


/**
 * Servlet implementation class editVille
 */
@WebServlet("/editVille")
public class EditVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VilleDAOImpl villeDAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("edited_Ville");
		
		HttpSession session = request.getSession();
		session.setAttribute("edited_Ville", villeDAO.getVilleById(id));
		
		String param = request.getParameter("edit");
		session.setAttribute("edit", param);
		
		// Calling JSP editVille.jsp
		this.getServletContext().getRequestDispatcher("/editVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		Ville ville = new Ville();
		
		ville.setCode_commune_INSEE(request.getParameter("Code_commune_INSEE"));
		ville.setNom_commune(request.getParameter("Nom_commune"));
		ville.setCode_postal(request.getParameter("Code_postal"));
		ville.setLibelle_acheminement(request.getParameter("Libelle_acheminement"));
		ville.setLigne_5(request.getParameter("Ligne_5"));
		ville.setLatitude(request.getParameter("Latitude"));
		ville.setLongitude(request.getParameter("Longitude"));
		
		villeDAO.editVille(ville);
		
		session.setAttribute("editVille", ville);
		
		doGet(request, response);
	}

}
