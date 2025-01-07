package com.aceleradora.agilStore.repository;

import com.aceleradora.agilStore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProdutos extends JpaRepository<Produto, Long> {

    Produto findById(long id);
    List<Produto> findByNomeProdutoContaining(String nomeProduto);
    List<Produto> findByCategoriaProduto(String categoriaProduto);
}
