package com.sanmiguel.minimarket.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CabFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFact;
	private LocalDate fec_fact;
	@ManyToOne
	private Usuario idUsu;
	
    @OneToMany(mappedBy = "cabFactura", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
    private List<DetFactura> detFactura;
	
	public CabFactura() {
	}

	public CabFactura(LocalDate fec_fact, Usuario idUsu) {
		super();
		this.fec_fact = fec_fact;
		this.idUsu = idUsu;
	}

	public int getIdFact() {
		return idFact;
	}

	public void setIdFact(int idFact) {
		this.idFact = idFact;
	}

	public LocalDate getFec_fact() {
		return fec_fact;
	}

	public void setFec_fact(LocalDate fec_fact) {
		this.fec_fact = fec_fact;
	}

	public Usuario getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(Usuario idUsu) {
		this.idUsu = idUsu;
	}
}
