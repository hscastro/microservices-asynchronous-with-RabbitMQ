package com.example.demo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.VendaService;
import com.example.demo.vo.VendaVO;


//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private PagedResourcesAssembler<VendaVO> assembler;
	
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yml"})
	public ResponseEntity<VendaVO> findById(@PathVariable("id") Long id){
		VendaVO vendaVO = vendaService.findById(id);

		return ResponseEntity.ok(vendaVO);
	}

	
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yml"})
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction){
		
		var sortDirection = "desc".equalsIgnoreCase(direction)? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "data"));
		
		Page<VendaVO> produtos = vendaService.findAll(pageable);

		return ResponseEntity.ok(produtos);
	}

	@PostMapping(produces = {"application/json", "application/xml", "application/x-yml"},
			consumes = {"application/json", "application/xml", "application/x-yml"})
	public ResponseEntity<VendaVO> createVenda(VendaVO vendaVO){
		VendaVO vendaVORetorno = vendaService.create(vendaVO);
		return ResponseEntity.ok(vendaVORetorno);
	}
}
