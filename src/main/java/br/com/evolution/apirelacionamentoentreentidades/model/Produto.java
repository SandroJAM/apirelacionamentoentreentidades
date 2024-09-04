package br.com.evolution.apirelacionamentoentreentidades.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String nome;

    private double preco;

    @ManyToMany
    @JoinTable(
        name = "marcas_produtos",
        joinColumns = {@JoinColumn(name = "codigo_marca", referencedColumnName = "codigo")},
        inverseJoinColumns = {@JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")}
    )
    private List<Marca> marcas = new ArrayList<>();
    
}
