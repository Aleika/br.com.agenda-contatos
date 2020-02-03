package br.com.agenda.contatos.contato;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato implements Serializable {	
	
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="nome",length=50,nullable=false)
	private String nome;
	
	@Column(name="numero",length=20,nullable=false)
	private String numero;
	
	private String email;
	
	public Contato() {
		
	}

	public Contato(String nome, String numero, String email) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

