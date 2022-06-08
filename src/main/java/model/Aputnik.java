package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aputnik database table.
 * 
 */
@Entity
@NamedQuery(name="Aputnik.findAll", query="SELECT a FROM Aputnik a")
public class Aputnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String ime;

	private String jmbg;

	private String prezime;

	private String telefon;

	//bi-directional many-to-one association to Arezervacija
	@OneToMany(mappedBy="aputnik")
	private List<Arezervacija> arezervacijas;

	//uni-directional one-to-one association to AaerodromAccount
	@OneToOne
	@JoinColumn(name="AAerodrom_account_idAccount")
	private AaerodromAccount aaerodromAccount;

	public Aputnik() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public List<Arezervacija> getArezervacijas() {
		return this.arezervacijas;
	}

	public void setArezervacijas(List<Arezervacija> arezervacijas) {
		this.arezervacijas = arezervacijas;
	}

	public Arezervacija addArezervacija(Arezervacija arezervacija) {
		getArezervacijas().add(arezervacija);
		arezervacija.setAputnik(this);

		return arezervacija;
	}

	public Arezervacija removeArezervacija(Arezervacija arezervacija) {
		getArezervacijas().remove(arezervacija);
		arezervacija.setAputnik(null);

		return arezervacija;
	}

	public AaerodromAccount getAaerodromAccount() {
		return this.aaerodromAccount;
	}

	public void setAaerodromAccount(AaerodromAccount aaerodromAccount) {
		this.aaerodromAccount = aaerodromAccount;
	}

}