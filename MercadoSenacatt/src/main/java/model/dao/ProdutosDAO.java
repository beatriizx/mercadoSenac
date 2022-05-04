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
import model.Produto;

/**
 *
 * @author beatrizlira
 */
public class ProdutosDAO {
      public void create(Produto p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (nome_produto, marca, categoria, quantidade, valor,codigo_produto)VALUES(?,?,?, ?, ?, ?)");
            stmt.setString(1, p.getNomeProduto());
            stmt.setString(2, p.getMarca());
            stmt.setString(3, p.getCategoria());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDouble(5, p.getValor());
            stmt.setInt(6, p.getQuantidade());
           
            
            
      

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produto = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produtos = new Produto();

                produtos.setId(rs.getInt("id_produto"));
                produtos.setNomeProduto(rs.getString("nome_produto"));
                produtos.setMarca(rs.getString("marca"));
                produtos.setCategoria(rs.getString("categoria"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setValor(rs.getDouble("valor"));
                produtos.setCodigo(rs.getInt("codigo_produto"));
           
                produto.add(produtos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produto;

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

    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE produto SET nome_produto = ?,  marca = ?,categoria = ?,"
                    + " quantidade = ?, valor = ?, codigo_produto =? WHERE id_produto = ?");
           stmt.setString(1, p.getNomeProduto());
           stmt.setString(2, p.getMarca());
           stmt.setString(3, p.getCategoria());
           stmt.setInt(4, p.getQuantidade());
           stmt.setDouble(5, p.getValor());
           stmt.setInt(6, p.getCodigo());
          
           stmt.setInt(7, p.getId());
           

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
       } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
       } finally {
          ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void Excluir(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try {
            sql = con.prepareStatement("DELETE FROM produto WHERE id_produto=?");
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
