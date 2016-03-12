
package Controle;

import Modelo.M_Especialidade;
import Modelo.M_Estado;
import Modelo.M_MarcaVeiculo;
import conexao.ConectaBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class C_MarcaVeiculo {
    private String inserieSql = "INSERT INTO marca_veiculo (marca) VALUES (?)";
    private String alterarSql = "UPDATE marca_veiculO SET marca = ? WHERE id_marca = ?";
    private String consultaSql = "SELECT * FROM marca_veiculo";
    private String excluiSql = "DELETE FROM marca_veiculo WHERE id_marca = ?";
    private String sqlcons = "SELECT * FROM marca_veiculo WHERE marca LIKE ?";
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_MarcaVeiculo mm = new M_MarcaVeiculo();
        
        mm = (M_MarcaVeiculo)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, mm.getMarca());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir"+ex);
        }
    
    }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_MarcaVeiculo mm = new M_MarcaVeiculo();
        
        mm = (M_MarcaVeiculo)aux;
        try {
            pst= con.prepareStatement(alterarSql);
            pst.setString(1, mm.getMarca());
            pst.setInt(2, mm.getId_marca());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_MarcaVeiculo mm = new M_MarcaVeiculo();
        
        mm = (M_MarcaVeiculo)aux;
        
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mm.getId_marca());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_MarcaVeiculo> dadosMarcaVeiculo = new ArrayList<M_MarcaVeiculo>();
    
    public List<M_MarcaVeiculo> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_MarcaVeiculo mm = new M_MarcaVeiculo();
                
                mm.setId_marca(tabela.getInt("id_marca"));
                mm.setMarca(tabela.getString("marca"));
                
                dadosMarcaVeiculo.add(mm);
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        return dadosMarcaVeiculo;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultaSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_MarcaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_MarcaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
    
   
}
