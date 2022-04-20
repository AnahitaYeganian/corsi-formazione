package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String matricola;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private String nome;

	private LocalDate dataNascita;

	private String luogoNascita;

	@Column(nullable = false)
	private String email;

	/* Allievo parte proprietaria */
	/* Essendo l'applicazione per un ente che eroga corsi di formazione, la lettura di uno o più allievi
	 * è correlata alla lettura dei corsi a cui essi sono iscritti per cui è conveniente accedervi contemporaneamente */
	@ManyToMany(mappedBy = "allievi", fetch = FetchType.EAGER)
	private List<Corso> corsi;
	
	@ManyToOne
	private Societa societa;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricola() {
		return this.matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Allievo allievo = (Allievo)obj;
		return this.getId().equals(allievo.getId());
	}
}