
package Controle;

import Modelo.M_UnidadeSaude;
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


public class C_UnidadeSaude {
    
    private String inserieSql = "INSERT INTO unidadesaude (nome, endereco, numero, bairro, telefone, email, "
            + "site, id_estado, id_cidade) VALUE (?,?,?,?,?,?,?,?,?)";
    
    private String alterarSql = "UPDATE unidadesaude SET   nome = ?, endereco = ?, numero = ?,bairro = ?,telefone =?,"
            + "email = ?,site = ?,id_estado = ?,id_cidade = ? WHERE id_unidade = ?";
    
    private String consultaSql = "SELECT * FROM unidadesaude";
    private String consultatSql = "SELECT u.id_unidade, u.nome, u.endereco, u.numero, u.bairro, u.telefone, u.email, "
            + "u.site, e.nomeestado, c.nomecidade FROM unidadesaude u INNER JOIN estado e ON e.id_estado = u.id_estado\n" 
            + "INNER JOIN cidade c ON u.id_cidade = c.id_cidade ORDER BY u.nome";
    private String excluiSql = "DELETE FROM cidade WHERE id_cidade = ?";
    private String sqlcons = "SELECT u.id_unidade, u.nome, u.endereco, u.numero, u.bairro, u.telefone, u.email, u.site, e.nomeestado, c.nomecidade FROM unidadesaude u INNER JOIN estado e ON e.id_estado = u.id_estado\n" +
"INNER JOIN cidade c ON u.id_cidade = c.id_cidade WHERE u.id_unidade  LIKE ? ORDER BY u.id_unidade";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_UnidadeSaude mu = new M_UnidadeSaude();
        
        mu = (M_UnidadeSaude)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, mu.getNome());
            pst.setString(2, mu.getEndereco());
            pst.setInt(3, mu.getNumero());
            pst.setString(4, mu.getBairro());
            pst.setString(5, mu.getTelefone());
            pst.setString(6, mu.getEmail());
            pst.setString(7, mu.getSite());
            pst.setInt(8, mu.getId_estado());
            pst.setInt(9, mu.getId_cidade());
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir"+ex);
        }
        
    }
    
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_UnidadeSaude mu = new M_UnidadeSaude();
        
        mu = (M_UnidadeSaude)aux;
        try {
            pst = con.prepareStatement(alterarSql);
            pst.setString(1, mu.getNome());
            pst.setString(2, mu.getEndereco());
            pst.setInt(3, mu.getNumero());
            pst.setString(4, mu.getBairro());
            pst.setString(5, mu.getTelefone());
            pst.setString(6, mu.getEmail());
            pst.setString(7, mu.getSite());
            pst.setInt(8, mu.getId_estado());
            pst.setInt(9, mu.getId_cidade());
            pst.setInt(10, mu.getId_unidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_UnidadeSaude mu = new M_UnidadeSaude();
        
        mu = (M_UnidadeSaude)aux;
        
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mu.getId_unidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_UnidadeSaude> dadosUnidadeSaude = new ArrayList<M_UnidadeSaude>();
    
    public List<M_UnidadeSaude> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_UnidadeSaude mu = new M_UnidadeSaude();
                
                mu.setId_unidade(tabela.getInt("id_unidade"));
                mu.setNome(tabela.getString("nome"));
                mu.setEndereco(tabela.getString("endereco"));
                mu.setNumero(tabela.getInt("numero"));
                mu.setBairro(tabela.getString("bairro"));
                mu.setTelefone(tabela.getString("telefone"));
                mu.setEmail(tabela.getString("email"));
                mu.setSite(tabela.getString("site"));
                mu.setId_estado(tabela.getInt("id_estado"));
                mu.setId_cidade(tabela.getInt("id_cidade"));
                
                //nome, endereco, numero, bairro, telefone, email,site, id_estado, id_cidade
                
                dadosUnidadeSaude.add(mu);
            }
            
        } catch (SQLException ex) {
            
        }
        return dadosUnidadeSaude;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultatSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_UnidadeSaude.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_UnidadeSaude.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
}
