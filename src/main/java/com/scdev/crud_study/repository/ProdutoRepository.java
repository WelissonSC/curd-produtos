/**
 * 
 */
package com.scdev.crud_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scdev.crud_study.model.Produto;

/**
 * 
 */
//estou dizendo pro spring que isso é um respoistorio onde as configurações basicas do crud estão
@Repository
//fornece os métodos crud básicos
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	//aqui a implementação vem automatica do spring boot
}
