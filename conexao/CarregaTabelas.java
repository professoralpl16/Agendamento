
package conexao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CarregaTabelas {
    
    public DefaultTableModel PreencheTabela(String Colunas[], ResultSet tab) {

        DefaultTableModel aModel = new DefaultTableModel();
        aModel.setNumRows(0);
        aModel.setColumnIdentifiers(Colunas);
        ResultSetMetaData registros;
        try {
            registros = tab.getMetaData();
            int numcolunas = registros.getColumnCount();
            int numlinhas = 0;
            tab.previous();
            while (tab.next()) {
                Object objetos[] = new Object[numcolunas];
                for (int i = 0; i < numcolunas; i++) {
                    objetos[i] = tab.getObject(i + 1);
                }
                aModel.addRow(objetos);
                numlinhas++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar.");
        }
        return aModel;
    }
}
