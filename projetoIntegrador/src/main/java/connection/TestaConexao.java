/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import javax.swing.JOptionPane;

/**
 *
 * @author beatrizlira
 */
public class TestaConexao {
    public static void main(String[] args){
        try{
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "conectado com sucesso");
                    
        } catch(Exception e){
              JOptionPane.showMessageDialog(null, "Houve um erro" + e);
        }
    }
            
    
}
