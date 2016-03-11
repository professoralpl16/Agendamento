/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ConectaBanco {
    private String caminho = "jdbc:mysql://localhost:3306/agendamento";
    private String usuario = "root";
    private String senha = "";
    
    public Connection conectaMySql(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection(caminho,usuario,senha);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro Banco");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro Driver - Classe Não Encontrada");
        }
        
        return con;
    }
}
