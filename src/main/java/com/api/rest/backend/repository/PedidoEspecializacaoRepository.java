package com.api.rest.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.backend.enums.StatusEspecializacao;
import com.api.rest.backend.models.PedidoEspecializacao;

@Repository
public interface PedidoEspecializacaoRepository extends JpaRepository<PedidoEspecializacao, Long> {
    List<PedidoEspecializacao> findByServidorId(Long servidorId);

	List<PedidoEspecializacao> findByStatus(StatusEspecializacao deferido);
	

    
}
