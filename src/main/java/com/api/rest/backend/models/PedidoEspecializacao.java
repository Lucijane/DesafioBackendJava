package com.api.rest.backend.models;

import java.math.BigDecimal;

import com.api.rest.backend.dto.PedidoEspecializacaoDTO;
import com.api.rest.backend.enums.StatusEspecializacao;
import com.api.rest.backend.enums.TipoEspecializacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PedidoEspecializacao")
public class PedidoEspecializacao {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "servidor_id")
	private Servidor servidor;

	@Column(nullable = false)
	private String area;

	@Enumerated(EnumType.STRING)
	private TipoEspecializacao tipo; // Pós-Graduação, Doutorado, Mestrado

	@Column(nullable = false)
	private Integer cargaHoraria;

	@Column(nullable = false)
	private BigDecimal valorTotal;

	@Enumerated(EnumType.STRING)
	private StatusEspecializacao status; // deferido, indeferido, pendente

	@Column(name = "razao_indeferencia")
	@JsonInclude(Include.NON_NULL) // Inclui o campo apenas se não for null
	private String motivoIndeferimento;

	public PedidoEspecializacao() {
	}

	public PedidoEspecializacao(Long id, Servidor servidor, String area, TipoEspecializacao tipo, Integer cargaHoraria,
			StatusEspecializacao status, BigDecimal valorTotal) {
		this.id = id;
		this.servidor = servidor;
		this.area = area;
		this.tipo = tipo;
		this.cargaHoraria = cargaHoraria;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public PedidoEspecializacao(PedidoEspecializacao pedidoEspecializacao) {
		this.id = pedidoEspecializacao.getId();
		this.servidor = pedidoEspecializacao.getServidor();
		this.area = pedidoEspecializacao.getArea();
		this.tipo = pedidoEspecializacao.getTipo();
		this.cargaHoraria = pedidoEspecializacao.cargaHoraria;
		this.valorTotal = pedidoEspecializacao.valorTotal;
		this.status = pedidoEspecializacao.status;

	}

	public PedidoEspecializacao(PedidoEspecializacaoDTO pedidoEspecializacaoDTO) {
		this.id = pedidoEspecializacaoDTO.getId();
		this.area = pedidoEspecializacaoDTO.getArea();
		this.tipo = pedidoEspecializacaoDTO.getTipo();
		this.cargaHoraria = pedidoEspecializacaoDTO.getCargaHoraria();
		this.valorTotal = pedidoEspecializacaoDTO.getValorTotalEspecializacao();
	}

	public PedidoEspecializacaoDTO toPedidoEspecializacaoDTO() {
		return new PedidoEspecializacaoDTO(this.id, this.area, this.tipo, this.cargaHoraria, this.valorTotal);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public TipoEspecializacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspecializacao tipo) {
		this.tipo = tipo;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusEspecializacao getStatus() {
		return status;
	}

	public void setStatus(StatusEspecializacao status) {
		this.status = status;
	}

	public String getMotivoIndeferimento() {
		return motivoIndeferimento;
	}

	public void setMotivoIndeferimento(String motivoIndeferimento) {
		this.motivoIndeferimento = motivoIndeferimento;
	}

}
