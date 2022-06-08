package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agrad database table.
 * 
 */
@Entity
@NamedQuery(name="Agrad.findAll", query="SELECT a FROM Agrad a")
public class Agrad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String grad;

	//bi-directional many-to-one association to Alet
	@OneToMany(mappedBy="polazniGrad")
	private List<Alet> poletanja;

	//bi-directional many-to-one association to Alet
	@OneToMany(mappedBy="destinacija")
	private List<Alet> sletanja;

	public Agrad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public List<Alet> getPoletanja() {
		return this.poletanja;
	}

	public void setPoletanja(List<Alet> poletanja) {
		this.poletanja = poletanja;
	}

	public Alet addPoletanja(Alet poletanja) {
		getPoletanja().add(poletanja);
		poletanja.setPolazniGrad(this);

		return poletanja;
	}

	public Alet removePoletanja(Alet poletanja) {
		getPoletanja().remove(poletanja);
		poletanja.setPolazniGrad(null);

		return poletanja;
	}

	public List<Alet> getSletanja() {
		return this.sletanja;
	}

	public void setSletanja(List<Alet> sletanja) {
		this.sletanja = sletanja;
	}

	public Alet addSletanja(Alet sletanja) {
		getSletanja().add(sletanja);
		sletanja.setDestinacija(this);

		return sletanja;
	}

	public Alet removeSletanja(Alet sletanja) {
		getSletanja().remove(sletanja);
		sletanja.setDestinacija(null);

		return sletanja;
	}

}