package br.com.evolution.apirelacionamentoentreentidades.model;

public class MarcaProdutoDTO {
    private Long codigoMarca;
    private String nomeMarca;
    private Long codigoProduto;
    private String nomeProduto;
    private double precoProduto;

    // Getters e Setters
    public Long getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoMarca(Long codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }
}
