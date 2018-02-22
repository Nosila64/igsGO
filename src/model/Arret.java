package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the arret database table.
 * 
 */
@Entity
@NamedQuery(name="Arret.findAll", query="SELECT a FROM Arret a")
public class Arret implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArret;

	private String adresse;

	private float lat;

	private float lng;

	//bi-directional many-to-one association to Inscrire
	@OneToMany(mappedBy="arret")
	private List<Inscrire> inscrires;

	//bi-directional many-to-one association to Proposer
	@OneToMany(mappedBy="arret")
	private List<Proposer> proposers;

	public Arret() {
	}

	public int getIdArret() {
		return this.idArret;
	}

	public void setIdArret(int idArret) {
		this.idArret = idArret;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getLat() {
		return this.lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return this.lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public List<Inscrire> getInscrires() {
		return this.inscrires;
	}

	public void setInscrires(List<Inscrire> inscrires) {
		this.inscrires = inscrires;
	}

	public Inscrire addInscrire(Inscrire inscrire) {
		getInscrires().add(inscrire);
		inscrire.setArret(this);

		return inscrire;
	}

	public Inscrire removeInscrire(Inscrire inscrire) {
		getInscrires().remove(inscrire);
		inscrire.setArret(null);

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
		proposer.setArret(this);

		return proposer;
	}

	public Proposer removeProposer(Proposer proposer) {
		getProposers().remove(proposer);
		proposer.setArret(null);

		return proposer;
	}

}