/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produtos;

/**
 *
 * @author erick
 */
public class ProdutosDAO {

    private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();

    }
    
   /**
 * Método inclui novos produtos ao banco.
 * @param obj - objeto do tipo Produto.
 */

    public void cadastrarProduto(Produtos obj) {
        try {
            String sql = "insert into tb_produtos(descricao,preco,qtd_estoque) values (?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            stmt.execute();
            JOptionPane.showMessageDialog(null , "produto cadastrado com sucesso");
            stmt.close();

            
        } catch(SQLIntegrityConstraintViolationException erro){
            JOptionPane.showMessageDialog(null , "Produto já cadastrado");
        }catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    /**
     * Método que altera(atualiza) produtos já cadastrados.
     * @param obj - objeto do tipo Produtos.
     */
    public void alterarProdutos(Produtos obj){
         //1 passo = criar o comando sql
        try {
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=? where id=?  ";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getDescricao());
             stmt.setDouble(2, obj.getPreco());
             stmt.setInt(3, obj.getQtd_estoque());
             stmt.setInt(4,obj.getId());
             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , " Produto Alterado com sucesso");
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null , "Erro" + erro);
        }
    }
    
    /**
    * Método que remove produtos do banco de dados.
    * @param obj - objeto do tipo Produtos.
    */
    public void excluirProduto(Produtos obj){
         //1 passo = criar o comando sql
        try {
            String sql = "delete from tb_produtos where id = ?";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Produto Excluido com sucesso");
        } catch (Exception erro) {
             JOptionPane.showMessageDialog(null , "Erro" + erro);
        }
    }
    
    /**
     * Método que trás todos os produtos cadastrados.
     * @return lista - lista de produtos.
     */
     public List<Produtos> listarProduto() {
        try {
            //1 passo - Criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_produtos";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble ("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
               
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro: " + erro);
        }
        return null;
    }
     
     /**
      * Método que busca produtos pelo nome usando o operador LIKE
      * @param nome String - nome dos produtos cadastrados.
      * @return lista - Produtos que tem nome parecido ou unico com suas informações .
      */
     public List<Produtos> listarProdutoPorNome(String nome) {
        try {
            //1 passo - Criar a lista
            List<Produtos> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_produtos where descricao like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString (1,nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble ("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
               
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro: " + erro);
        }
        return null;
    }
     
     /**
      * Método que busca produtos por nome.
      * @param nome String - nome dos produtos cadastrados.
      * @return obg - retorna o produto pelo nome e suas informações.
      */
     public Produtos consultaPorNome(String nome) {
        try {
            //1 passo - Criar a lista
            
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_produtos where descricao = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            if(rs.next()){
                
                
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble ("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
                              
            }
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return null;
        }
        
    }
     
     /**
      * Método que busca produtos por id.
      * @param id Int - identificador dos produtos cadastrados.
      * @return obj - retorna produtos buscando pelo seu número identificador.
      */
     public Produtos consultaPorCodigo(int id) {
        try {
            //1 passo - Criar a lista
            
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_produtos where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();
            
            Produtos obj = new Produtos();
            if(rs.next()){
                
                
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble ("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
                              
            }
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
            return null;
        }
        
    }
    /**
      * Método que retira produtos do estoque pós finalização de venda.
      * @param id Int - indentifica produtos do estoque.
      * @param qtd_nova Int - realiza atualização no estoque da quantidade de produtos.
      */
     
     public void baixaEstoque(int id, int qtd_nova){
         try{
         String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
         
         PreparedStatement stmt = con.prepareStatement(sql);
         
         stmt.setInt(1, qtd_nova);
         stmt.setInt(2, id);
         stmt.execute();
         stmt.close();
         
     }catch(Exception erro){
         JOptionPane.showMessageDialog(null,"Erro: " + erro);
     }
         
   }
     
     
     /**
      * Método que atualiza o estoque de produtos.
      * @param id Int - Identificador dos produtos.
      * @param qtd_nova Int -  Identificador de produtos que serão adicionados no estoque.
      */
          public void adicionarEstoque(int id, int qtd_nova){
         try{
         String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
         
         PreparedStatement stmt = con.prepareStatement(sql);
         
         stmt.setInt(1, qtd_nova);
         stmt.setInt(2, id);
         stmt.execute();
         stmt.close();
         
     }catch(Exception erro){
         JOptionPane.showMessageDialog(null,"Erro: " + erro);
     }
         
   }
     
    /**
      * Método que busca um produto pelo id e retorna a quantidade dele no estoque.
      * @param id Int - Identificador dos produtos no estoque.
      * @return qtd_estoque Int - retorna o estoque atual de um produto.
      */
     
     public int retornaEstoqueAtual(int id){
         try {
             int qtd_estoque = 0;
             
             String sql = "Select qtd_estoque from tb_produtos where id = ?";
             
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, id);
             
             ResultSet rs = stmt.executeQuery(); 
             
             if (rs.next()) {
                 Produtos p = new Produtos();
                 
                 qtd_estoque = (rs.getInt("qtd_estoque"));
             }
             return qtd_estoque;
             
         } catch (Exception e) {
             throw new RuntimeException(e);
         }
     }
     
     
}
