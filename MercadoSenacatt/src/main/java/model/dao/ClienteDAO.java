/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author beatrizlira
 */
public class ClienteDAO {
     public void create(Cliente p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome_cliente, cpf, data_nascimento, estado_civil,sexo, cep, rua, numero_endereco, numero_telefone, email )VALUES(?,?,?, ?, ?, ?, ?, ?, ?, ? )");
            stmt.setString(1, p.getNomeCliente());
            stmt.setString(2, p.getCPF());
            stmt.setString(3, p.getDataNascimento());
            stmt.setString(4, p.getEstadoCivil());
            stmt.setString(5, p.getSexo());
            stmt.setString(6, p.getCEP());
            stmt.setString(7, p.getRua());
            stmt.setString(8, p.getNumero());
            stmt.setString(9, p.getCelular());
            stmt.setString(10, p.getEmail());
            
            
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Cliente> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setEstadoCivil(rs.getString("estado_civil"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCEP(rs.getString("cep"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getString("numero_endereco"));
                cliente.setCelular(rs.getString("numero_telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
        Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }

//    public List<Computador> readForDesc(String desc) {
//
//        Connection con = ConnectionFactory.getConnection();
//        
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        List<Produto> produtos = new ArrayList<>();
//
//        try {
//            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
//            stmt.setString(1, "%"+desc+"%");
//            
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                Produto produto = new Produto();
//
//                produto.setId(rs.getInt("id"));
//                produto.setDescricao(rs.getString("descricao"));
//                produto.setQtd(rs.getInt("qtd"));
//                produto.setPreco(rs.getDouble("preco"));
//                produtos.add(produto);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            ConnectionFactory.closeConnection(con, stmt, rs);
//        }
//
//        return produtos;
//
//    }

    public void update(Cliente p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Cliente SET nome_cliente = ?, cpf = ?,data_nascimento = ?,"
                    + " estado_civil = ?, sexo = ?, cep =?, rua = ?, numero_endereco =?, numero_telefone =?, email = ?  WHERE id_cliente = ?");
           stmt.setString(1, p.getNomeCliente());
           stmt.setString(2, p.getCPF());
           stmt.setString(3, p.getDataNascimento());
           stmt.setString(4, p.getEstadoCivil());
           stmt.setString(5, p.getSexo());
           stmt.setString(6, p.getCEP());
           stmt.setString(7, p.getRua());
           stmt.setString(8, p.getNumero());
           stmt.setString(9, p.getCelular());
           stmt.setString(10, p.getEmail());
           stmt.setInt(11, p.getId());
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
       } finally {
          ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void Excluir(Cliente p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try {
            sql = con.prepareStatement("DELETE FROM Cliente"
                    + " WHERE id_cliente=?");
             sql.setInt(1, p.getId());
        
             sql.executeUpdate();
        
             JOptionPane.showMessageDialog(null, "Excluido com sucesso");
             
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,sql);
        }
    }
}
        
    
        


//
//    
//
