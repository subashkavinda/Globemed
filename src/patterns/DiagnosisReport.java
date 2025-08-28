
package patterns;

import java.util.HashMap;
import java.util.Map;
import model.Financial;
import model.Patient;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class DiagnosisReport implements ReportVisitor{

    @Override
    public void visit(Patient patient) {
   
    try {
            Map<String, Object> params = new HashMap<>();
            params.put("patientName", patient.getName());
            params.put("diagnosis", patient.getDiagnosis());
            params.put("recommendations",
                    "• Continue current medications\n" +
                    "• Maintain healthy diet\n" +
                    "• Regular exercise\n" +
                    "• Monitor blood sugar\n" +
                    "• Follow-up in 6 weeks");

            JasperReport jasperReport = JasperCompileManager.compileReport("reports/diagnosisReport.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void visit(Financial financial) {

        

    }
    
}
