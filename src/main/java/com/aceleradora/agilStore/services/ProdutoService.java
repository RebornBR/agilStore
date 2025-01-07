package com.aceleradora.agilStore.services;

import com.aceleradora.agilStore.model.Produto;
import com.aceleradora.agilStore.model.dto.ProdutoRequestDTO;
import com.aceleradora.agilStore.model.dto.ProdutoResponseDTO;
import com.aceleradora.agilStore.repository.RepositoryProdutos;
import com.aceleradora.agilStore.services.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class ProdutoService {

    private final RepositoryProdutos repositoryProdutos;
    private final GeradorJson geradorJson;

    public ProdutoService(RepositoryProdutos repositoryProdutos, GeradorJson geradorJson) {
        this.repositoryProdutos = repositoryProdutos;
        this.geradorJson = geradorJson;
    }

    private void verificarCampo(String valorParaVerificar) {
        if (valorParaVerificar.isBlank() || valorParaVerificar.isEmpty()) {
            throw new BusinessException("Um ou mais campos obrigatórios estão vazios(empty) ou em branco(blank)");
        }
    }

    public void gerarJson() throws IOException {
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .sorted(Comparator.comparing(ProdutoResponseDTO::categoriaProduto))
                .toList();
        geradorJson.gerarJson(listaProdutos);
    }

    public ProdutoResponseDTO adicionarProduto(ProdutoRequestDTO produtoRequestDTO) throws IOException {
        Produto produto = new Produto(produtoRequestDTO);

        verificarCampo(produto.getNomeProduto());
        verificarCampo(produto.getCategoriaProduto());

        repositoryProdutos.save(produto);
        return new ProdutoResponseDTO(produto);
    }

    public String removerProduto(long id){
        Produto produto = repositoryProdutos.findById(id);
        if(produto == null){
            throw new BusinessException("Produto de ID '"+id+"' não foi encontrado. Operação de delete não foi realizada");
        }else{
            repositoryProdutos.delete(produto);
            return "Delete realizado com sucesso";
        }
    }

    public ProdutoResponseDTO atualizarTudoProduto(long id, String nomeProduto, String categoriaProduto, int qtdEstoque, double preco){
        verificarCampo(nomeProduto);
        verificarCampo(categoriaProduto);
        try{
            Produto produto = repositoryProdutos.findById(id);

            produto.setNomeProduto(nomeProduto.toLowerCase());
            produto.setCategoriaProduto(categoriaProduto.toLowerCase());
            produto.setQtdProdutoEstoque(qtdEstoque);
            produto.setPreco(preco);

            repositoryProdutos.save(produto);
            return new ProdutoResponseDTO(produto);
        }catch (NullPointerException e){
            throw new BusinessException("Produto de ID '"+id+"' não foi encontrado. Não foi possivel atualizar suas informações");
        }
    }

    public ProdutoResponseDTO atualizarInformacaoProduto( String oqueDesejaAtualizar,long id, String novoValor){
        verificarCampo(novoValor);
        try {
            Produto produto = repositoryProdutos.findById(id);
            switch (oqueDesejaAtualizar){
                case "nomeProduto":
                    String novoNome = novoValor.toLowerCase();
                    produto.setNomeProduto(novoNome);
                    break;
                case "categoriaProduto":
                    String novaCategoria = novoValor.toLowerCase();
                    produto.setCategoriaProduto(novaCategoria);
                    break;
                case "qtdProduto":
                    int novaQtdProduto = Integer.parseInt(novoValor);
                    produto.setQtdProdutoEstoque(novaQtdProduto);
                    break;
                case "preco":
                    double novoPreco = Double.parseDouble(novoValor);
                    produto.setPreco(novoPreco);
                    break;
                default: throw new BusinessException("Operação Inválida");
            }

            repositoryProdutos.save(produto);
            return new ProdutoResponseDTO(produto);

        } catch (NullPointerException nullPointerException) {
            throw new BusinessException("Produto de ID '"+id+"' não foi encontrado. Não foi possivel atualizar sua informação");
        } catch (NumberFormatException numberFormatExceptionD){
            throw new BusinessException("O valor não é um numero válido para essa operação.");
        }
    }

    public List<ProdutoResponseDTO> obterTodosProdutosOrderNomeProduto(){
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .sorted(Comparator.comparing(ProdutoResponseDTO::nomeProduto))
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto");
        }
        return listaProdutos;
    }

    public List<ProdutoResponseDTO> obterTodosProdutosOrderCategoriaProduto(){
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findAll()
                .stream()
                .map(ProdutoResponseDTO::new) // mapeia Produto e o transforma em um ProdutoResponseDTO
                .sorted(Comparator.comparing(ProdutoResponseDTO::categoriaProduto))// faz a ordenação por categoriaProduto
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto");
        }
        return listaProdutos;
    }

    public List<ProdutoResponseDTO> obterTodosProdutosOrderQtdProduto(){
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .sorted(Comparator.comparing(ProdutoResponseDTO::qtdProdutoEstoque))
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto");
        }
        return listaProdutos;
    }

    public List<ProdutoResponseDTO> obterTodosProdutosOrderPreco(){
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findAll()
                .stream()
                .map(ProdutoResponseDTO::new)
                .sorted(Comparator.comparing(ProdutoResponseDTO::preco))
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto");
        }
        return listaProdutos;
    }

    public List<ProdutoResponseDTO> procurarPorContainNome(String nomeProduto){
        verificarCampo(nomeProduto);
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos
                .findByNomeProdutoContaining(nomeProduto.toLowerCase())
                .stream()
                .map(ProdutoResponseDTO::new)
                .sorted(Comparator.comparing(ProdutoResponseDTO::nomeProduto))
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto chamado '"+ nomeProduto + "'");
        }
        return listaProdutos;
    }

    public List<ProdutoResponseDTO> procurarPorCategoriaProduto(String categoriaProduto){
        verificarCampo(categoriaProduto);
        List<ProdutoResponseDTO> listaProdutos = this.repositoryProdutos.findByCategoriaProduto(categoriaProduto.toLowerCase())
                .stream()
                .map(ProdutoResponseDTO::new)
                .toList();
        if(listaProdutos.isEmpty()){
            throw new BusinessException("Não foi encontrado nenhum produto na categoria '"+categoriaProduto+"'");
        }
        return listaProdutos;
    }

    public ProdutoResponseDTO procurarProdutoPorId(long id) {
        try {
            return new ProdutoResponseDTO(this.repositoryProdutos.findById(id));
        } catch (NullPointerException e) {
            throw new BusinessException("Produto com ID: '" + id + "' não foi encontrado");
        }
    }
}
