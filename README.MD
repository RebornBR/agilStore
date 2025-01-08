<div align = "center">
<h1> Documentação API AgilStore </h1>
<li>URL PREFIXO : <code>localhost:8080/agilStore/produto</code>
 <h3 align="center">Tecnologias utilizadas:</h3>

<div align="center"> 
<img src="https://img.shields.io/badge/Java-000000?style=for-the-badge&logo=openjdk&logoColor=white">
<img src="https://img.shields.io/badge/SpringBoot-000000?style=for-the-badge&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/H2 DataBase-000000?style=for-the-badge&logo=H2&logoColor=white">  
<br><br>
</div>

<h1>ProdutoRequestDTO</h1> 
Objeto solicitado para criaçao de um produto
</div>
<ul>
<li> <code>String nomeProduto:</code> Nome do produto
<li> <code>String categoriaProduto:</code> Categoria do produto
<li> <code>int qtdProdutoEstoque:</code> Quantidade do produto em estoque
<li> <code>double preco:</code> Preço do produto
<li> </ul>


<div align = "center">
<h3>Corpo:</h3>
</div>

```json
{
    "nomeProduto":  "Arroz", 
    "categoriaProduto": "alimento", 
    "qtdProdutoEstoque": 100, 
    "preco": 6.99
}
```

<br><br>

<div align = "center">
<h1> ProdutoResponseDTO </h1> 
Representa os dados retornados em todos os endpoints de GET
</div>
<ul>
<li> <code>long id:</code> Identificador do produto
<li> <code>String nomeProduto:</code> Nome do produto
<li> <code>String categoriaProduto:</code> Categoria do produto
<li> <code>int qtdProdutoEstoque</code> Quantidade do produto em estoque
<li> <code>double preco:</code> Preço do produto
</ul>

<div align = "center">
<h3>Corpo:</h3>
</div>

```json
{
    "id": 1,
    "nomeProduto":  "Arroz", 
    "categoriaProduto": "alimento", 
    "qtdProdutoEstoque": 100, 
    "preco": 6.99
}
```


<br><br>
<h1>EndPoints</h1>

<h2>Gerar Json</h2>
</div>
<ul>
<li> <b>Descrição: Método responsável por criar um arquivo(produtos.json) de todos os produtos que estão no banco de dados</b>
<li> URL: <code>agilStore/produto/gerarJson</code>
<li> Metódo: <code>GET</code> 
<li> Biblioteca utilizada: GSON
<li> Retorno: <code>void</code>
</ul>

<br><br>
<div align = "center">
<h2>Adicionar Produto</h2>
</div>
<ul>
<li> <b>Descrição: Método responsável por criar um produto e armazenar no banco de dados</b>
<li> URL: <code>agilStore/produto/adicionar</code>
<li> Metódo: <code>POST</code> 
<li> RequestBody: <code>ProdutoRequestDTO</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>

<br><br>
<div align="center">
<h2>Remover Produto</h2>
</div>
<ul>
<li> <b>Descrição: Método responsável por remover um produto do banco de dados</b>
<li> URL: <code>agilStore/produto/remover/</code>
<li> Metódo: <code>DELETE</code> 
<li> RequestParam: <code>long id</code>
</ul> 
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/remover/?id=1</code><br>
<h3>Retorno:<h3>
</div>
<code>Delete realizado com sucesso</code>


<br><br>
<div align ="center">
<h2>Atualizar Produto</h2>
</div>

<h3><li>Atualizar tudo</h3>
<ul>
<li> <b>Descrição: Método responsável por atualizar todas as informações de um produto</b>
<li> URL: <code>agilStore/produto/atualizar/tudo/</code>
<li> Metódo: <code>PUT</code> 
<li> RequestParam: <code>long id</code>, <code>String nomeProduto</code>, <code>String categoriaProduto</code>, <code>int qtdEstoque</code>, <code>double preco</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/atualizar/tudo/?id=1&nomeProduto=arroz&categoriaProduto=alimento&qtdEstoque=1000&preco=3.99</code><br>
<h3>Retorno:<h3>
</div>

```json
{
        "id": 1,
        "nomeProduto": "arroz",
        "categoriaProduto": "alimento",
        "qtdProdutoEstoque": 1000,
        "preco": 3.99
}
```


<br><br>
<h3><li>Atualizar nome do produto</h3>
<ul>
<li> <b>Descrição: Método responsável por atualizar o nome do produto</b>
<li> URL: <code>agilStore/produto/atualizar/nomeProduto/</code>
<li> Metódo: <code>PUT</code> 
<li> RequestParam: <code>long id</code>, <code>String novoNomeProduto</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/atualizar/nomeProduto/?id=1&novoNomeProduto=feijão</code><br>
<h3>Retorno:<h3>
</div>

```json
{
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "alimento",
        "qtdProdutoEstoque": 1000,
        "preco": 3.99
}
```


