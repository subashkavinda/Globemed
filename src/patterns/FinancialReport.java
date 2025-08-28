
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


public class FinancialReport implements ReportVisitor{

    @Override
    public void visit(Patient patient) {

        

    }

    @Override
    public void visit(Financial financial) {

        try {
            Map<String, Object> params = new HashMap<>();
            params.put("patientName", financial.getPatientName());
            params.put("appointmentId", financial.getAppointmentId());
            params.put("serviceType", financial.getServiceType());
            params.put("amount", financial.getAmount());

            JasperReport jasperReport = JasperCompileManager.compileReport("reports/financialReport.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
