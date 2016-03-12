
package Controle;

import Modelo.M_Especialidade;
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

public class C_Especialidade {
    private String inserieSql = "INSERT INTO especialidade (nome) VALUES (?)";
    private String alterarSql = "UPDATE especialidade SET nome = ? WHERE id_especialidade = ?";
    private String consultaSql = "SELECT * FROM especialidade";
    private String excluiSql = "DELETE FROM especialidade WHERE id_especialidade = ?";
    private String sqlcons = "SELECT * FROM especialidade WHERE nome LIKE ?";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Especialidade me = new M_Especialidade();
        
        me = (M_Especialidade)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, me.getNome());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir"+ex);
        }
    
    }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Especialidade me = new M_Especialidade();
        
        me = (M_Especialidade)aux;
        try {
            pst= con.prepareStatement(alterarSql);
            pst.setString(1, me.getNome());
            pst.setInt(2, me.getId_especialidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Especialidade me = new M_Especialidade();
        
        me = (M_Especialidade)aux;
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, me.getId_especialidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Especialidade> dadosEspecialidade = new ArrayList<M_Especialidade>();
    
    public List<M_Especialidade> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_Especialidade me = new M_Especialidade();
                
                me.setId_especialidade(tabela.getInt("id_Especialidade"));
                me.setNome(tabela.getString("nome"));
                
                dadosEspecialidade.add(me);
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        return dadosEspecialidade;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultaSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Especialidade.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_Especialidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
    
}
