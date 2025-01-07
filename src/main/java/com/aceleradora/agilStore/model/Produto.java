package com.aceleradora.agilStore.model;

import com.aceleradora.agilStore.model.dto.ProdutoRequestDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "tabela_Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nomeProduto;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoriaProduto;

    @Column(name = "ESTOQUE",nullable = false)
    private int qtdProdutoEstoque;

    @Column(name = "PRECO", nullable = false)
    private double preco;

    public Produto() {
        //CONSTRUTOR VAZIO(default, necessário para o HIBERNATE criar instancias da entidade. Sem ele dará erro no metodo de obtençao de produtos no banco de dados
    }

    public Produto (ProdutoRequestDTO produtoRequestDTO){
        this.nomeProduto = produtoRequestDTO.nomeProduto().toLowerCase();
        this.categoriaProduto = produtoRequestDTO.categoriaProduto().toLowerCase();
        this.qtdProdutoEstoque = produtoRequestDTO.qtdProdutoEstoque();
        this.preco = produtoRequestDTO.preco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public int getQtdProdutoEstoque() {
        return qtdProdutoEstoque;
    }

    public void setQtdProdutoEstoque(int qtdProdutoEstoque) {
        this.qtdProdutoEstoque = qtdProdutoEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
