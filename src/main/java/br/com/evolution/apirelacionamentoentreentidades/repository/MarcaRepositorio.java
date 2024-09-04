package br.com.evolution.apirelacionamentoentreentidades.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.evolution.apirelacionamentoentreentidades.model.Marca;

@Repository
public interface MarcaRepositorio extends CrudRepository<Marca, Long> {
    
}
