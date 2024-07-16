package com.api.rest.backend.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.rest.backend.dto.ServidorDTO;
import com.api.rest.backend.service.ServidorService;

@RestController
@RequestMapping("/servidor")
public class ServidorController {
	
	@Autowired
	private ServidorService servidorService;

	public ServidorController(ServidorService servidorService) {
		this.servidorService = servidorService;
	}

	@GetMapping
	public ResponseEntity<List<ServidorDTO>> getAllServidores() {
		List<ServidorDTO> servidoresDTO = servidorService.getAllServidores().stream().map(ServidorDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(servidoresDTO);
	}

	@PostMapping
	public ResponseEntity<ServidorDTO> createServidor(@RequestBody ServidorDTO servidorDTO) {
		ServidorDTO createdServidorDTO = servidorService.createServidor(servidorDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdServidorDTO);
	}

}
