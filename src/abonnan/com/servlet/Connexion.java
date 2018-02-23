package abonnan.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utilisateur;
import packDAO.UtilisateurDAO;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/login")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// View
		public static String VIEW_PAGES_URL = "/WEB-INF/index.jsp";

		// Form fields
		public static final String FIELD_EMAIL = "email";
		public static final String FIELD_PWD = "password";

		// Request attributs
		Map<String, String> erreur;// = new HashMap<String, String>();
		Map<String, String> form;// = new HashMap<String, String>();
		String statusMessage = "";
		boolean statusOk = false;
		String msgVal = null;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public Connexion() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Prepare model to view
			request.setAttribute("statusOK", false);
			request.setAttribute("statusMessage", "");

			// Build view
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Get form fields
			String email = request.getParameter(FIELD_EMAIL);
			String pwd = request.getParameter(FIELD_PWD);

			// Prepare data for view (attributs)
			erreur = new HashMap<String, String>();
			form = new HashMap<String, String>();
			statusMessage = null;

			// Validate page

			if (erreur.isEmpty() && authenticate(email, pwd)) {
				statusOk = true;
				statusMessage = "Connecté";
				response.sendRedirect(request.getContextPath() + "/Dashboard");
			} else {
				statusOk = false;
				statusMessage = "Connexion refusée";
				// Prepare model to view
				request.setAttribute("form", form);
				request.setAttribute("error", erreur);
				request.setAttribute("statusOK", statusOk);
				request.setAttribute("statusMessage", statusMessage);
				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			}

			// Prepare model to view
			request.setAttribute("form", form);
			request.setAttribute("error", erreur);
			request.setAttribute("statusOK", statusOk);
			request.setAttribute("statusMessage", statusMessage);

			// Build view
			this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
		}

		private boolean authenticate(String login, String pwd) {
			System.out.println(login);
			System.out.println(pwd);
			UtilisateurDAO UserDAO = new UtilisateurDAO();
			Utilisateur User = UserDAO.getUserByEmail(login + "@campus-igs-toulouse.fr", pwd);
			if (User != null) {
				login = login + "@campus-igs-toulouse.fr";
				if (login.equals(User.getEmail())) {
					if (pwd.equals(User.getPassword())) {
						return true;
					}
					return false;
				}
				return false;
			}
				return false;
		}

}
