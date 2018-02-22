package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the proposer database table.
 * 
 */
@Embeddable
public class ProposerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idArret;

	@Column(insertable=false, updatable=false)
	private int idTrajet;

	public ProposerPK() {
	}
	public int getIdArret() {
		return this.idArret;
	}
	public void setIdArret(int idArret) {
		this.idArret = idArret;
	}
	public int getIdTrajet() {
		return this.idTrajet;
	}
	public void setIdTrajet(int idTrajet) {
		this.idTrajet = idTrajet;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProposerPK)) {
			return false;
		}
		ProposerPK castOther = (ProposerPK)other;
		return 
			(this.idArret == castOther.idArret)
			&& (this.idTrajet == castOther.idTrajet);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idArret;
		hash = hash * prime + this.idTrajet;
		
		return hash;
	}
}