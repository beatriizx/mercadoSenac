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
import javax.swing.JOptionPane;
import model.Clientes;
import model.Funcionarios;
import view.telaLogin;
import view.telaMenu;

/**
 *
 * @author beatrizlira
 */
public class FuncionarioDAO {
    private Connection con;
    
    public FuncionarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
     public void cadastrarFuncionario(Funcionarios obj){
        //1 passo = criar o comando sql
        try {
            String sql = "insert into tb_funcionarios(nome, cpf, email, senha, cargo, nivel_acesso, telefone, cep, endereco, numero, complemento, bairro, cidade, estado, sexo, data_nascimento, estado_civil)"
                                                + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getNome());
             stmt.setString(2, obj.getCPF());
             stmt.setString(3, obj.getEmail());
             stmt.setString(4, obj.getSenha());
             stmt.setString(5, obj.getCargo());
             stmt.setString(6, obj.getNivelAcesso());
             stmt.setString(7, obj.getCelular());
             stmt.setString(8, obj.getCEP());
             stmt.setString(9, obj.getEndereco());
             stmt.setInt(10, obj.getNumero());
             stmt.setString(11, obj.getComplemento());
             stmt.setString(12, obj.getBairro());
             stmt.setString(13, obj.getCidade());
             stmt.setString(14, obj.getEstado());
             stmt.setString(15, obj.getSexo());
             stmt.setString(16, obj.getDataNascimento());
             stmt.setString(17, obj.getEstadoCivil());
             
             //Antes do seu save


             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Cadastrado com sucesso");
//        }catch(SQLIntegrityConstraintViolationException erro){
//            JOptionPane.showMessageDialog(null , "CPF já cadastrado");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null , "Erro" + e);
        } 
    } 
       
     public void alterarFuncionario(Funcionarios obj){
         //1 passo = criar o comando sql
        try {
            String sql = "update tb_funcionarios set nome=?, cpf=?, email=? , senha=?, cargo = ?, nivel_acesso = ?, telefone=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, sexo=?, data_nascimento=?, estado_civil=?  where id=?";
            // 2 passo - conectar o banco de dados e organizar o comando sql
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, obj.getNome());
             stmt.setString(2, obj.getCPF());
             stmt.setString(3, obj.getEmail());
             stmt.setString(4, obj.getSenha());
             stmt.setString(5, obj.getCargo());
             stmt.setString(6, obj.getNivelAcesso());
             stmt.setString(7, obj.getCelular());
             stmt.setString(8, obj.getCEP());
             stmt.setString(9, obj.getEndereco());
             stmt.setInt(10, obj.getNumero());
             stmt.setString(11, obj.getComplemento());
             stmt.setString(12, obj.getBairro());
             stmt.setString(13, obj.getCidade());
             stmt.setString(14, obj.getEstado());
             stmt.setString(15, obj.getSexo());
             stmt.setString(16, obj.getDataNascimento());
             stmt.setString(17, obj.getEstadoCivil());
             stmt.setInt(18, obj.getId());
             
             //3 passo- executar o comando sql
             stmt.execute();
             stmt.close();
             
             JOptionPane.showMessageDialog(null , "Alterado com sucesso");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null , "Erro" + e);
        }
    }
     
      //Metodo excluirCliente
    public void excluirFuncionario(Funcionarios obj){
         //1 passo = criar o comando sql
        try {
            String sql = "delete from tb_funcionarios where id = ?";
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
     
        public List<Funcionarios> buscaFuncionarioPorNome(String nome) {
        try {
            //1 passo - Criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getString("data_nascimento"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setEmail(rs.getString("email"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                obj.setSenha(rs.getString("senha"));
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
        
            // Método listar clientes
    public List<Funcionarios> listarFuncionarios() {
        try {
            //1 passo - Criar a lista
            List<Funcionarios> lista = new ArrayList<>();
 
            //2 passo - criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setSexo(rs.getString("sexo"));
                obj.setDataNascimento(rs.getString("data_nascimento"));
                obj.setEstadoCivil(rs.getString("estado_civil"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
    
        public Funcionarios consultaPorCPF(String cpf){
        try {
              String sql = "select * from tb_funcionarios where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
             Funcionarios obj = new Funcionarios();
             if(rs.next()){
               
                obj.setId(rs.getInt("id"));
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
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso")); 
                obj.setSenha(rs.getString("senha"));
                
                
                
            }
             return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado");
        }
        return null;
        }
        
           public void logar(String email, String senha){
                   
            try {
                String sql = "select * from tb_funcionarios where email = ? and senha = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();
             
                if(rs.next()){
                    //usuario logado
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema");
                    telaMenu menu = new telaMenu();
                    menu.setVisible(true);
                    telaLogin login = new telaLogin();
                    login.setVisible(false);
                } else{
                   //dados incorretos 
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos");
                }
            } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Erro: " + e);
            }
        
}
               }
     
 
    

     
     

