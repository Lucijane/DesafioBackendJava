package com.api.rest.backend.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.rest.backend.dto.MotivoIndeferimentoDTO;
import com.api.rest.backend.models.PedidoEspecializacao;
import com.api.rest.backend.service.EspecializacaoService;

@RestController
@RequestMapping("/pedido-especializacao")
public class PedidoEspecializacaoController {

	@Autowired
	private EspecializacaoService especializacaoService;

	@GetMapping
	public List<PedidoEspecializacao> getAllEspecializacoes() {
		return especializacaoService.getAllEspecializacoes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoEspecializacao> getEspecializacaoById(@PathVariable Long id) {
		Optional<PedidoEspecializacao> especializacao = especializacaoService.getEspecializacaoById(id);
		return especializacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<PedidoEspecializacao> createEspecializacao(@RequestBody PedidoEspecializacao especializacao) {
		PedidoEspecializacao createdEspecializacao = especializacaoService.createEspecializacao(especializacao);
		return ResponseEntity.ok(createdEspecializacao);
	}
	
	@PostMapping("{pedidoId}/deferir")
    public ResponseEntity<?> deferirPedidoEspecializacao(@PathVariable Long pedidoId) {
        boolean deferido = especializacaoService.deferirPedidoEspecializacao(pedidoId);
        if (deferido) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de especialização não encontrado");
        }
    }
    
    @GetMapping("/deferidos")
    public ResponseEntity<List<PedidoEspecializacao>> getAllPedidosDeferidos() {
        List<PedidoEspecializacao> pedidosDeferidos = especializacaoService.getAllPedidosDeferidos();
        return ResponseEntity.ok(pedidosDeferidos);
    }	
   
    @PostMapping("/{pedidoId}/indeferir")
   public ResponseEntity<?> indeferirPedidoEspecializacao(
            @PathVariable Long pedidoId,
            @RequestBody MotivoIndeferimentoDTO motivoDTO) {

        boolean indeferido = especializacaoService.indeferirPedidoEspecializacao(pedidoId, motivoDTO.getMotivo());
        if (indeferido) {
            PedidoEspecializacao pedido = especializacaoService.getEspecializacaoById(pedidoId).orElse(null);
            if (pedido != null) {
                return ResponseEntity.ok()
                        .body("Pedido de especialização com ID " + pedidoId + " foi indeferido. Motivo: " + motivoDTO.getMotivo());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de especialização não encontrado");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido de especialização não encontrado");
        }
    }
    
 // Endpoint para listar pedidos de especialização indeferidos
    @GetMapping("/indeferidos")
    public ResponseEntity<List<PedidoEspecializacao>> listarPedidosIndeferidos() {
        List<PedidoEspecializacao> indeferidos = especializacaoService.listarPedidosIndeferidos();
        if (!indeferidos.isEmpty()) {
            return ResponseEntity.ok().body(indeferidos);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    ///////////////////////////////EMAIL////////////////////////////////////////
    @GetMapping("/deferidos/enviar-email")
    public ResponseEntity<String> enviarEmailParaTodosDeferidos() {
        especializacaoService.enviarEmailParaTodosDeferidos();
        return ResponseEntity.ok("E-mails enviados para todos os pedidos deferidos.");
    }

    @GetMapping("/indeferidos/enviar-email")
    public ResponseEntity<String> enviarEmailParaTodosIndeferidos() {
        especializacaoService.enviarEmailParaTodosIndeferidos();
        return ResponseEntity.ok("E-mails enviados para todos os pedidos indeferidos.");
    }

}
