package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dogs;
import model.SpeciesInformation;

/**
 * Servlet implementation class CreatePetServlet
 */
@WebServlet("/createPetServlet")
public class CreatePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DogHelper dh = new DogHelper();
		SpeciesInformationHelper sih = new SpeciesInformationHelper();
		
		String name = request.getParameter("petName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		Integer tempId = Integer.parseInt(request.getParameter("pkid"));
		
		SpeciesInformation si = sih.searchForSpeciesById(tempId);

		Dogs dog = new Dogs(name, si, ld);
		
		dh.insertNewDog(dog);
		
		System.out.println(dog.toString());
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
