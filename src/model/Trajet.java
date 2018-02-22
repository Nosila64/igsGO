package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trajet database table.
 * 
 */
@Entity
@NamedQuery(name="Trajet.findAll", query="SELECT t FROM Trajet t")
public class Trajet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTrajet;

	@Temporal(TemporalType.DATE)
	private Date dateTrajet;

	private int nbPlace;

	//bi-directional many-to-one association to Inscrire
	@OneToMany(mappedBy="trajet")
	private List<Inscrire> inscrires;

	//bi-directional many-to-one association to Proposer
	@OneToMany(mappedBy="trajet")
	private List<Proposer> proposers;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idUser")
	private Utilisateur utilisateur;

	public Trajet() {
	}

	public int getIdTrajet() {
		return this.idTrajet;
	}

	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}

	public Date getDateTrajet() {
		return this.dateTrajet;
	}

	public void setDateTrajet(Date dateTrajet) {
		this.dateTrajet = dateTrajet;
	}

	public int getNbPlace() {
		return this.nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public List<Inscrire> getInscrires() {
		return this.inscrires;
	}

	public void setInscrires(List<Inscrire> inscrires) {
		this.inscrires = inscrires;
	}

	public Inscrire addInscrire(Inscrire inscrire) {
		getInscrires().add(inscrire);
		inscrire.setTrajet(this);

		return inscrire;
	}

	public Inscrire removeInscrire(Inscrire inscrire) {
		getInscrires().remove(inscrire);
		inscrire.setTrajet(null);

		return inscrire;
	}

	public List<Proposer> getProposers() {
		return this.proposers;
	}

	public void setProposers(List<Proposer> proposers) {
		this.proposers = proposers;
	}

	public Proposer addProposer(Proposer proposer) {
		getProposers().add(proposer);
		proposer.setTrajet(this);

		return proposer;
	}

	public Proposer removeProposer(Proposer proposer) {
		getProposers().remove(proposer);
		proposer.setTrajet(null);

		return proposer;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}