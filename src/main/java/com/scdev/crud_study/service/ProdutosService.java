package com.scdev.crud_study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scdev.crud_study.model.Produto;
import com.scdev.crud_study.repository.ProdutoRepository;

//aqui estou dizendo que são os serviços onde toda regra de negocio vai vir aqui
@Service
public class ProdutosService {
	//injeta automaticamente as dependencias de uma classe 
	//usada no construtor ele atomaticamentre instancia o objeto 
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarProdutos() {
		//persebe-se que o construtor já tem os metodos  básicos como buscar, listar, salvar deletar
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}
}
