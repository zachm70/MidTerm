package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dogs;

/**
 * Servlet implementation class PetNavigationServlet
 */
@WebServlet("/petNavigationServlet")
public class PetNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PetNavigationServlet() {
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
		String act = request.getParameter("doThisToPet");
		
		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request,response);
			
		} else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("petId"));
				Dogs dogToDelete = dh.searchForDogById(tempId);
				dh.deleteDog(dogToDelete);
			}catch(NumberFormatException ex) {
				System.out.println("forgot to click a button");
			}finally {
				getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
			}
		} else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("petId"));
				
				Dogs edit = dh.searchForDogById(tempId);
				
				request.setAttribute("dogToEdit", edit);
				request.setAttribute("month", edit.getBirthday().getMonthValue());
				request.setAttribute("date", edit.getBirthday().getDayOfMonth());
				request.setAttribute("year", edit.getBirthday().getYear());
				
				SpeciesInformationHelper sih = new SpeciesInformationHelper();
				
				request.setAttribute("allBreeds", sih.showAllSpecies());
				
				getServletContext().getRequestDispatcher("/editPet.jsp").forward(request, response);
			}catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
			}
		}else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/newPetServlet").forward(request, response);
		}
	}

}
