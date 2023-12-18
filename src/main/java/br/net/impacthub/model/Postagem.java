package br.net.impacthub.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Por favor, insira um título para a postagem!")
	@Size(min = 5, max = 50, message = "O título deve ter no mínimo 5 e no máximo 50 caracteres.")
	@Column(length = 50)
	private String titulo;
	
	@NotBlank(message = "Por favor, insira um texto para a postagem!")
	@Size(min = 5, max = 2000, message = "O texto deve ter no mínimo 5 e no máximo 2000 caracteres.")
	@Column(length = 2000)
	private String texto;
	
	@Nullable
	private String localizacao;
	
	@Nullable
	private String imagem;
	
	@UpdateTimestamp
	private LocalDateTime data;
}
