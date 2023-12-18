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
}
