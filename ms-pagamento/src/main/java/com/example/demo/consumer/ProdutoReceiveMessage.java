package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Produto;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.vo.ProdutoVO;

@Component
public class ProdutoReceiveMessage {

	@Autowired
	private ProdutoRepository produtoRepository;

	@RabbitListener(queues = {"${crud.rabbitmq.queue}"})
	public void receive(@Payload ProdutoVO produtoVO) {
		produtoRepository.save(Produto.create(produtoVO));
	}
	
}
