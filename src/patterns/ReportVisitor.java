
package patterns;

import model.Financial;
import model.Patient;


public interface ReportVisitor {
    
     void visit(Patient patient);
    void visit(Financial financial);
}
