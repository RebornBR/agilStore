package com.aceleradora.agilStore.model.dto;

public record ProdutoRequestDTO(String nomeProduto, String categoriaProduto, int qtdProdutoEstoque, double preco) {
    @Override
    public String nomeProduto() {
        return nomeProduto;
    }

    @Override
    public String categoriaProduto() {
        return categoriaProduto;
    }

    @Override
    public int qtdProdutoEstoque() {
        return qtdProdutoEstoque;
    }

    @Override
    public double preco() {
        return preco;
    }
}
