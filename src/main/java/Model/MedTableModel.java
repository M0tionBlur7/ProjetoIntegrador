
package Model;

import DAOO.MedicamentosDAO;
import Objetos.Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class MedTableModel extends AbstractTableModel {
    
    private List<Medicamento> dados = new ArrayList<>();
    private String[] colunas = {"Nome", "Descrição", "Nome Fornecedor", "Valor", "Quantidade"};

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
                return dados.get(linha).getNomeMed();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getNomeFor();
            case 3:
                return dados.get(linha).getValorAgain();
            case 4:
                return dados.get(linha).getQtdeAgain();
        }
        
        return null;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        
         switch(coluna) {
            case 0:
                 dados.get(linha).setNomeMed((String) valor);
                 break;
            case 1:
                 dados.get(linha).setDescricao((String) valor);
                 break;
            case 2:
                 dados.get(linha).setNomeFor((String) valor);
                 break;
            case 3:
                 dados.get(linha).setValorAgain(Double.parseDouble((String) valor));
                 break;
            case 4:
                 dados.get(linha).setQtdeAgain(Integer.parseInt((String) valor));
                 break;
        }
        
         this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Medicamento m) {
        this.dados.add(m);
        this.fireTableDataChanged();
    }
    
    public void addRow(Medicamento m) {
        this.dados.add(m);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha) {
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Medicamento pegaDadosLinha(int linha){
        return dados.get(linha);    
    }
    
    private void lerDados(){
        MedicamentosDAO mdao = new MedicamentosDAO(); 
        
        for(Medicamento m : mdao.read()){
            this.addLinha(m);
        }
        
        this.fireTableDataChanged();
    
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
    

}
