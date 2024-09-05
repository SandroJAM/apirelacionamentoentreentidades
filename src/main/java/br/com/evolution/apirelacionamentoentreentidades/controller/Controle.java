package br.com.evolution.apirelacionamentoentreentidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.evolution.apirelacionamentoentreentidades.model.Marca;
import br.com.evolution.apirelacionamentoentreentidades.model.Produto;
import br.com.evolution.apirelacionamentoentreentidades.model.VinculacaoRequest;
import br.com.evolution.apirelacionamentoentreentidades.repository.MarcaRepositorio;
import br.com.evolution.apirelacionamentoentreentidades.repository.ProdutoRespositorio;

@RestController
public class Controle {

    // Repositórios

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @Autowired
    private ProdutoRespositorio produtoRespositorio;

    // Método para cadastrar uma Marca com desafio opcional extra

    @PostMapping("/cadastrarMarca")
    public Marca cadastrarMarca(@RequestBody Marca marca) {
        // Validação da marca (mínimo 3 caracteres)
        if (marca.getMarca().length() < 3) {
            throw new RuntimeException("A marca deve ter ao menos 3 caracteres.");
        }
        return marcaRepositorio.save(marca);
    }

    // Método para cadastrar um produto com desafio opcional extra

    @PostMapping("/cadastrarPorduto")
    public Produto cadastrarProduto(@RequestBody Produto produto) {

        // Validação da produto (mínimo 5 caracteres)
        if (produto.getNome().length() < 5) {
            throw new RuntimeException("A marca deve ter ao menos 5 caracteres.");
        }

        // Validação do preço (deve ser maior que zero)
        if (produto.getPreco() <= 0) {
            throw new RuntimeException("O preço deve ser maior que zero.");
        }

        return produtoRespositorio.save(produto);
    }

    // Método para víncular uma Marca a um determinado Produto

    /*
     * @PostMapping("/vincular/codigoMarca/codigoProduto")
     * public Marca vincularMarcaProduto(@PathVariable Long
     * codigo_marca, @PathVariable Long codigo_produto){
     * // Obter as informações do Produto
     * Produto p = produtoRespositorio.findByCodigo(codigo_produto);
     * 
     * // Obter informações da Marca
     * Marca m = marcaRepositorio.findByCodigo(codigo_marca);
     * 
     * // Adicionar objeto da Marca no atributo de produtos da Marca
     * m.getProdutos().add(p);
     * 
     * // Atualizar o objeto da Marca (Irá cadastrar uma nova Marca)
     * return marcaRepositorio.save(m);
     * 
     * }
     */

    // SUAS MODIFICAÇÕES

    @GetMapping("/listar")
    public List<Marca> listarProdutos() {
        return (List<Marca>) marcaRepositorio.findAll();
    }

    // Método para vincular uma Marca a um determinado Produto
    @PostMapping("/vincular")
    public void vincularMarcaProduto(@RequestBody VinculacaoRequest vinculacaoRequest) {
        Produto produto = produtoRespositorio.findByCodigo(vinculacaoRequest.getCodigoProduto());
        if (produto == null) {
            throw new RuntimeException("Produto não encontrado com o código: " + vinculacaoRequest.getCodigoProduto());
        }

        Marca marca = marcaRepositorio.findByCodigo(vinculacaoRequest.getCodigoMarca());
        if (marca == null) {
            throw new RuntimeException("Marca não encontrada com o código: " + vinculacaoRequest.getCodigoMarca());
        }

        // Adicionar a Marca à lista de marcas do Produto
        if (!produto.getMarcas().contains(marca)) {
            produto.getMarcas().add(marca);
        }

        // Adicionar o Produto à lista de produtos da Marca
        if (!marca.getProdutos().contains(produto)) {
            marca.getProdutos().add(produto);
        }

        // Salvar as mudanças
        produtoRespositorio.save(produto);
        marcaRepositorio.save(marca);
    }

}
