package com.api.rest.backend.app;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.backend.conn.Conecta;
import com.api.rest.backend.repository.PedidoEspecializacaoRepository;
import com.api.rest.backend.repository.ServidorRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.api.rest.backend.repository") 
@EntityScan("com.api.rest.backend.models")
@ComponentScan("com.api.rest.backend.controllers")
@ComponentScan("com.api.rest.backend.service")
@ComponentScan("com.api.rest.backend.models.Servidor")

public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);

		try {
			Connection con = Conecta.criarConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
