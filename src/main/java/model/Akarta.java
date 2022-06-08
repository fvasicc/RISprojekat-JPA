package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the akarta database table.
 * 
 */
@Entity
@NamedQuery(name="Akarta.findAll", query="SELECT a FROM Akarta a")
public class Akarta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private double cenaKarta;

	//bi-directional many-to-one association to Alet
	@ManyToOne
	private Alet alet;

	//bi-directional many-to-one association to Amesto
	@ManyToOne
	private Amesto amesto;

	//bi-directional many-to-one association to Arezervacija
	@ManyToOne
	private Arezervacija arezervacija;

	public Akarta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCenaKarta() {
		return this.cenaKarta;
	}

	public void setCenaKarta(double cenaKarta) {
		this.cenaKarta = cenaKarta;
	}

	public Alet getAlet() {
		return this.alet;
	}

	public void setAlet(Alet alet) {
		this.alet = alet;
	}

	public Amesto getAmesto() {
		return this.amesto;
	}

	public void setAmesto(Amesto amesto) {
		this.amesto = amesto;
	}

	public Arezervacija getArezervacija() {
		return this.arezervacija;
	}

	public void setArezervacija(Arezervacija arezervacija) {
		this.arezervacija = arezervacija;
	}

}