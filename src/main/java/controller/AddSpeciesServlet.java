package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SpeciesInformation;

/**
 * Servlet implementation class AddSpeciesServlet
 */
@WebServlet("/addSpeciesServlet")
public class AddSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpeciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String species = request.getParameter("species");
		String breed = request.getParameter("breed");
		int age = Integer.parseInt(request.getParameter("avgAge"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		SpeciesInformation si = new SpeciesInformation(species, breed, age, weight);
		SpeciesInformationHelper sih = new SpeciesInformationHelper();
		sih.insertItem(si);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
