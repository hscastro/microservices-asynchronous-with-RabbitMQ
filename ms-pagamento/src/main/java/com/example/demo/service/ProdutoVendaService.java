package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProdutoVenda;
import com.example.demo.repositories.ProdutoVendaRepository;
import com.example.demo.vo.ProdutoVendaVO;

@Service 
public class ProdutoVendaService {
		
    @Autowired
	private ProdutoVendaRepository produtoVendaRepository;
	
    //@Autowired
	//private ProdutoSendMessage produtoSendMessage;

	
	public ProdutoVendaVO create(ProdutoVendaVO produtoVendaVO) {
		ProdutoVendaVO produtoVendaVoRetorno = ProdutoVendaVO.create(
				produtoVendaRepository.save(ProdutoVenda.create(produtoVendaVO)));
		//produtoSendMessage.sendMessage(produtoVendaVoRetorno);
		return produtoVendaVoRetorno;
	}
		
}
