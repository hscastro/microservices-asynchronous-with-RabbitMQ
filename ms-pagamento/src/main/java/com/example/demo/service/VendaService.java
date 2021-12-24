package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProdutoVenda;
import com.example.demo.entities.Venda;
import com.example.demo.repositories.ProdutoVendaRepository;
import com.example.demo.repositories.VendaRepository;
import com.example.demo.vo.VendaVO;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	private ProdutoVendaRepository produtoVendaRepository; 
	
	
	public VendaVO create(VendaVO vendaVO) {
		Venda venda = vendaRepository.save(Venda.create(vendaVO));	
		
		List<ProdutoVenda> produtosSalvos = new ArrayList<>(); 
		vendaVO.getProdutos().forEach(p ->{
			ProdutoVenda pv = ProdutoVenda.create(p);
			pv.setVenda(venda);
			produtosSalvos.add(produtoVendaRepository.save(pv));
		});
		
		venda.setProdutos(produtosSalvos);
		
		return VendaVO.create(venda);
	}
	
	public Page<VendaVO> findAll(Pageable pageable) {
		var page = vendaRepository.findAll(pageable);		
		return page.map(this::converteTOVendaVO);
	}	
	
	public VendaVO converteTOVendaVO(Venda venda) {
		return VendaVO.create(venda);
	}	
	
	public VendaVO findById(Long id) {
		VendaVO entityVO = VendaVO.create(vendaRepository.findById(id).get());	
		return entityVO;
	}
}
