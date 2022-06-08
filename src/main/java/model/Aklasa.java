package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aklasa database table.
 * 
 */
@Entity
@NamedQuery(name="Aklasa.findAll", query="SELECT a FROM Aklasa a")
public class Aklasa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cenaKlasa;

	private int dozvoljenaTezinaPrtljaga;

	private int dozvoljenoKofera;

	private String naziv;

	//bi-directional many-to-one association to Amesto
	@OneToMany(mappedBy="aklasa")
	private List<Amesto> amestos;

	public Aklasa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCenaKlasa() {
		return this.cenaKlasa;
	}

	public void setCenaKlasa(double cenaKlasa) {
		this.cenaKlasa = cenaKlasa;
	}

	public int getDozvoljenaTezinaPrtljaga() {
		return this.dozvoljenaTezinaPrtljaga;
	}

	public void setDozvoljenaTezinaPrtljaga(int dozvoljenaTezinaPrtljaga) {
		this.dozvoljenaTezinaPrtljaga = dozvoljenaTezinaPrtljaga;
	}

	public int getDozvoljenoKofera() {
		return this.dozvoljenoKofera;
	}

	public void setDozvoljenoKofera(int dozvoljenoKofera) {
		this.dozvoljenoKofera = dozvoljenoKofera;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Amesto> getAmestos() {
		return this.amestos;
	}

	public void setAmestos(List<Amesto> amestos) {
		this.amestos = amestos;
	}

	public Amesto addAmesto(Amesto amesto) {
		getAmestos().add(amesto);
		amesto.setAklasa(this);

		return amesto;
	}

	public Amesto removeAmesto(Amesto amesto) {
		getAmestos().remove(amesto);
		amesto.setAklasa(null);

		return amesto;
	}

}