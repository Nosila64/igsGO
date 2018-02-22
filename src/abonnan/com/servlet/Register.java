package abonnan.com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Utilisateur;
import packDAO.UtilisateurDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static final String FIELD_FIRSTNAME = "prenom";
    public static final String FIELD_NAME = "nom";
    public static final String FIELD_EMAIL = "mail";
    public static final String FIELD_PWD = "password";
    public static final String FIELD_CONFIRM_PWD = "Confirmpassword";
    public static final String FIELD_TEL = "numTel";

	
	public static final String ATT_USERS = "users";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		// TODO Auto-generated method stub
		 // Get form fields
        String email = request.getParameter(FIELD_EMAIL);
        String pwd = request.getParameter(FIELD_PWD);
        String pwdConfirm = request.getParameter(FIELD_CONFIRM_PWD);
        String name = request.getParameter(FIELD_NAME);
        String firstname = request.getParameter(FIELD_FIRSTNAME);
        String numTel = request.getParameter(FIELD_TEL);

        // Prepare results
        Map<String, String> erreurs = new HashMap<String, String>();
        Map<String, String> form = new HashMap<String, String>();
        String actionMessage=null;
        String msgVal=null;
       /*       
        msgVal=validateEmail(email);
        if(msgVal==null){
        	form.put(FIELD_EMAIL, email);
        }
        else{
            erreurs.put(FIELD_EMAIL, msgVal);
        }

        msgVal=validatePwd(pwd, pwdConfirm);
        if(msgVal==null){
        	form.put(FIELD_PWD, pwd);
        }
        else{
            erreurs.put(FIELD_CONFIRM_PWD, msgVal);
        }
   
        msgVal=validateName(name);
        if(msgVal==null){
        	form.put(FIELD_NAME, name);
        }
        else{
            erreurs.put(FIELD_NAME, msgVal);
        }
      */
        Utilisateur newUser=null;
        Map<String, Utilisateur> users = new HashMap<String, Utilisateur>();
        boolean errorStatus=true;
        if ( erreurs.isEmpty() ) {
            System.out.println(name);
            System.out.println(firstname);
            System.out.println(numTel);
            System.out.println(email+"@campus-igs-toulouse.fr");

            newUser=new Utilisateur(name, firstname ,email+"@campus-igs-toulouse.fr", pwd, numTel);
            UtilisateurDAO UserDAO = new UtilisateurDAO();
            UserDAO.addUser(newUser);
            System.out.println(newUser.getNom());
            users.put(newUser.getEmail(), newUser);
            HttpSession session = request.getSession();
            session.setAttribute("users", users);
                        
            actionMessage="Succès de l'inscription";            
            form = new HashMap<String, String>();
            errorStatus = false;
            response.sendRedirect(request.getContextPath()+"/Dashboard");
        }
        else{
        	actionMessage="Echec de l'inscription";
        	errorStatus = true;
            response.sendRedirect("http://www.facebook.fr");
        }
        request.setAttribute("newUser", newUser);
        request.setAttribute("form", form);
        request.setAttribute("erreurs", erreurs);
        request.setAttribute("errorStatus", errorStatus);
        request.setAttribute("actionMessage", actionMessage);
      
	}

}
