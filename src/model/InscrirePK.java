package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inscrire database table.
 * 
 */
@Embeddable
public class InscrirePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUser;

	@Column(insertable=false, updatable=false)
	private int idTrajet;

	@Column(insertable=false, updatable=false)
	private int idArret;

	public InscrirePK() {
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdTrajet() {
		return this.idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}
	public int getIdArret() {
		return this.idArret;
	}
	public void setIdArret(int idArret) {
		this.idArret = idArret;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InscrirePK)) {
			return false;
		}
		InscrirePK castOther = (InscrirePK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.idTrajet == castOther.idTrajet)
			&& (this.idArret == castOther.idArret);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.idTrajet;
		hash = hash * prime + this.idArret;
		
		return hash;
	}
}