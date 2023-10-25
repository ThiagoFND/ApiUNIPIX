package br.com.api.authlogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chaves")
public class ChavePix {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "pjpf", nullable = false)
	private String pjpf;
	@Column(name = "chavee", nullable = false)
	private String chavee;
	@Column(name = "tipo", nullable = false)
	private String tipo;

	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;

	public ChavePix() {
	}

	public ChavePix(String id, String pjpf, String chavee, String tipo, User user) {
		super();
		this.id = id;
		this.pjpf = pjpf;
		this.chavee = chavee;
		this.tipo = tipo;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPjpf() {
		return pjpf;
	}

	public void setPjpf(String pjpf) {
		this.pjpf = pjpf;
	}

	public String getChavee() {
		return chavee;
	}

	public void setChavee(String chavee) {
		this.chavee = chavee;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chavee == null) ? 0 : chavee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pjpf == null) ? 0 : pjpf.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChavePix other = (ChavePix) obj;
		if (chavee == null) {
			if (other.chavee != null)
				return false;
		} else if (!chavee.equals(other.chavee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pjpf == null) {
			if (other.pjpf != null)
				return false;
		} else if (!pjpf.equals(other.pjpf))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
