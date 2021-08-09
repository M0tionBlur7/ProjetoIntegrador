/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;


public class Compra {

   
    public Date getDataCompra() {
        return dataCompra;
    }

   
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

  
    public Date getDataEntrega() {
        return dataEntrega;
    }

   
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

   
    public int getNumNotaFiscal() {
        return numNotaFiscal;
    }

    
    public void setNumNotaFiscal(int numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    
    public String getFormaPagamento() {
        return formaPagamento;
    }

    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    private Date dataCompra;
    private Date dataEntrega;
    private int numNotaFiscal;
    private String formaPagamento;
    
}
