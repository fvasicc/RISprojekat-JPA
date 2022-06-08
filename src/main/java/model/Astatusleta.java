package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the astatusleta database table.
 * 
 */
@Entity
@NamedQuery(name="Astatusleta.findAll", query="SELECT a FROM Astatusleta a")
public class Astatusleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String status;

	//bi-directional many-to-one association to Alet
	@OneToMany(mappedBy="astatusleta")
	private List<Alet> alets;

	public Astatusleta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Alet> getAlets() {
		return this.alets;
	}

	public void setAlets(List<Alet> alets) {
		this.alets = alets;
	}

	public Alet addAlet(Alet alet) {
		getAlets().add(alet);
		alet.setAstatusleta(this);

		return alet;
	}

	public Alet removeAlet(Alet alet) {
		getAlets().remove(alet);
		alet.setAstatusleta(null);

		return alet;
	}

}