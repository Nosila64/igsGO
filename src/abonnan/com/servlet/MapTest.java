package abonnan.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import packDAO.UtilisateurDAO;

/**
 * Servlet implementation class MapTest
 */
@WebServlet("/MapTest")
public class MapTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String API_KEY = "AIzaSyDQIRnlcNXqCHQV75eFmPe8Li6U_02u5xw";   
    private String URL_VIEW = "/WEB-INF/mapTest.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtilisateurDAO UserDAO = new UtilisateurDAO();
		Utilisateur User = UserDAO.getUserByEmail("shysao@gmail.com", "123456");
		System.out.println(User.getEmail());
		this.getServletContext().getRequestDispatcher(URL_VIEW).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
