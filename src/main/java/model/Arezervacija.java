package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the arezervacija database table.
 * 
 */
@Entity
@NamedQuery(name="Arezervacija.findAll", query="SELECT a FROM Arezervacija a")
public class Arezervacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datumRezervacije;

	//bi-directional many-to-one association to Akarta
	@OneToMany(mappedBy="arezervacija")
	private List<Akarta> akartas = new ArrayList<Akarta>();

	//bi-directional many-to-one association to Aputnik
	@ManyToOne
	@JoinColumn(name="AKorisnik_id")
	private Aputnik aputnik;

	public Arezervacija() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatumRezervacije() {
		return this.datumRezervacije;
	}

	public void setDatumRezervacije(Date datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}

	public List<Akarta> getAkartas() {
		return this.akartas;
	}

	public void setAkartas(List<Akarta> akartas) {
		this.akartas = akartas;
	}

	public Akarta addAkarta(Akarta akarta) {
		getAkartas().add(akarta);
		akarta.setArezervacija(this);

		return akarta;
	}

	public Akarta removeAkarta(Akarta akarta) {
		getAkartas().remove(akarta);
		akarta.setArezervacija(null);

		return akarta;
	}

	public Aputnik getAputnik() {
		return this.aputnik;
	}

	public void setAputnik(Aputnik aputnik) {
		this.aputnik = aputnik;
	}

}