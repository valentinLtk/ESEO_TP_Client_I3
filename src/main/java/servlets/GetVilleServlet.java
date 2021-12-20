package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VilleDAOImpl;

/**
 * Servlet implementation class getVille
 */
@WebServlet("/getVille")
public class GetVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VilleDAOImpl villeDAO;
	String startParam = "";


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		request.setAttribute("villes", villeDAO.getVille());
		request.setAttribute("size", villeDAO.getVille().size());
		startParam = request.getParameter("start");

		// Calling JSP getVille.jsp
		this.getServletContext().getRequestDispatcher("getVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		startParam = request.getParameter("start");
		doGet(request, response);
	}

}
