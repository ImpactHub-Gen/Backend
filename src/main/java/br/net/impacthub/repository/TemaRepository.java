package br.net.impacthub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.net.impacthub.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	public List<Tema> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	public List<Tema> findAllByNivelUrgenciaIgnoreCase(@Param("nivelUrgencia") String nivelUrgencia);

}