<br><br>
<h3><li>Atualizar categoria do produto</h3>
<ul>
<li> <b>Descrição: Método responsável por atualizar a categoria do produto</b>
<li> URL: <code>agilStore/produto/atualizar/categoriaProduto/</code>
<li> Metódo: <code>PUT</code> 
<li> RequestParam: <code>long id</code>, <code>String novaCategoriaProduto</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/atualizar/categoriaProduto/?id=1&novaCategoriaProduto=grão</code><br>
<h3>Retorno:<h3>
</div>

```json
{
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1000,
        "preco": 3.99
}
```

<br><br>
<h3><li>Atualizar quantidade do produto</h3>
<ul>
<li> <b>Descrição: Método responsável por atualizar a quantidade do produto</b>
<li> URL: <code>agilStore/produto/atualizar/qtdProduto/</code>
<li> Metódo: <code>PUT</code> 
<li> RequestParam: <code>long id</code>, <code>String novaQtdProduto</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/atualizar/qtdProduto/?id=1&novaQtdProduto=50</code><br>
<h3>Retorno:<h3>
</div>

```json
{
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 3.99
}
```

<br><br>
<h3><li>Atualizar preço do produto</h3>
<ul>
<li> <b>Descrição: Método responsável por atualizar o preço do produto</b>
<li> URL: <code>agilStore/produto/atualizar/preco/</code>
<li> Metódo: <code>PUT</code> 
<li> RequestParam: <code>long id</code>, <code>String novoPreco</code>
<li> Retorno: <code>ProdutoResponseDTO</code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/atualizar/preco/?id=1&novoPrecoProduto=5.99</code><br>
<h3>Retorno:<h3>
</div>

```json
{
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
}
```

<br><br>
<div align = "center">
<h2>Buscar Produto<h2>
</div>

<br><br>

<h3><li>Buscar produto pelo id</h3>
<ul>
<li> <b>Descrição: Método responsável por buscar um produto pelo seu id</b>
<li> URL: <code>agilStore/produto/procurarPorId/</code>
<li> Metódo: <code>GET</code> 
<li> RequestParam: <code>String categoriaProduto</code>
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/procurarPorId/?id=9</code><br>
<h3>Retorno:<h3>
</div>

```json
{
    "id": 9,
    "nomeProduto": "sabonete",
    "categoriaProduto": "higiene",
    "qtdProdutoEstoque": 1200,
    "preco": 2.99
}
```


<br><br>

<h3><li>Buscar produto pelo nome</h3>
<ul>
<li> <b>Descrição: Método responsável por buscar um produto por seu nome ou apenas parte dele</b>
<li> URL: <code>agilStore/produto/procurarPorContainNome/</code>
<li> Metódo: <code>GET</code> 
<li> RequestParam: <code>String nomeProduto</code>
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/procurarPorContainNome/?nomeProduto=not</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 5,
        "nomeProduto": "notebook gamer lenovo",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 15,
        "preco": 3600.0
    }
]
```
<br>
<div align = "center">
URL:<code>localhost:8080/agilStore/produto/procurarPorContainNome/?nomeProduto=f</code>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 8,
        "nomeProduto": "fio dental",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 200,
        "preco": 3.99
    }
]
```

<br><br>

<h3><li>Buscar produto pela categoria</h3>
<ul>
<li> <b>Descrição: Método responsável por buscar produtos por categoria</b>
<li> URL: <code>agilStore/produto/procurarPorCategoriaProduto/</code>
<li> Metódo: <code>GET</code> 
<li> RequestParam: <code>String categoriaProduto</code>
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/procurarPorCategoriaProduto/?categoriaProduto=grão</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 2,
        "nomeProduto": "arroz",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 500,
        "preco": 3.99
    },
    {
        "id": 3,
        "nomeProduto": "soja",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1500,
        "preco": 6.99
    }
]
```
<br><br>


<h3><li>Buscar todos os produtos ordenados pelo nome</h3>
<ul>
<li> <b>Descrição: Método responsável por obter todos os produtos ordenados pelo nome</b>
<li> URL: <code>agilStore/produto/obterTodos/order=nomeProduto</code>
<li> Metódo: <code>GET</code> 
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/obterTodos/order=nomeProduto</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 2,
        "nomeProduto": "arroz",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 500,
        "preco": 3.99
    },
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 8,
        "nomeProduto": "fio dental",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 200,
        "preco": 3.99
    },
    {
        "id": 6,
        "nomeProduto": "iphone 16 pro max",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 40,
        "preco": 13000.0
    },
    {
        "id": 5,
        "nomeProduto": "notebook gamer lenovo",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 15,
        "preco": 3600.0
    },
    {
        "id": 7,
        "nomeProduto": "pasta de dente",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 400,
        "preco": 1.99
    },
    {
        "id": 9,
        "nomeProduto": "sabonete",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 1200,
        "preco": 2.99
    },
    {
        "id": 4,
        "nomeProduto": "smartv 55 polegadas 4k",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 5,
        "preco": 2519.99
    },
    {
        "id": 3,
        "nomeProduto": "soja",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1500,
        "preco": 6.99
    }
]
```
<br><br>

