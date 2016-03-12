
package Controle;

import Modelo.M_Combustivel;
import Modelo.M_Estado;
import Modelo.M_Paciente;
import conexao.ConectaBanco;
import java.io.FileInputStream;
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

public class C_Paciente {
    private String inserieSql = "INSERT INTO paciente (nome, carsus, id_estado, nascimento, id_cidade, cpf, rg, telefone, foto, "
            + "naturalidade, endereco, numero, estado_civil, cep, nomepae, nomemae, celular, bairro,sexo) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private String alterarSql = "UPDATE paciente SET nome = ?,carsus =?,id_estado = ?,nascimento = ?,id_cidade =?,cpf = ?,rg =?,telefone =?,foto =?,naturalidade =?,endereco =?,numero =?,estado_civil =?,cep =?,nomepae =?,nomemae =?,celular =?,bairro =?,sexo=? WHERE id_paciente =?";
                               //UPDATE paciente SET nome = ?,carsus = ?,id_estado = ?,nascimento = ?,id_cidade = ?,cpf = ?,rg = ?,telefone = ?,foto = ?,naturalidade = ?,endereco = ?,numero = ?,estado_civil = ?,cep = ?,nomepae = ?,nomemae = ?,celular = ?,bairro = ?,sexo = ? WHERE id_paciente = ?
    private String consultaSql = "SELECT * FROM paciente";
    private String excluiSql = "DELETE FROM paciente WHERE id_paciente = ?";
    private String consultatSql = "SELECT p.id_paciente, p.nome, p.carsus, e.nomeestado, p.nascimento, c.nomecidade, p.cpf, "
            + "p.rg, p.telefone, p.foto, p.naturalidade, p.endereco, p.numero, p.estado_civil, p.cep, p.nomepae, p.nomemae, "
            + "p.celular, p.bairro,p.sexo FROM paciente p INNER JOIN estado e ON e.id_estado = p.id_estado INNER JOIN cidade c "
            + "ON c.id_cidade = p.id_cidade GROUP BY p.nome, p.carsus ORDER BY p.nome";
    private String sqlcons = "SELECT p.id_paciente, p.carsus, p.nome, p.nascimento, p.naturalidade, e.nomeestado, c.nomecidade, p.endereco, p.numero, p.bairro, p.cep, p.cpf, p.rg, p.telefone, p.celular, p.estado_civil, p.nomepae, p.nomemae, p.sexo, p.foto FROM paciente p INNER JOIN estado e ON e.id_estado = p.id_estado INNER JOIN cidade c ON c.id_cidade = p.id_cidade WHERE p.nome || p.carsus LIKE?";

    
    private Statement stmt;
    private PreparedStatement pst;
    private ResultSet tabela;
    
    public void inserirSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Paciente mp = new M_Paciente();
        
        mp = (M_Paciente)aux;
        
        try{ 
            
            pst = con.prepareStatement(inserieSql);
            pst.setString(1, mp.getNome());
            
            pst.setInt(2, mp.getCarsus());
            
            pst.setInt(3, mp.getId_estado());
            pst.setString(4, mp.getNascimento());
            pst.setInt(5, mp.getId_cidade());
            pst.setString(6, mp.getCpf());
            pst.setString(7, mp.getRg());
            pst.setString(8, mp.getTelefone());
            pst.setBinaryStream(9, mp.getFoto());
            pst.setString(10, mp.getNaturalidade());
            pst.setString(11, mp.getEndereco());
            pst.setString(12, mp.getNumero());
            pst.setString(13, mp.getEstado_civil());
            pst.setString(14, mp.getCep());
            pst.setString(15, mp.getNomepai());
            pst.setString(16, mp.getNomemae());
            pst.setString(17, mp.getCelular());
            pst.setString(18, mp.getBairro());
            pst.setString(19, mp.getSexo());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Novo Cadastro Inserido com Sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cartao SUS ja existente!!! ");
        }
    
    }
    public void alterarSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Paciente mp = new M_Paciente();
        
        mp = (M_Paciente)aux;
        try {
            pst= con.prepareStatement(alterarSql);
            pst.setString(1, mp.getNome());
            pst.setInt(2, mp.getCarsus());
            pst.setInt(3, mp.getId_estado());
            pst.setString(4, mp.getNascimento());
            pst.setInt(5, mp.getId_cidade());
            pst.setString(6, mp.getCpf());
            pst.setString(7, mp.getRg());
            pst.setString(8, mp.getTelefone());
            pst.setBinaryStream(9, mp.getFoto());
            pst.setString(10, mp.getNaturalidade());
            pst.setString(11, mp.getEndereco());
            pst.setString(12, mp.getNumero());
            pst.setString(13, mp.getEstado_civil());
            pst.setString(14, mp.getCep());
            pst.setString(15, mp.getNomepai());
            pst.setString(16, mp.getNomemae());
            pst.setString(17, mp.getCelular());
            pst.setString(18, mp.getBairro());
            pst.setString(19, mp.getSexo());
            pst.setInt(20, mp.getId_paciente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar documento!!!");
        }
        
    }
    
    public void excluiSql(Object aux){
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        M_Paciente mp = new M_Paciente();
        
        mp = (M_Paciente)aux;
        try {
            pst = con.prepareStatement(excluiSql);
            pst.setInt(1, mp.getId_paciente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir documento!!!");
        }
        
    }
    
    private List<M_Paciente> dadosPaciente = new ArrayList<M_Paciente>();
    
    public List<M_Paciente> retornaCombo() {
        
        ConectaBanco cb = new ConectaBanco();
        Connection con =  cb.conectaMySql();
        
        
        try {
            stmt = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_INSENSITIVE);
            tabela = stmt.executeQuery(consultaSql);
            
            while(tabela.next())
            {
                M_Paciente mp = new M_Paciente();
                
                mp.setId_paciente(tabela.getInt("id_paciente"));
                mp.setNome(tabela.getString("nome"));
                mp.setCarsus(tabela.getInt("carsus"));
                
                dadosPaciente.add(mp);
            }
            
        } catch (SQLException ex) {
            
        }
        
        
        return dadosPaciente;
    }
    
    public ResultSet consultaDados() {
      
        ResultSet tabela = null;
        ConectaBanco cb = new ConectaBanco();
        
        Connection con = cb.conectaMySql();
        
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            tabela = stmt.executeQuery(consultaSql);
        } catch (SQLException ex) {
            Logger.getLogger(C_Paciente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(C_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return tabela;
    }
    
}
