package com.api.rest.backend.dto;

import java.math.BigDecimal;

import com.api.rest.backend.enums.TipoEspecializacao;

public class PedidoEspecializacaoDTO {
	
	private Long id;
	private String area;
	private TipoEspecializacao tipo;
	private Integer cargaHoraria;
	private BigDecimal valorTotalEspecializacao;
	
	public PedidoEspecializacaoDTO() {
		
	}

	public PedidoEspecializacaoDTO(Long id, String area, TipoEspecializacao tipo, Integer cargaHoraria, BigDecimal valorTotalEspecializacao) {
		this.id = id;
		this.area = area;
		this.tipo = tipo;
		this.cargaHoraria = cargaHoraria;
		this.valorTotalEspecializacao = valorTotalEspecializacao;
		
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getValorTotalEspecializacao() {
		return valorTotalEspecializacao;
	}

	public void setValorTotalEspecializacao(BigDecimal valorTotalEspecializacao) {
		this.valorTotalEspecializacao = valorTotalEspecializacao;
	}
	
	
}
