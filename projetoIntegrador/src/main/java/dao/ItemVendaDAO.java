/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Clientes;
import model.ItemVenda;
import model.Produtos;
import model.Vendas;

/**
 *
 * @author erick
 */
public class ItemVendaDAO {
    
     private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
   /**
     * Método que inclui novos itens.
     * @param obj - objeto do tipo ItemVenda.
     */
    
    public void cadastraItem(ItemVenda obj){
         try {
             String sql = "insert into tb_itensvendas(venda_id,produto_id,qtd,subtotal) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4,obj.getSubtotal());

            stmt.execute();
            stmt.close();

            
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
   /**
     * Método que lista os itens de uma venda por id
     * @param venda_id int - id dos itens cadastrados
     * @return lista - lista de itensVenda
     */
    
    public List<ItemVenda> listarItensPorVenda(int venda_id) {
        try {
            //1 passo - Criar a lista
            List<ItemVenda> lista = new ArrayList<>();
            
            //2 passo - criar o sql, organizar e executar
            String sql = "select i.id, p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                    + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda_id);
         
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               ItemVenda item = new ItemVenda();
               Produtos prod = new Produtos();
                
            item.setId(rs.getInt("i.id"));
            prod.setDescricao(rs.getString("p.descricao"));
            item.setQtd(rs.getInt("i.qtd"));
            prod.setPreco(rs.getDouble("p.preco"));
            item.setSubtotal(rs.getDouble("i.subtotal"));
            
            item.setProduto(prod);
            
                lista.add(item);
            }
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "erro: " + erro);
        }
        return null;
    }
}
