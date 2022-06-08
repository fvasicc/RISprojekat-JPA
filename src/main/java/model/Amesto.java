package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the amesto database table.
 * 
 */
@Entity
@NamedQuery(name="Amesto.findAll", query="SELECT a FROM Amesto a")
public class Amesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int redniBroj;

	//bi-directional many-to-one association to Akarta
	@OneToMany(mappedBy="amesto")
	private List<Akarta> akartas;

	//bi-directional many-to-one association to Aavion
	@ManyToOne
	private Aavion aavion;

	//bi-directional many-to-one association to Aklasa
	@ManyToOne
	private Aklasa aklasa;

	public Amesto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRedniBroj() {
		return this.redniBroj;
	}

	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}

	public List<Akarta> getAkartas() {
		return this.akartas;
	}

	public void setAkartas(List<Akarta> akartas) {
		this.akartas = akartas;
	}

	public Akarta addAkarta(Akarta akarta) {
		getAkartas().add(akarta);
		akarta.setAmesto(this);

		return akarta;
	}

	public Akarta removeAkarta(Akarta akarta) {
		getAkartas().remove(akarta);
		akarta.setAmesto(null);

		return akarta;
	}

	public Aavion getAavion() {
		return this.aavion;
	}

	public void setAavion(Aavion aavion) {
		this.aavion = aavion;
	}

	public Aklasa getAklasa() {
		return this.aklasa;
	}

	public void setAklasa(Aklasa aklasa) {
		this.aklasa = aklasa;
	}

}