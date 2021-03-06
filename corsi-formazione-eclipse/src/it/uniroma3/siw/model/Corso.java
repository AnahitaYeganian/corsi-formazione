package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private LocalDate dataInizio;
	
	private Integer durataInMesi;
	
	/* Corso parte proprietaria */
	/*Cascade: quando viene inserito nel db un corso vorrei che fosse inserito nel db anche il docente che lo tiene */
	@ManyToOne(cascade= {CascadeType.PERSIST})
	private Docente docente;
	
	/* Corso parte inversa */
	@ManyToMany
	private List<Allievo> allievi;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getDurataInMesi() {
		return this.durataInMesi;
	}

	public void setDurataInMesi(Integer durataInMesi) {
		this.durataInMesi = durataInMesi;
	}
	
	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Corso corso = (Corso)obj;
		return this.getId().equals(corso.getId());
	}
	
}
