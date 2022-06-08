package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the aaerodrom_account database table.
 * 
 */
@Entity
@Table(name="aaerodrom_account")
@NamedQuery(name="AaerodromAccount.findAll", query="SELECT a FROM AaerodromAccount a")
public class AaerodromAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAccount;

	private String password;

	private String username;

	//bi-directional many-to-many association to AaerodromRole
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="aaerodromAccounts")
	private Set<AaerodromRole> aaerodromRoles = new HashSet<AaerodromRole>();

	public AaerodromAccount() {
	}

	public int getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<AaerodromRole> getAaerodromRoles() {
		return this.aaerodromRoles;
	}

	public void setAaerodromRoles(Set<AaerodromRole> aaerodromRoles) {
		this.aaerodromRoles = aaerodromRoles;
	}

}