package br.net.impacthub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.net.impacthub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

}