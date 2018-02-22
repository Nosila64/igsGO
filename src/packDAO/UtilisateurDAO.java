package packDAO;



import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Utilisateur;

public class UtilisateurDAO {
	
	EntityManagerFactory emF; 
	EntityManager em;
	
    public UtilisateurDAO(){
    	String persistenceUnitName="igsgo";
    	emF=Persistence.createEntityManagerFactory(persistenceUnitName);
    	em = emF.createEntityManager();
    }
    
    public void addUser() {
    	em.getTransaction().begin();
    	Utilisateur User = new Utilisateur();
    	User.setPrenom("Alison");
    	User.setNom("Bonnan");
    	em.persist(User);
    	em.getTransaction().commit();
    	em.close();
    	emF.close();
    	System.out.println("Utilisateur Ajouté !");
    }
    
    public Utilisateur getUserByEmail(String email, String pwd ) {
    	em.getTransaction().begin();
    	Utilisateur User = null;
    	Query query = em.createQuery("Select u from Utilisateur u where u.email = :email AND u.password = :password");
    	query.setParameter("email", email);
    	query.setParameter("password",pwd);
    	@SuppressWarnings("unchecked")
		List<Utilisateur> list = (List<Utilisateur>) query.getResultList();
    	for(Utilisateur u: list) {
    		User = new Utilisateur(u.getEmail());
    	}
    	return User;
    }
}
