
package Controle;

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

public class C_Estado {
    private String inserieSql = "INSERT INTO estado (nomeestado, sigla) VALUES (?,?)";
    private String alterarSql = "UPDATE estado SET nomeestado = ?, sigla = ? WHERE id_estado = ?";
    private String consultaSql = "SELECT * FROM estado";
    private String excluiSql = "DELETE FROM estado WHERE id_estado = ?";
    private String sqlcons = "SELECT * FROM estado WHERE nomeestado LIKE ?";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Estado me = new M_Estado();
        
        me = (M_Estado)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, me.getNomeestado());
            pst.setString(2, me.getSigla());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de inserir"+ex);
        }
    
    }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Estado me = new M_Estado();
        
        me = (M_Estado)aux;
        try {
            pst= con.prepareStatement(alterarSql);
            pst.setString(1, me.getNomeestado());
            pst.setString(2, me.getSigla());
            pst.setInt(3, me.getId_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Estado me = new M_Estado();
        
        me = (M_Estado)aux;
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, me.getId_estado());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Estado> dadosEstado = new ArrayList<M_Estado>();
    
    public List<M_Estado> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_Estado me = new M_Estado();
                
                me.setId_estado(tabela.getInt("id_estado"));
                me.setNomeestado(tabela.getString("nomeestado"));
                me.setSigla(tabela.getString("sigla"));
                
                dadosEstado.add(me);
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        return dadosEstado;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultaSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Estado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_Estado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
    
}
