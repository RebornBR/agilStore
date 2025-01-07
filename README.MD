<div align = "center">
<h1> Documentação API AgilStore </h1>

<h1><li>ProdutoRequestDTO</h1> 

Objeto solicitado para criaçao de um produto

<ul>
<li> <code>String nomeProduto:</code> Nome do produto
<li> <code>String categoriaProduto:</code> Categoria do produto
<li> <code>int qtdProdutoEstoque:</code> Quantidade do produto em estoque
<li> <code>double preco:</code> Preço do produto
</ul>

<h3>Exemplo:</h3>
</div>

```json
{
    "nomeProduto":  "Arroz", 
    "categoriaProduto": "alimento", 
    "qtdProdutoEstoque": 100, 
    "preco": 6.99
}
```


<br>
<div align = "center">
<h1><li> ProdutoResponseDTO </h1> 

Representa os dados retornados em todos os endpoints de GET

<ul>
<li> <code>long id:</code> Identificador do produto
<li> <code>String nomeProduto:</code> Nome do produto
<li> <code>String categoriaProduto:</code> Categoria do produto
<li> <code>int qtdProdutoEstoque</code> Quantidade do produto em estoque
<li> <code>double preco:</code> Preço do produto
</ul>

<h3>Exemplo:</h3>
</div>

```json
{
    "id": 12,
    "nomeProduto":  "Arroz", 
    "categoriaProduto": "alimento", 
    "qtdProdutoEstoque": 100, 
    "preco": 6.99
}
```