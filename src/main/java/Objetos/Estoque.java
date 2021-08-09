
package Objetos;

import java.util.Date;


public class Estoque {

   
    public Date getDataUltCompra() {
        return dataUltCompra;
    }

   
    public void setDataUltCompra(Date dataUltCompra) {
        this.dataUltCompra = dataUltCompra;
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

    
    public int getQtde() {
        return qtde;
    }

    
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

   
    public double getValorCusto() {
        return valorCusto;
    }

    
    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    
    public double getValorVenda() {
        return valorVenda;
    }

    
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public void avisoQTDE() {
        
    }
    
    public void inserirQTDE() {
        
    }
    
    public void alterarQTDE() {
        
    }
    
    public void excluirQTDE() {
        
    }
    
    private int codMed;
    private String descricao;
    private Date dataUltCompra;
    private int qtde;
    private double valorCusto;
    private double valorVenda;
    
    
    
}
