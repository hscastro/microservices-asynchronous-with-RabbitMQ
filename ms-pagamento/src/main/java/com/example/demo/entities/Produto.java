package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.example.demo.vo.ProdutoVO;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -2986783097989817182L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "estoque", nullable = true, length = 10)
	private Integer estoque;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Long id, Integer estoque) {
		super();
		this.id = id;
		this.estoque = estoque;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estoque == null) ? 0 : estoque.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (estoque == null) {
			if (other.estoque != null)
				return false;
		} else if (!estoque.equals(other.estoque))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static Produto create(ProdutoVO produtoVO) {
		return new ModelMapper().map(produtoVO, Produto.class);
	}
	
}
