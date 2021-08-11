
package Objetos;

import java.util.Date;


public class Medicamento {

    /**
     * @return the qtdeAgain
     */
    public int getQtdeAgain() {
        return qtdeAgain;
    }

    /**
     * @param qtdeAgain the qtdeAgain to set
     */
    public void setQtdeAgain(int qtdeAgain) {
        this.qtdeAgain = qtdeAgain;
    }

    /**
     * @return the valorAgain
     */
    public double getValorAgain() {
        return valorAgain;
    }

    /**
     * @param valorAgain the valorAgain to set
     */
    public void setValorAgain(double valorAgain) {
        this.valorAgain = valorAgain;
    }

    private String nomeMed;
    private String descricao;
    private String nomeFor;
    private Date data;
    private int id;
    private double valor;
    private int qtde;
    
    private int qtdeAgain;
    
    private double valorAgain;
    
    public double getValor() {
        return valor;
    }
    
    public void setValor() {
        this.valor = valor;
    }
    
    public int getQtde() {
        return qtde;
    }
    
    public void setQtde() {
        this.qtde = qtde;
    }
    
    public String getNomeMed() {
        return nomeMed;
    }

    
    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public String getNomeFor() {
        return nomeFor;
    }

    
    public void setNomeFor(String nomeFor) {
        this.nomeFor = nomeFor;
    }

    
    public Date getData() {
        return data;
    }

   
    public void setData(Date data) {
        this.data = data;
    }

    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
 
    
}
