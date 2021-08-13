/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAOO.LaboratorioDAO;
import Objetos.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PlayGO
 */
public class LabTableModel extends AbstractTableModel {
    
    private List<Laboratorio> dados = new ArrayList<>();
    private String[] colunas = {"Nome Fornecedor", "CNPJ", "Inscrição", "Tel", "Rua", "Número", "complemento", "Bairro", "Cidade", "CEP", "Estado"};

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
                return dados.get(linha).getNomeFornecedor();
            case 1:
                return dados.get(linha).getCnpj();
            case 2:
                return dados.get(linha).getInscEstadual();
            case 3:
                return dados.get(linha).getTelComercial();
            case 4:
                return dados.get(linha).getRua();
            case 5:
                return dados.get(linha).getNumero();
            case 6:
                return dados.get(linha).getComplemento();
            case 7:
                return dados.get(linha).getBairro();
            case 8:
                return dados.get(linha).getCidade();
            case 9:
                return dados.get(linha).getCep();
            case 10:
                return dados.get(linha).getEstado();
        }
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
         switch(coluna) {
            case 0:
                 dados.get(linha).setNomeFornecedor((String) valor);
                 break;
            case 1:
                 dados.get(linha).setCnpj((String) valor);
                 break;
            case 2:
                 dados.get(linha).setInscEstadual(Integer.parseInt((String) valor));
                 break;
            case 3:
                 dados.get(linha).setTelComercial(Integer.parseInt((String) valor));
                 break;
            case 4:
                 dados.get(linha).setRua((String) valor);
                 break;
            case 5:
                 dados.get(linha).setNumero(Integer.parseInt((String) valor));
                 break;
            case 6:
                 dados.get(linha).setComplemento((String) valor);
                 break;
            case 7:
                 dados.get(linha).setBairro((String) valor);
                 break;
            case 8:
                 dados.get(linha).setCidade((String) valor);
                 break;
            case 9:
                 dados.get(linha).setCep(Integer.parseInt((String) valor));
                 break;
            case 10:
                 dados.get(linha).setEstado((String) valor);
                 break;
        }
        
         this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Laboratorio lab) {
        this.dados.add(lab);
        this.fireTableDataChanged();
    }
    
    public void addRow(Laboratorio lab) {
        this.dados.add(lab);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Laboratorio pegaDadosLinha(int linha){
        return dados.get(linha);    
    }
    
    private void lerDados(){
        LaboratorioDAO labo = new LaboratorioDAO(); 
        
        for(Laboratorio lab : labo.read()){
            this.addLinha(lab);
        }
        
        this.fireTableDataChanged();
    
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    
}
