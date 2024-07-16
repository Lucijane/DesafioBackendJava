package com.api.rest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.backend.models.Servidor;

@Repository
public interface ServidorRepository  extends JpaRepository<Servidor, Long>{
	
	 
}
