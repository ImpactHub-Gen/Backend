package br.net.impacthub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_temas")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor, insira um nome para o tema!")
	@Size(min = 5, max = 50, message = "O nome deve ter no mínimo 5 e no máximo 50 caracteres.")
	@Column(length = 50)
	private String nome;
	
	@NotBlank(message = "Por favor, preencha uma descrição para o tema!")
	@Size(min = 10, max = 1000, message = "A descrição deve ter no mínimo 10 e no máximo 1000 caracteres.")
	@Column(length = 1000)
	private String descricao;
	
	@NotBlank(message = "Por favor, o nível de urgência deve ser baixo, médio ou alto!")
	@Size(min = 0, max = 5, message = "O nível de urgência deve ter no máximo 5 caracteres.")
	@Column(length = 5)
	private String nivelUrgencia;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(String nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}
	
}
