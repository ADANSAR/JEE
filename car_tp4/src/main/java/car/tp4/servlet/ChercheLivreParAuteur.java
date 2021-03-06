package car.tp4.servlet;

import car.tp4.entity.BookBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddPanier
 */
@WebServlet("/ChercheLivreParAuteur")
public class ChercheLivreParAuteur extends HttpServlet {

	@EJB
	private BookBean bookBean;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String auteur = request.getParameter("auteur");
		request.setAttribute("books", bookBean.getBookByAuteur(auteur));
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/jsp/book.jsp");
		dispatcher.forward(request, response);
	}

}
