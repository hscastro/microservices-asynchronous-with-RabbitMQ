package com.example.demo.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entities.Venda;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "data", "produtos", "valorTotal"})
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {
	
	
	private static final long serialVersionUID = 4154800342623515396L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("data")
	private Date data;	
	
	@JsonProperty("produtos")
	private List<ProdutoVendaVO> produtos;
	
	@JsonProperty("valorTotal")
	private double valorTotal;
	
	public VendaVO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<ProdutoVendaVO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoVendaVO> produtos) {
		this.produtos = produtos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public static VendaVO create(Venda venda) {
		return new ModelMapper().map(venda, VendaVO.class);
	}
	

}
