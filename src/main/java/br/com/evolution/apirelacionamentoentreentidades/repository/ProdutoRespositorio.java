package br.com.evolution.apirelacionamentoentreentidades.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evolution.apirelacionamentoentreentidades.model.Produto;

@Repository
public interface ProdutoRespositorio extends CrudRepository<Produto, Long> {

    public Produto findByCodigo(long codigo);
    
}
