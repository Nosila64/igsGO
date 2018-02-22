package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the proposer database table.
 * 
 */
@Entity
@NamedQuery(name="Proposer.findAll", query="SELECT p FROM Proposer p")
public class Proposer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProposerPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date heurePassage;

	//bi-directional many-to-one association to Arret
	@ManyToOne
	@JoinColumn(name="idArret")
	private Arret arret;

	//bi-directional many-to-one association to Trajet
	@ManyToOne
	@JoinColumn(name="idTrajet")
	private Trajet trajet;

	public Proposer() {
	}

	public ProposerPK getId() {
		return this.id;
	}

	public void setId(ProposerPK id) {
		this.id = id;
	}

	public Date getHeurePassage() {
		return this.heurePassage;
	}

	public void setHeurePassage(Date heurePassage) {
		this.heurePassage = heurePassage;
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

}