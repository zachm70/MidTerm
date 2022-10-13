package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SpeciesInformation;

/**
 * Servlet implementation class EditSpeciesServlet
 */
@WebServlet("/editSpeciesServlet")
public class EditSpeciesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSpeciesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String breed = request.getParameter("breed");
		int age = Integer.parseInt(request.getParameter("avgAge"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		SpeciesInformation si = new SpeciesInformation(breed, age, weight);
		SpeciesInformationHelper sih = new SpeciesInformationHelper();
		si.setBreed(breed);
		si.setAvgAge(age);
		si.setHealthyWeight(weight);
		sih.updateSpecies(si);
		getServletContext().getRequestDispatcher("/viewAllSpeciesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
