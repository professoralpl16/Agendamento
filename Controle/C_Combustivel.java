
package Controle;

import Modelo.M_Combustivel;
import Modelo.M_Estado;
import conexao.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class C_Combustivel {
    private String inserieSql = "INSERT INTO combustivel (tipo) VALUES (?)";
    private String alterarSql = "UPDATE combustivel SET tipo = ? WHERE id_combustivel = ?";
    private String consultaSql = "SELECT * FROM combustivel";
    private String excluiSql = "DELETE FROM combustivel WHERE id_combustivel = ?";
    private String sqlcons = "SELECT * FROM combustivel WHERE tipo LIKE ?";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Combustivel mc = new M_Combustivel();
        
        mc = (M_Combustivel)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, mc.getTipo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Novo Cadastro Inserido com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de inserir"+ex);
        }
    
    }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Combustivel mc = new M_Combustivel();
        
        mc = (M_Combustivel)aux;
        
        try {
            pst= con.prepareStatement(alterarSql);
            pst.setString(1, mc.getTipo());
            pst.setInt(2, mc.getId_combustivel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Combustivel mc = new M_Combustivel();
        
        mc = (M_Combustivel)aux;
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mc.getId_combustivel());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Combustivel> dadosCombustivel = new ArrayList<M_Combustivel>();
    
    public List<M_Combustivel> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_Combustivel mc = new M_Combustivel();
                
                mc.setId_combustivel(tabela.getInt("id_combustivel"));
                mc.setTipo(tabela.getString("Tipo"));
                
                dadosCombustivel.add(mc);
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        return dadosCombustivel;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultaSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Combustivel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabela;
    }
    
    public ResultSet dadosTabela(String valor)
    {
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        try {
            pst = con.prepareStatement(sqlcons,ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            pst.setString(1, valor+"%");
            tabela = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(C_Combustivel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
    
}
