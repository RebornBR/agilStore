package com.aceleradora.agilStore.model.dto;

import com.aceleradora.agilStore.model.Produto;

public record ProdutoResponseDTO(Long id, String nomeProduto, String categoriaProduto, int qtdProdutoEstoque, double preco) {

    public ProdutoResponseDTO(Produto produto) {
       this(produto.getId(), produto.getNomeProduto(), produto.getCategoriaProduto(), produto.getQtdProdutoEstoque(), produto.getPreco());
    }
}
