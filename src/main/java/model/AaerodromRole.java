package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the aaerodrom_role database table.
 * 
 */
@Entity
@Table(name="aaerodrom_role")
@NamedQuery(name="AaerodromRole.findAll", query="SELECT a FROM AaerodromRole a")
public class AaerodromRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String role;

	//bi-directional many-to-many association to AaerodromAccount
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="aaerodrom_account_role"
		, joinColumns={
			@JoinColumn(name="AAerodrom_role_idRole")
			}
		, inverseJoinColumns={
			@JoinColumn(name="AAerodrom_account_idAccount")
			}
		)
	private Set<AaerodromAccount> aaerodromAccounts = new HashSet<AaerodromAccount>();

	public AaerodromRole() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<AaerodromAccount> getAaerodromAccounts() {
		return this.aaerodromAccounts;
	}

	public void setAaerodromAccounts(Set<AaerodromAccount> aaerodromAccounts) {
		this.aaerodromAccounts = aaerodromAccounts;
	}

}