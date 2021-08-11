/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOO;

import DAO.BDConexao;
import Objetos.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PlayGO
 */
public class MedicamentosDAO {
    
    public List<Medicamento> read() {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> medicamento = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_medicamentos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Medicamento med = new Medicamento();
                med.setNomeMed(rs.getString("cod_med"));
                med.setDescricao(rs.getString("descricao"));
                med.setNomeFor(rs.getString("nome_fornecedor"));
                med.setValorAgain(rs.getDouble("valor"));
                med.setQtdeAgain(rs.getInt("qtde_med"));
                medicamento.add(med);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            BDConexao.closeConnection(con, stmt, rs);
        }
        return medicamento;
    }

    public void create(Medicamento med) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_medicamentos (nome_med, descricao, nome_fornecedor, valor, qtde_med) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, med.getNomeMed());
            stmt.setString(2, med.getDescricao());
            stmt.setString(3, med.getNomeFor());
            stmt.setDouble(4, med.getValorAgain());
            stmt.setInt(5, med.getQtdeAgain());
            

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar" + e);
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }

      public void update(Medicamento med) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_medicamentos SET nome_med = ?, descricao = ?, nome_fornecedor = ?, valor = ?, qtde_med = ? WHERE COD_MED = ?");
            stmt.setString(1, med.getNomeMed());
            stmt.setString(2, med.getDescricao());
            stmt.setString(3, med.getNomeFor());
            stmt.setDouble(4, med.getValorAgain());
            stmt.setInt(5, med.getQtdeAgain());

            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar" + e);
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }
    
      public void delete(Medicamento m) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_medicamentos WHERE cod_med = ?");
            stmt.setInt(1, m.getId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                   
                  
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Falha ao remover. " + e);
        
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }
    
}
