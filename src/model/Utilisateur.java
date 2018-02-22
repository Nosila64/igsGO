package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	public Utilisateur(String email) {
		this.email = email;
	}
	
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	@Temporal(TemporalType.DATE)
	private Date datePermis;

	private String email;

	private float latDepart;

	private float lngDepart;

	private String nom;

	private int note;

	private String numTel;

	private String password;

	private String prenom;

	private String ptDepart;

	private String vehicule;

	//bi-directional many-to-one association to Inscrire
	@OneToMany(mappedBy="utilisateur")
	private List<Inscrire> inscrires;

	//bi-directional many-to-one association to Trajet
	@OneToMany(mappedBy="utilisateur")
	private List<Trajet> trajets;

	public Utilisateur() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDatePermis() {
		return this.datePermis;
	}

	public void setDatePermis(Date datePermis) {
		this.datePermis = datePermis;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getLatDepart() {
		return this.latDepart;
	}

	public void setLatDepart(float latDepart) {
		this.latDepart = latDepart;
	}

	public float getLngDepart() {
		return this.lngDepart;
	}

	public void setLngDepart(float lngDepart) {
		this.lngDepart = lngDepart;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getNumTel() {
		return this.numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPtDepart() {
		return this.ptDepart;
	}

	public void setPtDepart(String ptDepart) {
		this.ptDepart = ptDepart;
	}

	public String getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}

	public List<Inscrire> getInscrires() {
		return this.inscrires;
	}

	public void setInscrires(List<Inscrire> inscrires) {
		this.inscrires = inscrires;
	}

	public Inscrire addInscrire(Inscrire inscrire) {
		getInscrires().add(inscrire);
		inscrire.setUtilisateur(this);

		return inscrire;
	}

	public Inscrire removeInscrire(Inscrire inscrire) {
		getInscrires().remove(inscrire);
		inscrire.setUtilisateur(null);

		return inscrire;
	}

	public List<Trajet> getTrajets() {
		return this.trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public Trajet addTrajet(Trajet trajet) {
		getTrajets().add(trajet);
		trajet.setUtilisateur(this);

		return trajet;
	}

	public Trajet removeTrajet(Trajet trajet) {
		getTrajets().remove(trajet);
		trajet.setUtilisateur(null);

		return trajet;
	}

}