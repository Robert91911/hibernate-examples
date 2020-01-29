package org.madrid.Metro.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the linea_estacion database table.
 * 
 */
@Embeddable
public class LineaEstacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int lineaId;

	@Column(insertable=false, updatable=false)
	private int estacionId;

	public LineaEstacionPK() {
	}
	public int getLineaId() {
		return this.lineaId;
	}
	public void setLineaId(int lineaId) {
		this.lineaId = lineaId;
	}
	public int getEstacionId() {
		return this.estacionId;
	}
	public void setEstacionId(int estacionId) {
		this.estacionId = estacionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LineaEstacionPK)) {
			return false;
		}
		LineaEstacionPK castOther = (LineaEstacionPK)other;
		return 
			(this.lineaId == castOther.lineaId)
			&& (this.estacionId == castOther.estacionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.lineaId;
		hash = hash * prime + this.estacionId;
		
		return hash;
	}
}