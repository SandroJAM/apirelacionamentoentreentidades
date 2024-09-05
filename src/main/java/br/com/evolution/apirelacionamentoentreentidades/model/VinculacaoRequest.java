package br.com.evolution.apirelacionamentoentreentidades.model;

public class VinculacaoRequest {
    private Long codigoMarca;
    private Long codigoProduto;

    // Getters e Setters
    public Long getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Long codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
}
