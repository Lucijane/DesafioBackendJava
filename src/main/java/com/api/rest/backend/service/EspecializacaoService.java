package com.api.rest.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.backend.enums.StatusEspecializacao;
import com.api.rest.backend.models.EmailRequest;
import com.api.rest.backend.models.PedidoEspecializacao;
import com.api.rest.backend.repository.PedidoEspecializacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class EspecializacaoService {
	@Autowired
	private PedidoEspecializacaoRepository pedidoEspecializacaoRepository;

	@Autowired
	private EmailService emailService;

	public List<PedidoEspecializacao> getAllEspecializacoes() {
		return pedidoEspecializacaoRepository.findAll();
	}

	public Optional<PedidoEspecializacao> getEspecializacaoById(Long id) {
		return pedidoEspecializacaoRepository.findById(id);
	}

	public PedidoEspecializacao createEspecializacao(PedidoEspecializacao especializacao) {
		especializacao.setStatus(StatusEspecializacao.PENDENTE);
		return pedidoEspecializacaoRepository.save(especializacao);
	}

	@Transactional
	public boolean deferirPedidoEspecializacao(Long pedidoId) {
		PedidoEspecializacao pedido = pedidoEspecializacaoRepository.findById(pedidoId).orElse(null);
		if (pedido != null) {
			pedido.setStatus(StatusEspecializacao.DEFERIDO);
			pedidoEspecializacaoRepository.save(pedido);
			return true;
		}
		return false;
	}

	public List<PedidoEspecializacao> getAllPedidosDeferidos() {
		return pedidoEspecializacaoRepository.findByStatus(StatusEspecializacao.DEFERIDO);
	}

	@Transactional
	public boolean indeferirPedidoEspecializacao(Long pedidoId, String motivo) {
		PedidoEspecializacao pedido = pedidoEspecializacaoRepository.findById(pedidoId).orElse(null);
		if (pedido != null) {
			pedido.setStatus(StatusEspecializacao.INDEFERIDO);
			pedido.setMotivoIndeferimento(motivo);
			pedidoEspecializacaoRepository.save(pedido);
			return true;
		}
		return false;
	}

	public List<PedidoEspecializacao> listarPedidosIndeferidos() {
		return pedidoEspecializacaoRepository.findByStatus(StatusEspecializacao.INDEFERIDO);
	}

	///////////////////////////////////// EMAIL///////////////////////////////////////

	@Transactional
	public void enviarEmailParaTodosDeferidos() {
		List<PedidoEspecializacao> pedidosDeferidos = getAllPedidosDeferidos();
		for (PedidoEspecializacao pedido : pedidosDeferidos) {
			enviarEmailNotificacao(pedido, "Seu pedido foi deferido.");
		}
	}

	@Transactional
	public void enviarEmailParaTodosIndeferidos() {
		List<PedidoEspecializacao> pedidosIndeferidos = listarPedidosIndeferidos();
		for (PedidoEspecializacao pedido : pedidosIndeferidos) {
			enviarEmailNotificacao(pedido, "Seu pedido foi indeferido.");
		}
	}

	private void enviarEmailNotificacao(PedidoEspecializacao pedido, String mensagem) {
		String destinatario = pedido.getServidor().getEmail();
		String assunto = "Notificação de Pedido de Especialização";
		EmailRequest emailRequest = new EmailRequest(destinatario, assunto, mensagem);
		emailService.sendSimpleMessage(emailRequest);
	}

}