<h3><li>Buscar todos os produtos ordenados pela categoria</h3>
<ul>
<li> <b>Descrição: Método responsável por obter todos os produtos ordenados pela categoria</b>
<li> URL: <code>agilStore/produto/obterTodos/order=categoriaProduto</code>
<li> Metódo: <code>GET</code> 
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/obterTodos/order=categoriaProduto</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 4,
        "nomeProduto": "smartv 55 polegadas 4k",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 5,
        "preco": 2519.99
    },
    {
        "id": 5,
        "nomeProduto": "notebook gamer lenovo",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 15,
        "preco": 3600.0
    },
    {
        "id": 6,
        "nomeProduto": "iphone 16 pro max",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 40,
        "preco": 13000.0
    },
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 2,
        "nomeProduto": "arroz",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 500,
        "preco": 3.99
    },
    {
        "id": 3,
        "nomeProduto": "soja",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1500,
        "preco": 6.99
    },
    {
        "id": 7,
        "nomeProduto": "pasta de dente",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 400,
        "preco": 1.99
    },
    {
        "id": 8,
        "nomeProduto": "fio dental",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 200,
        "preco": 3.99
    },
    {
        "id": 9,
        "nomeProduto": "sabonete",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 1200,
        "preco": 2.99
    }
]
```

<br><br>

<h3><li>Buscar todos os produtos ordenados pela quantidade</h3>
<ul>
<li> <b>Descrição: Método responsável por obter todos os produtos ordenados pela quantidade</b>
<li> URL: <code>agilStore/produto/obterTodos/order=qtdProduto</code>
<li> Metódo: <code>GET</code> 
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/obterTodos/order=qtdProduto</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 4,
        "nomeProduto": "smartv 55 polegadas 4k",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 5,
        "preco": 2519.99
    },
    {
        "id": 5,
        "nomeProduto": "notebook gamer lenovo",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 15,
        "preco": 3600.0
    },
    {
        "id": 6,
        "nomeProduto": "iphone 16 pro max",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 40,
        "preco": 13000.0
    },
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 8,
        "nomeProduto": "fio dental",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 200,
        "preco": 3.99
    },
    {
        "id": 7,
        "nomeProduto": "pasta de dente",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 400,
        "preco": 1.99
    },
    {
        "id": 2,
        "nomeProduto": "arroz",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 500,
        "preco": 3.99
    },
    {
        "id": 9,
        "nomeProduto": "sabonete",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 1200,
        "preco": 2.99
    },
    {
        "id": 3,
        "nomeProduto": "soja",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1500,
        "preco": 6.99
    }
]
```
<br><br>

<h3><li>Buscar todos os produtos ordenados pelo preço</h3>
<ul>
<li> <b>Descrição: Método responsável por obter todos os produtos ordenados pelo preço</b>
<li> URL: <code>agilStore/produto/obterTodos/order=preco</code>
<li> Metódo: <code>GET</code> 
<li> Retorno: <code> List&lt;ProdutoResponseDTO&gt; </code>
</ul>
<div align = "center">
<h3>Exemplo:</h3>

URL:<code>localhost:8080/agilStore/produto/obterTodos/order=preco</code><br>
<h3>Retorno:<h3>
</div>

```json
[
    {
        "id": 7,
        "nomeProduto": "pasta de dente",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 400,
        "preco": 1.99
    },
    {
        "id": 9,
        "nomeProduto": "sabonete",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 1200,
        "preco": 2.99
    },
    {
        "id": 2,
        "nomeProduto": "arroz",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 500,
        "preco": 3.99
    },
    {
        "id": 8,
        "nomeProduto": "fio dental",
        "categoriaProduto": "higiene",
        "qtdProdutoEstoque": 200,
        "preco": 3.99
    },
    {
        "id": 1,
        "nomeProduto": "feijão",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 50,
        "preco": 5.99
    },
    {
        "id": 3,
        "nomeProduto": "soja",
        "categoriaProduto": "grão",
        "qtdProdutoEstoque": 1500,
        "preco": 6.99
    },
    {
        "id": 4,
        "nomeProduto": "smartv 55 polegadas 4k",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 5,
        "preco": 2519.99
    },
    {
        "id": 5,
        "nomeProduto": "notebook gamer lenovo",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 15,
        "preco": 3600.0
    },
    {
        "id": 6,
        "nomeProduto": "iphone 16 pro max",
        "categoriaProduto": "eletronico",
        "qtdProdutoEstoque": 40,
        "preco": 13000.0
    }
]
```