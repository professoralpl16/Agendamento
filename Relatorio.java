
package conexao;

import java.sql.Connection;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
    public void ImprimeRelatorios(String nome_Rel, Map param)
   {
        ConectaBanco cb = new ConectaBanco();
        Connection con = cb.conectaMySql();
        
        String caminho = System.getProperty("user.dir")+nome_Rel;                      
            
            JasperReport JASP_REP = null;           
           
            JasperPrint JASP_PRINT = null;
        try {           
            
            JASP_REP = JasperCompileManager.compileReport(caminho);
            JASP_PRINT = JasperFillManager.fillReport(JASP_REP, param, con);
        } catch (JRException ex) {
            
        }
            JasperViewer jrv = new JasperViewer(JASP_PRINT, false);
            jrv.setVisible(true);
            }
    
}
    

