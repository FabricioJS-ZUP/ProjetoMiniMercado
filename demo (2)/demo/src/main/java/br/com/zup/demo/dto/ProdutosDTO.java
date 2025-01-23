package br.com.zup.demo.dto;

public class ProdutosDTO {
    private String nomeProduto;
    private double precoProduto;
    private String categoriaProduto;
    private String descricaoProduto;
    private int quantidadeemestoqueProdutos;
    private long idProduto;

    public ProdutosDTO(String categoriaProduto, String descricaoProduto, String nomeProduto, double precoProduto, int quantidadeemestoqueProdutos, long idProduto) {
        this.categoriaProduto = categoriaProduto;
        this.descricaoProduto = descricaoProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeemestoqueProdutos = quantidadeemestoqueProdutos;
        this.idProduto = idProduto;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public int getQuantidadeemestoqueProdutos() {
        return quantidadeemestoqueProdutos;
    }

    public void setQuantidadeemestoqueProdutos(int quantidadeemestoqueProdutos) {
        this.quantidadeemestoqueProdutos = quantidadeemestoqueProdutos;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
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
