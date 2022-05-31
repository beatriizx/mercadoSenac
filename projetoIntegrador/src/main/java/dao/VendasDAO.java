/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Clientes;
import model.Vendas;

/**
 *
 * @author erick
 */
public class VendasDAO {
     private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    /**
     * //Método que registra novas vendas.
     * @param obj - objeto do tipo Vendas.
     */
    
    public void cadastrarVenda(Vendas obj){
        try {
             String sql = "insert into tb_vendas(cliente_id,data_venda,total_venda) values (?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            

            
            stmt.execute();
            stmt.close();
          
        }catch(SQLIntegrityConstraintViolationException erro){
            JOptionPane.showMessageDialog(null , "Produto já cadastrado");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    /**
     * Método que retorna o id da ultima venda realizada.
     * @return idVenda - id da venda.
     */
    public int retornaUltimaVenda(){
        try {
            int idVenda = 0;
            
            String sql = "select max(id) id from tb_vendas";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                Vendas p = new Vendas();
                
                p.setId(rs.getInt("id"));
                idVenda = p.getId();
            }
            return idVenda;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
   /**
     * Método que filtra vendas por data
     * @param data_inicio LocalDate - data inicial da busca
     * @param data_fim LocalDate- data final da busca
     * @return lista - lista com vendas realizadas no periodo buscado
     */
    
     public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicio) {
        try {
            //1 passo - Criar a lista
            List<Vendas> lista = new ArrayList<>();
            
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select v.id , date_format(v.data_venda,'%d/%m/%y') as data_formatada , c.nome , v.total_venda from tb_vendas as v  "
                    + " inner join tb_clientes as c on(v.cliente_id = c.id_cliente) where v.data_venda between ? and date_add(?, interval 30 day)" ;
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(data_inicio);
            
//            Date datefim = java.sql.Date.valueOf(data_fim);
            stmt.setDate(1, date);
            stmt.setDate(2, date);
            
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Vendas obj = new Vendas();
                Clientes c = new Clientes();
                
            obj.setId(rs.getInt("v.id"));
            obj.setData_venda(rs.getString("data_formatada"));
            c.setNome(rs.getString("c.nome"));
            obj.setTotal_venda(rs.getDouble("v.total_venda"));
               
            obj.setCliente(c);
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro: " + erro);
        }
        return null;
    }
     
     /**
      * Método que retorna o total das vendas por data,
      * @param data_venda - data da venda.
      * @return totalvenda Double - exibe valor total da venda.
      */
     public double retornaTotalVendaPorData(LocalDate data_venda){
         try {
             double totalvenda = 0;
             
             String sql = "select sum(total_venda) as total from tb_vendas where data_venda =? ";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1,data_venda.toString());
             
             ResultSet rs = ps.executeQuery();
             
             if (rs.next()) {
                 totalvenda = rs.getDouble("total");
             
             }
             return totalvenda;
             
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
     }
}
