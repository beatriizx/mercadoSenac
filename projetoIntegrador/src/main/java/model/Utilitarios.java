/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author beatrizlira
 */
public class Utilitarios {
    
    public void LimpaTela(JPanel cadastro){
        Component components[] = cadastro.getComponents();
        for(Component component: components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
    
        
    
