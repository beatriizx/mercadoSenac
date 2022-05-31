/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author beatrizlira
 */
public class ConnectionFactory {
    private static  final String DRIVER = "com.mysql.jdbc.Driver";
    public Connection getConnection(){
        try {
             Class.forName(DRIVER);
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador?allowPublicKeyRetrieval=true&useSSL=false", "projeto_integrador", "123");
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }
    
}
