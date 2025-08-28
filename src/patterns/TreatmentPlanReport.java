
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


public class TreatmentPlanReport implements ReportVisitor {
      @Override
    public void visit(Patient patient) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("Parameter1", patient.getName());
            params.put("Parameter2", patient.getDiagnosis());
            params.put("Parameter3", patient.getTreatmentPlan());

           String path = "src/reports/TreatmentReport.jasper";
           
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visit(Financial financial) {
        
    }
}
