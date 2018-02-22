package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inscrire database table.
 * 
 */
@Entity
@NamedQuery(name="Inscrire.findAll", query="SELECT i FROM Inscrire i")
public class Inscrire implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InscrirePK id;

	//bi-directional many-to-one association to Arret
	@ManyToOne
	@JoinColumn(name="idArret")
	private Arret arret;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	@JoinColumn(name="idTrajet")
	private Trajet trajet;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur utilisateur;

	public Inscrire() {
	}

	public InscrirePK getId() {
		return this.id;
	}

	public void setId(InscrirePK id) {
		this.id = id;
	}

	public Arret getArret() {
		return this.arret;
	}

	public void setArret(Arret arret) {
		this.arret = arret;
	}

	public Trajet getTrajet() {
		return this.trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}