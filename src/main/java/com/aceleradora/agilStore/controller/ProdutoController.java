package com.aceleradora.agilStore.controller;

import com.aceleradora.agilStore.model.dto.ProdutoRequestDTO;
import com.aceleradora.agilStore.model.dto.ProdutoResponseDTO;
import com.aceleradora.agilStore.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("agilStore/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("gerarJson")
    public void gerarJson() throws IOException {
        produtoService.gerarJson();
    }

    @PostMapping("adicionar")
    public ProdutoResponseDTO adicionarProduto (@RequestBody ProdutoRequestDTO produtoRequestDTO) throws IOException {
        return produtoService.adicionarProduto(produtoRequestDTO);
    }

    @DeleteMapping("remover/")
    public String removerProduto(@RequestParam long id){
        return produtoService.removerProduto(id);
    }

    @PutMapping("atualizar/tudo/")
    public ProdutoResponseDTO atualizarTudoProduto(@RequestParam long id, @RequestParam String nomeProduto, @RequestParam String categoriaProduto, @RequestParam int qtdEstoque, @RequestParam double preco){
        return produtoService.atualizarTudoProduto(id, nomeProduto, categoriaProduto, qtdEstoque, preco);
    }

    @PutMapping("atualizar/nomeProduto/")
    public ProdutoResponseDTO atualizarNomeProduto(@RequestParam long id, @RequestParam String novoNomeProduto){
        return produtoService.atualizarInformacaoProduto("nomeProduto", id, novoNomeProduto);
    }

    @PutMapping("atualizar/categoriaProduto/")
    public ProdutoResponseDTO atualizarCategoriaProduto(@RequestParam long id, @RequestParam String novaCategoriaProduto){
        return produtoService.atualizarInformacaoProduto("categoriaProduto", id, novaCategoriaProduto);
    }

    @PutMapping("atualizar/qtdProduto/")
    public ProdutoResponseDTO atualizarQtdProduto(@RequestParam long id, @RequestParam String novaQtdProduto){
        return produtoService.atualizarInformacaoProduto("qtdProduto", id, novaQtdProduto);
    }
    @PutMapping("atualizar/preco/")
    public ProdutoResponseDTO atualizarPrecoProduto(@RequestParam long id, @RequestParam String novoPrecoProduto){
        return produtoService.atualizarInformacaoProduto("preco", id, novoPrecoProduto);
    }

    @GetMapping("obterTodos/order=nomeProduto")
    public List<ProdutoResponseDTO> obterTodosProdutosOrderNomeProduto(){
        return produtoService.obterTodosProdutosOrderNomeProduto();
    }

    @GetMapping("obterTodos/order=categoriaProduto")
    public List<ProdutoResponseDTO> obterTodosProdutosOrderCategoriaProduto(){
        return produtoService.obterTodosProdutosOrderCategoriaProduto();
    }

    @GetMapping("obterTodos/order=qtdProduto")
    public List<ProdutoResponseDTO> obterTodosProdutosOrderQtdProduto(){
        return produtoService.obterTodosProdutosOrderQtdProduto();
    }

    @GetMapping("obterTodos/order=preco")
    public List<ProdutoResponseDTO> obterTodosProdutosOrderPreco(){
        return produtoService.obterTodosProdutosOrderPreco();
    }

    @GetMapping("procurarPorContainNome/")
    public List<ProdutoResponseDTO> procurarPorContainNome(@RequestParam String nomeProduto){
        return produtoService.procurarPorContainNome(nomeProduto);
    }

    @GetMapping("procurarPorCategoriaProduto/")
    public List<ProdutoResponseDTO> procurarPorCategoriaProduto(@RequestParam String categoriaProduto){
        return produtoService.procurarPorCategoriaProduto(categoriaProduto);
    }

    @GetMapping("procurarPorId/")
    public ProdutoResponseDTO procurarProdutoPorId(@RequestParam long id){
        return produtoService.procurarProdutoPorId(id);
    }
}
