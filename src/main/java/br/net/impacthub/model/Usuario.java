package br.net.impacthub.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor, insira um nome para o usuário!")
	@Size(min = 2, max = 55, message = "O nome deve ter no mínimo 2 e no máximo 55 caracteres.")
	@Column(length = 55)
	private String nome;
	
	@NotBlank(message = "Por favor, insira uma senha para o usuário!")
	@Size(min = 12, max = 100, message = "A senha deve ter no mínimo 12 e no máximo 100 caracteres.")
	@Column(length = 100)
	private String senha;
	
	@NotBlank(message = "Por favor, insira um email para o usuário!")
	@Size(min = 5, max = 100, message = "O email deve ter no mínimo 5 e no máximo 100 caracteres.")
	@Column(length = 100)
	private String email;
	
	@NotBlank(message = "Por favor, insira o tipo de usuário")
	private String tipo;
	
	@NotBlank(message = "Por favor, insira um telefone para o usuário!")
	@Size(min = 10, max = 11, message = "O telefone deve ter no mínimo 12 e no máximo 13 caracteres.")
	@Column(length = 11)
	private String telefone;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	
}
