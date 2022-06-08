package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aavion database table.
 * 
 */
@Entity
@NamedQuery(name="Aavion.findAll", query="SELECT a FROM Aavion a")
public class Aavion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int brojSedista;

	private String model;

	//bi-directional many-to-one association to Alet
	@OneToMany(mappedBy="aavion")
	private List<Alet> alets;

	//bi-directional many-to-one association to Amesto
	@OneToMany(mappedBy="aavion")
	private List<Amesto> amestos;

	public Aavion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBrojSedista() {
		return this.brojSedista;
	}

	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<Alet> getAlets() {
		return this.alets;
	}

	public void setAlets(List<Alet> alets) {
		this.alets = alets;
	}

	public Alet addAlet(Alet alet) {
		getAlets().add(alet);
		alet.setAavion(this);

		return alet;
	}

	public Alet removeAlet(Alet alet) {
		getAlets().remove(alet);
		alet.setAavion(null);

		return alet;
	}

	public List<Amesto> getAmestos() {
		return this.amestos;
	}

	public void setAmestos(List<Amesto> amestos) {
		this.amestos = amestos;
	}

	public Amesto addAmesto(Amesto amesto) {
		getAmestos().add(amesto);
		amesto.setAavion(this);

		return amesto;
	}

	public Amesto removeAmesto(Amesto amesto) {
		getAmestos().remove(amesto);
		amesto.setAavion(null);

		return amesto;
	}

}