package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alet database table.
 * 
 */
@Entity
@NamedQuery(name="Alet.findAll", query="SELECT a FROM Alet a")
public class Alet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cenaLet;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremePolaska;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremeSletanja;

	//bi-directional many-to-one association to Akarta
	@OneToMany(mappedBy="alet")
	private List<Akarta> akartas;

	//bi-directional many-to-one association to Aavion
	@ManyToOne
	private Aavion aavion;

	//bi-directional many-to-one association to Agrad
	@ManyToOne
	@JoinColumn(name="AGrad_id")
	private Agrad polazniGrad;

	//bi-directional many-to-one association to Agrad
	@ManyToOne
	@JoinColumn(name="AGrad_id1")
	private Agrad destinacija;

	//bi-directional many-to-one association to Astatusleta
	@ManyToOne
	private Astatusleta astatusleta;

	public Alet() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCenaLet() {
		return this.cenaLet;
	}

	public void setCenaLet(double cenaLet) {
		this.cenaLet = cenaLet;
	}

	public Date getVremePolaska() {
		return this.vremePolaska;
	}

	public void setVremePolaska(Date vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public Date getVremeSletanja() {
		return this.vremeSletanja;
	}

	public void setVremeSletanja(Date vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}

	public List<Akarta> getAkartas() {
		return this.akartas;
	}

	public void setAkartas(List<Akarta> akartas) {
		this.akartas = akartas;
	}

	public Akarta addAkarta(Akarta akarta) {
		getAkartas().add(akarta);
		akarta.setAlet(this);

		return akarta;
	}

	public Akarta removeAkarta(Akarta akarta) {
		getAkartas().remove(akarta);
		akarta.setAlet(null);

		return akarta;
	}

	public Aavion getAavion() {
		return this.aavion;
	}

	public void setAavion(Aavion aavion) {
		this.aavion = aavion;
	}

	public Agrad getPolazniGrad() {
		return this.polazniGrad;
	}

	public void setPolazniGrad(Agrad polazniGrad) {
		this.polazniGrad = polazniGrad;
	}

	public Agrad getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(Agrad destinacija) {
		this.destinacija = destinacija;
	}

	public Astatusleta getAstatusleta() {
		return this.astatusleta;
	}

	public void setAstatusleta(Astatusleta astatusleta) {
		this.astatusleta = astatusleta;
	}

}