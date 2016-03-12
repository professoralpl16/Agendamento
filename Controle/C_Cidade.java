
package Controle;

import Modelo.M_Cidade;
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


public class C_Cidade {
    
    private String inserieSql = "INSERT INTO cidade (nomecidade, id_estado) VALUES (?,?)";
    private String alterarSql = "UPDATE cidade SET nomecidade = ?, id_estado = ? WHERE id_cidade = ?";
    private String consultaSql = "SELECT c.id_cidade, c.nomecidade, c.id_estado FROM cidade c, estado u "
            + "WHERE u.id_estado = c.id_estado AND u.nomeestado = ? ORDER BY c.nomecidade ASC ";
    private String consultatSql = "SELECT c.id_cidade, c.nomecidade, e.nomeestado FROM cidade c "
            + "INNER JOIN estado e ON c.id_estado = e.id_estado ORDER BY c.nomecidade";
    private String excluiSql = "DELETE FROM cidade WHERE id_cidade = ?";
    private String sqlcons = "SELECT c.id_cidade, c.nomecidade, e.nomeestado FROM cidade c INNER JOIN estado e ON c.id_estado = e.id_estado WHERE c.nomecidade LIKE ?";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_Cidade mc = new M_Cidade();
        
        mc = (M_Cidade)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, mc.getNomecidade());
            pst.setInt(2, mc.getId_estado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir"+ex);
        }
    
    }
    
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_Cidade mc = new M_Cidade();
        
        mc = (M_Cidade)aux;
        try {
            pst = con.prepareStatement(alterarSql);
            pst.setString(1, mc.getNomecidade());
            pst.setInt(2, mc.getId_estado());
            pst.setInt(3, mc.getId_cidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_Cidade mc = new M_Cidade();
        
        mc = (M_Cidade)aux;
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mc.getId_cidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Cidade> dadosCidade = new ArrayList<M_Cidade>();
    
    public List<M_Cidade> retornaCombo(String aux) {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        ResultSet tabela;
        
        try {
            pst = con.prepareStatement(consultaSql);
            pst.setString(1, aux);
            tabela = pst.executeQuery();
            
            while(tabela.next())
            {
                M_Cidade mc = new M_Cidade();
                
                
                mc.setId_cidade(tabela.getInt("id_cidade"));
                mc.setNomecidade(tabela.getString("nomecidade"));
                mc.setId_estado(tabela.getInt("id_estado"));
                
                
                dadosCidade.add(mc);
            }
            
        } catch (SQLException ex) {
            
        }
        return dadosCidade;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultatSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Cidade.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_Cidade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
}
