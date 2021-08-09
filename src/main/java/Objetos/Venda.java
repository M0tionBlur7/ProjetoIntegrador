
package Objetos;


public class Venda {

   
    public int getCodVenda() {
        return codVenda;
    }

   
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

   
    public int getCodMed() {
        return codMed;
    }

   
    public void setCodMed(int codMed) {
        this.codMed = codMed;
    }

   
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public String getNomeCliente() {
        return nomeCliente;
    }

   
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

   
    public int getQtdeVenda() {
        return qtdeVenda;
    }

   
    public void setQtdeVenda(int qtdeVenda) {
        this.qtdeVenda = qtdeVenda;
    }

   
    public double getValorTotal() {
        return valorTotal;
    }

   
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    private int codVenda;
    private int codMed;
    private String descricao;
    private String nomeCliente;
    private int qtdeVenda;
    private double valorTotal;
    
    
}
