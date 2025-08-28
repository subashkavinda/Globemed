
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
        
        
        
        if(financial.isClaimInsurance()){
        
            System.out.println("insurance");
        
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("Parameter1", financial.getPatientName());
            params.put("Parameter2", financial.getPatientMobile());
            params.put("Parameter3", financial.getPatientDob());
            params.put("Parameter4",String.valueOf( financial.getAppointmentId()));
            params.put("Parameter5", financial.getServiceType());
            params.put("Parameter6",String.valueOf( financial.getAmount()));
            params.put("Parameter7",financial.getInsuranceCompany());
            params.put("Parameter8",financial.getPolicyNumber());
            params.put("Parameter9",financial.getHolderName());

             String path = "src/reports/insuranceClaim.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }else{
        
         System.out.println("direct");
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("Parameter1", financial.getPatientName());
            params.put("Parameter2", financial.getPatientMobile());
            params.put("Parameter3", financial.getPatientDob());
            params.put("Parameter4",String.valueOf( financial.getAppointmentId()));
            params.put("Parameter5", financial.getServiceType());
            params.put("Parameter6",String.valueOf( financial.getAmount()));

             String path = "src/reports/DirectPayment.jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        

        

    }
    
}
