/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOO;

import DAO.BDConexao;
import Objetos.Laboratorio;
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
public class LaboratorioDAO {
    
        public List<Laboratorio> read() {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Laboratorio> laboratorio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_laboratorios");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Laboratorio lab = new Laboratorio();
                lab.setCodLab(rs.getInt("cod_lab"));
                lab.setNomeFornecedor(rs.getString("nome_fornecedor"));
                lab.setCnpj(rs.getString("cnpj"));
                lab.setInscEstadual(rs.getInt("insc_estadual"));
                lab.setTelComercial(rs.getInt("tel_comercial"));
                lab.setCidade(rs.getString("cidade"));
                lab.setBairro(rs.getString("bairro"));
                lab.setCep(rs.getInt("cep"));
                lab.setComplemento(rs.getString("complemento"));
                lab.setEstado(rs.getString("estado"));
                lab.setNumero(rs.getInt("num"));
                lab.setRua(rs.getString("rua"));
                
                laboratorio.add(lab);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao obter dados: " + e);
        } finally {
            BDConexao.closeConnection(con, stmt, rs);
        }
        return laboratorio;
    }

    public void create(Laboratorio lab) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_laboratorios (nome_fornecedor, cnpj, insc_estadual, tel_comercial, rua, num, complemento, bairro, cidade, cep, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, lab.getNomeFornecedor());
            stmt.setString(2, lab.getCnpj());
            stmt.setInt(3, lab.getInscEstadual());
            stmt.setInt(4, lab.getTelComercial());
            stmt.setString(5, lab.getRua());
            stmt.setInt(6, lab.getNumero());
            stmt.setString(7, lab.getComplemento());
            stmt.setString(8, lab.getBairro());
            stmt.setString(9, lab.getCidade());
            stmt.setInt(10, lab.getCep());
            stmt.setString(11, lab.getEstado());
            
            
            

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar" + e);
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }

      public void update(Laboratorio lab) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbl_laboratorios SET nome_fornecedor = ?, cnpj = ?, insc_estadual = ?, tel_comercial = ?, rua = ?, num = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, estado = ? WHERE cod_lab = ?");
            
            stmt.setString(1, lab.getNomeFornecedor());
            stmt.setString(2, lab.getCnpj());
            stmt.setInt(3, lab.getInscEstadual());
            stmt.setInt(4, lab.getTelComercial());
            stmt.setString(5, lab.getRua());
            stmt.setInt(6, lab.getNumero());
            stmt.setString(7, lab.getComplemento());
            stmt.setString(8, lab.getBairro());
            stmt.setString(9, lab.getCidade());
            stmt.setInt(10, lab.getCep());
            stmt.setString(11, lab.getEstado());
            stmt.setInt(12, lab.getCodLab());
            

            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar" + e);
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }
    
      public void delete(Laboratorio lab) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM tbl_laboratorios WHERE cod_lab = ?");
            stmt.setInt(1, lab.getCodLab());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
                   
                  
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Falha ao remover. " + e);
        
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }
    
}
