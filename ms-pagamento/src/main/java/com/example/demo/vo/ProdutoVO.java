package com.example.demo.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.example.demo.entities.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "estoque"})
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {	
	
	private static final long serialVersionUID = 4154800342623515396L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("estoque")
	private Integer estoque;
	
	public ProdutoVO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}
	

}
