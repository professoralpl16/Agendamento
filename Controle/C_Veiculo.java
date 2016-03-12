
package Controle;

import Modelo.M_Veiculo;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.xml.internal.fastinfoset.util.DuplicateAttributeVerifier;
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


public class C_Veiculo {
                              // INSERT INTO veiculo (id_marca, modelo, qtdpassageiros, anofabricacao, cor, placa, patrimonio, anomodelo, chassi, renavam, id_combustivel)
    private String inserieSql = "INSERT INTO veiculo (id_marca, modelo, qtdpassageiros, anofabricacao, cor, placa, patrimonio, anomodelo, chassi, renavam, id_combustivel)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private String alterarSql = "UPDATE veiculo SET id_marca = ?, modelo = ?, qtdpassageiros = ?, anofabricacao = ?, cor = ?,"
            + " placa = ?, patrimonio = ?, anomodelo = ?, chassi = ?, renavam = ?, id_combustivel = ? WHERE id_veiculo = ?";
    private String consultaSql = "SELECT * FROM veiculo";
    private String consultatSql = "SELECT v.id_veiculo, m.marca, v.modelo, v.qtdpassageiros, v.anofabricacao, "
            + "v.cor, v.placa, v.patrimonio, v.anomodelo, v.chassi, v.renavam, c.tipo FROM veiculo v "
            + "INNER JOIN marca_veiculo m ON m.id_marca = v.id_marca INNER JOIN combustivel c "
            + "on c.id_combustivel = v.id_combustivel";
    private String excluiSql = "DELETE FROM veiculo WHERE id_veiculo = ?";
    private String sqlcons = "SELECT v.id_veiculo, v.placa, v.anofabricacao, v.anomodelo, v.chassi, v.renavam, v.qtdpassageiros, "
            + "v.patrimonio, m.marca, v.modelo, v.cor, c.tipo FROM veiculo v INNER JOIN marca_veiculo m ON m.id_marca = v.id_marca "
            + "INNER JOIN combustivel c on c.id_combustivel = v.id_combustivel WHERE v.placa LIKE ?";
    
    
    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
    
        // realizar verificações necessárias... (restrições)
        // if (verificarPlacaExistente(){...
        throw new PlacaExistenteException();
        
        M_Veiculo mv = new M_Veiculo();
        
        mv = (M_Veiculo)aux;
        
        try {
            pst = con.prepareStatement(inserieSql);
            pst.setInt(1, mv.getId_marca());
            pst.setString(2, mv.getModelo());
            pst.setInt(3, mv.getQtdpassageiro());
            pst.setInt(4, mv.getAnofabricacao());
            pst.setString(5, mv.getCor());
        
            pst.setString(6, mv.getPlaca());
        
            pst.setString(7, mv.getPatrimonio());
            pst.setInt(8, mv.getAnomodelo());
            pst.setString(9, mv.getChassi());
            pst.setInt(10, mv.getRenavam());
            pst.setInt(11, mv.getId_combustivel());
            pst.executeUpdate();
    }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veiculo ja cadastrado "+ex);
        }
        }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_Veiculo mv = new M_Veiculo();
        
        mv = (M_Veiculo)aux;
        
        try {
            pst = con.prepareStatement(alterarSql);
            pst.setInt(1, mv.getId_marca());
            pst.setString(2, mv.getModelo());
            pst.setInt(3, mv.getQtdpassageiro());
            pst.setInt(4, mv.getAnofabricacao());
            pst.setString(5, mv.getCor());
            pst.setString(6, mv.getPlaca());
            pst.setString(7, mv.getPatrimonio());
            pst.setInt(8, mv.getAnomodelo());
            pst.setString(9, mv.getChassi());
            pst.setInt(10, mv.getRenavam());
            pst.setInt(11, mv.getId_combustivel());
            pst.setInt(12, mv.getId_veiculo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        M_Veiculo mv = new M_Veiculo();
        
        mv = (M_Veiculo)aux;
        
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mv.getId_veiculo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Veiculo> dadosVeiculo = new ArrayList<M_Veiculo>();
    
    public List<M_Veiculo> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_Veiculo mv = new M_Veiculo();
                
                mv.setId_veiculo(tabela.getInt("id_veiculo"));
                mv.setModelo(tabela.getString("modelo"));
                mv.setPlaca(tabela.getString("placa"));
                dadosVeiculo.add(mv);
            }
            
        } catch (SQLException ex) {
            
        }
        return dadosVeiculo;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultatSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Veiculo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_Veiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
}
