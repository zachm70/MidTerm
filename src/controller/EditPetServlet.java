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
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
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
		DogHelper dh = new DogHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Integer breedId = Integer.parseInt(request.getParameter("pkid"));
		
		Dogs updateDog = dh.searchForDogById(tempId);
		
		String newName = request.getParameter("dogName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		LocalDate ld;
		
		try {
			ld=LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch (NumberFormatException e){
			ld=LocalDate.now();
		}
		
		SpeciesInformationHelper sih = new SpeciesInformationHelper();
		SpeciesInformation si = new SpeciesInformation();
		
		si = sih.searchForSpeciesById(breedId);
		
		updateDog.setBirthday(ld);
		updateDog.setBreed(si);
		updateDog.setName(newName);
		
		dh.updateDog(updateDog);
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
