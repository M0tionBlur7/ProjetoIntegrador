/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOO;

import DAO.BDConexao;
import Objetos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ClienteDAO {
    
    public List<Cliente> read(){
    Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> cliente = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbl_drogarias");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Cliente cli = new Cliente();
                cli.setCodCli(rs.getInt("cod_drogaria"));
                cli.setNomeDrogaria(rs.getString("nome_dro"));
                cli.setCnpj(rs.getInt("cnpj"));
                cli.setRua(rs.getString("rua"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setNumero(rs.getInt("num"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setCep(rs.getInt("cep"));
                cli.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar" + e);
        } finally{
             BDConexao.closeConnection(con, stmt);
        }
        return cliente;
    }
    
    public void update(Cliente cli){
       Connection con = BDConexao.getConnection();
       PreparedStatement stmt = null;
       
        try {
            stmt = con.prepareStatement("UPDATE tbl_clientes SET nome_cliente = ?, cnpj = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, estado = ? WHERE COD_CLI = ?");
            stmt.setInt(1, cli.getCodCli());
            stmt.setString(2, cli.getNomeDrogaria());
            stmt .setInt(3, cli.getCnpj());
            stmt.setString(4, cli.getRua());
            stmt.setInt(5, cli.getNumero());
            stmt.setString(6, cli.getComplemento());
            stmt.setString(7, cli.getBairro());
            stmt.setString(8, cli.getCidade());
            stmt.setInt(9, cli.getCep());
            stmt.setString(10, cli.getEstado());
            
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso !");
                        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar" + e);
        } finally{
            BDConexao.closeConnection(con, stmt);     
        
        }        
   }
    
     public void delete(Cliente cli) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;
        
         try {
            stmt = con.prepareStatement("DELETE FROM tbl_clientes WHERE cod_drogaria = ?");
            stmt.setInt(1, cli.getCodCli());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao remover. " + e);
         } finally{
            BDConexao.closeConnection(con, stmt); 
         }
         }
     
     public void create(Cliente cli) {
        Connection con = BDConexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbl_drogarias (nome_dro, cnpj, rua, complemento, num, bairro, cidade, cep, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, cli.getNomeDrogaria());
            stmt.setInt(2, cli.getCnpj());
            stmt.setString(3, cli.getRua());
            stmt.setString(4, cli.getComplemento());
            stmt.setInt(5, cli.getNumero());
            stmt.setString(6, cli.getBairro());
            stmt.setString(7, cli.getCidade());
            stmt.setInt(8, cli.getCep());
            stmt.setString(9, cli.getEstado());
            

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar" + e);
        } finally {
            BDConexao.closeConnection(con, stmt);
        }
    }
     
     
}
