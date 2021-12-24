package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produto;
import com.example.demo.producer.ProdutoSendMessage;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.vo.ProdutoVO;


@Service 
public class ProdutoService {
		
    @Autowired
	private ProdutoRepository produtoRepository;
	
    @Autowired
	private ProdutoSendMessage produtoSendMessage;

	
	public ProdutoVO create(ProdutoVO produtoVO) {
		ProdutoVO produtoVoRetorno = ProdutoVO.create(
				produtoRepository.save(Produto.create(produtoVO)));
		produtoSendMessage.sendMessage(produtoVoRetorno);
		return produtoVoRetorno;
	}
	
	public ProdutoVO findById(Long id) {
		ProdutoVO entityVO = ProdutoVO.create(produtoRepository.findById(id).get());	
		return entityVO;
	}
	
	public Page<ProdutoVO> findAll(Pageable pageable) {
		var page = produtoRepository.findAll(pageable);		
		return page.map(this::converteTOVendaVO);
	}
	
	public ProdutoVO converteTOVendaVO(Produto produto) {
		return ProdutoVO.create(produto);
	}	
		
}
