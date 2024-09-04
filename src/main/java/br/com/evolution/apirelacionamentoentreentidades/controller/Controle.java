package br.com.evolution.apirelacionamentoentreentidades.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.evolution.apirelacionamentoentreentidades.model.Marca;
import br.com.evolution.apirelacionamentoentreentidades.model.Produto;
import br.com.evolution.apirelacionamentoentreentidades.repository.MarcaRepositorio;
import br.com.evolution.apirelacionamentoentreentidades.repository.ProdutoRespositorio;

@RestController
public class Controle {

    // Repositórios

    private MarcaRepositorio marcaRepositorio;
    private ProdutoRespositorio produtoRespositorio;

    // Método para cadastrar uma Marca

    @PostMapping("/cadastrarMarca")
    public Marca cadastrarMarca(@RequestBody Marca marca){
        return marcaRepositorio.save(marca);
    }

    // Método para cadastrar um produto

    @PostMapping("/cadastrarPorduto")
    public Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoRespositorio.save(produto);
    }

    // Método para víncular uma Marca a um determinado Produto

    @PostMapping("/vincular/codigoMarca/codigoProduto")
    public Marca cadastrarMarcaProduto(@PathVariable Long codigo_marca, @PathVariable Long codigo_produto){
        // Obter as informações do Produto
        Produto p = produtoRespositorio.findByCodigo(codigo_produto);

        // Obter informações da Marca
        Marca m = marcaRepositorio.findByCodigo(codigo_marca);

        // Adicionar objeto da Marca no atributo de produtos da Marca
        m.getMarca().add(p);

        // Atualizar o objeto da Marca (Irá cadastrar uma nova Marca)
        marcaRepositorio.save(m);

    }

}
