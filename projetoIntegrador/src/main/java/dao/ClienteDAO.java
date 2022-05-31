/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Clientes;

/**
 *
 * @author beatrizlira
 */
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * Método que inclui novos clientes no banco de dados.
     * @param obj - obj do tipo Cliente.
     */
    public void cadastrarCliente(Clientes obj){
        //1 passo = criar o comando sql
        try {
            String sql = "insert into tb_clientes(nome, cpf, sexo, data_nascimento, estado_civil, email ,telefone, cep, endereco, numero, complemento, bairro, cidade, estado)"
                                                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getNome());
             stmt.setString(2, obj.getCPF());
             stmt.setString(3, obj.getSexo());
             stmt.setString(4, obj.getDataNascimento());
             stmt.setString(5, obj.getEstadoCivil());
             stmt.setString(6, obj.getEmail());
             stmt.setString(7, obj.getCelular());
             stmt.setString(8, obj.getCEP());
             stmt.setString(9, obj.getEndereco());
             stmt.setInt(10, obj.getNumero());
             stmt.setString(11, obj.getComplemento());
             stmt.setString(12, obj.getBairro());
             stmt.setString(13, obj.getCidade());
             stmt.setString(14, obj.getEstado());
             
             //Antes do seu save


             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Cadastrado com sucesso");
        }catch(SQLIntegrityConstraintViolationException erro){
            JOptionPane.showMessageDialog(null , "CPF já cadastrado");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null , "Erro" + e);
        } 
    }
    
     /** 
     * Método que altera(atualiza) as informações de clientes cadastrados.
     * @param obj - objeto do tipo Cliente.
     */
    public void alterarCliente(Clientes obj){
         //1 passo = criar o comando sql
        try {
            String sql = "update tb_clientes set nome=?, cpf=?, sexo=?, data_nascimento=?, estado_civil=?, "
                        + "email=? ,telefone=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id_cliente=?";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getNome());
             stmt.setString(2, obj.getCPF());
             stmt.setString(3, obj.getSexo());
             stmt.setString(4, obj.getDataNascimento());
             stmt.setString(5, obj.getEstadoCivil());
             stmt.setString(6, obj.getEmail());
             stmt.setString(7, obj.getCelular());
             stmt.setString(8, obj.getCEP());
             stmt.setString(9, obj.getEndereco());
             stmt.setInt(10, obj.getNumero());
             stmt.setString(11, obj.getComplemento());
             stmt.setString(12, obj.getBairro());
             stmt.setString(13, obj.getCidade());
             stmt.setString(14, obj.getEstado());
             stmt.setInt(15, obj.getId());
             
             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Alterado com sucessp");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null , "Erro" + e);
        }
    }
    
   /**
     * Método que remove um cliente da base de dados.
     * @param obj - do tipo Cliente.
     */
    public void excluirCliente(Clientes obj){
         //1 passo = criar o comando sql
        try {
            String sql = "delete from tb_clientes where id_cliente = ?";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, obj.getId());
             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Excluido com sucesso");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null , "Erro" + e);
        }
    }
    
   /**
     * Método que trás a lista de clientes.
     * @return List - informações do Cliente.
     */
    public List<Clientes> listarClientes() {
        try {
            //1 passo - Criar a lista
            List<Clientes> lista = new ArrayList<>();
 
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getString("data_nascimento"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCEP(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro: " + e);
        }
        return null;
    }
    
  /**
     * Método que retorna uma busca de cliente pelo nome.
     * @param nome - Nome ds clientes cadastrados.
     * @return String - Cliente especifico.
     */
    public List<Clientes> buscaClientePorNome(String nome) {
        try {
            //1 passo - Criar a lista
            List<Clientes> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getString("data_nascimento"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCEP(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro: " + e);
        }
        return null;
    }
    
    /**
     * Método que consulta Clientes pelo CPF.
     * @param cpf String - indentifica clientes. 
     * @return obj - Informações do cliente cadastrado.
     */
    public Clientes consultaPorCPF(String cpf){
        try {
              String sql = "select * from tb_clientes where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
             Clientes obj = new Clientes();
             if(rs.next()){
               
                obj.setId(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getString("data_nascimento"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("telefone"));
                obj.setCEP(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                
            }
             return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
        return null;
        }
    
}
      

