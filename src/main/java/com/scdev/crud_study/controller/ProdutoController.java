package com.scdev.crud_study.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scdev.crud_study.model.Produto;
import com.scdev.crud_study.repository.ProdutoRepository;
import com.scdev.crud_study.service.ProdutosService;

//refine que é um controador rest
@RestController
//end point base 
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

	// instanciando o objeto automaticamente
	// direto pelo constructor
	@Autowired
	private ProdutosService produtoService;

	//metodos http

	//lista todos os produtos
	@GetMapping()
	public List<Produto> listarTodos() {
		return produtoService.listarProdutos();
	}

	//lista todos os produtos passando o id
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.buscarPorId(id);
		return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	//salva um novo produto
	@PostMapping()
	public Produto salvar(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}
	
	//atualiza um produtos que já existe
	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable Long id) {
		if(!produtoService.buscarPorId(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produto.setId(id);
		return ResponseEntity.ok(produtoService.salvar(produto));
	}
	
	//deleta um produto pelo id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!produtoService.buscarPorId(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
