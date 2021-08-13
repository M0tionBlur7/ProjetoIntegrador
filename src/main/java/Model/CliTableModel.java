/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAOO.ClienteDAO;
import Objetos.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author William
 */
public class CliTableModel extends AbstractTableModel {
    
    private List<Cliente> dados = new ArrayList<>();
    private String[] colunas = {"Nome Drogaria", "CNPJ", "Rua", "Complemento", "Número", "Bairro", "Cidade", "CEP", "Estado"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0:
                return dados.get(linha).getNomeDrogaria();
            case 1:
                return dados.get(linha).getCnpj();
            case 2:
                return dados.get(linha).getRua();
            case 3:
                return dados.get(linha).getComplemento();
            case 4:
                return dados.get(linha).getNumero();
            case 5:
                return dados.get(linha).getBairro();
            case 6:
                return dados.get(linha).getCidade();
            case 7:
                return dados.get(linha).getCep();
            case 8:
                return dados.get(linha).getEstado();
            
        } 
        
        return null;
      


}

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna) {
            case 0:
                 dados.get(linha).setNomeDrogaria((String) valor);
                 break;
            case 1:
                 dados.get(linha).setCnpj(Integer.parseInt((String) valor));
                 break;
            case 2:
                 dados.get(linha).setRua((String) valor);
                 break;
            case 3:
                 dados.get(linha).setComplemento((String) valor);
                 break;
            case 4:
                 dados.get(linha).setNumero(Integer.parseInt((String) valor));
                 break;
            case 5:
                 dados.get(linha).setBairro((String) valor);
                 break;
            case 6:
                 dados.get(linha).setCidade((String) valor);
                 break;
            case 7:
                 dados.get(linha).setCep(Integer.parseInt((String) valor));
                 break;
            case 8:
                 dados.get(linha).setEstado((String) valor);
                 break;
            
    }
    
    this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Cliente cli) {
        this.dados.add(cli);
        this.fireTableDataChanged();
    }
    
    public void addRow(Cliente cli) {
        this.dados.add(cli);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Cliente pegaDadosLinha(int linha){
        return dados.get(linha);    
    }
    
    private void lerDados(){
        ClienteDAO clien = new ClienteDAO(); 
        
        for(Cliente cli : clien.read()){
            this.addLinha(cli);
        }
        
        this.fireTableDataChanged();
    
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
    
    
}
