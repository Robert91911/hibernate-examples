package ejemplo;
// Generated 10-dic-2019 12:32:57 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonAddressId generated by hbm2java
 */
@Embeddable
public class PersonAddressId implements java.io.Serializable {

	private long personId;
	private long addressId;

	public PersonAddressId() {
	}

	public PersonAddressId(long personId, long addressId) {
		this.personId = personId;
		this.addressId = addressId;
	}

	@Column(name = "person_id", nullable = false)
	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	@Column(name = "address_id", nullable = false)
	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonAddressId))
			return false;
		PersonAddressId castOther = (PersonAddressId) other;

		return (this.getPersonId() == castOther.getPersonId()) && (this.getAddressId() == castOther.getAddressId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getPersonId();
		result = 37 * result + (int) this.getAddressId();
		return result;
	}

}
