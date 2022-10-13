package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SpeciesInformation;


/**
 * Servlet implementation class SpeciesNavigationServlet
 */
@WebServlet("/SpeciesNavigationServlet")
public class SpeciesNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpeciesNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SpeciesInformationHelper sih = new SpeciesInformationHelper();
		String act = request.getParameter("doThisToItem");

		String path = "/viewAllSpeciesServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("pkid"));
				SpeciesInformation speciesToDelete = sih.searchForSpeciesById(tempId);
				sih.deleteSpecies(speciesToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a species");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("pkid"));
				SpeciesInformation speciesToEdit = sih.searchForSpeciesById(tempId);
				request.setAttribute("speciesToEdit", speciesToEdit);
				path = "/edit-species.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}

		} else if (act.equals("add"))

		{
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
	

}
