package gui;

import model.Claim;

abstract class ClaimHandler {

    protected ClaimHandler nextHandler;

    public void setNext(ClaimHandler handler) {
        this.nextHandler = handler;
    }

    public abstract boolean handle(Claim claim);

    protected boolean passToNext(Claim claim) {
        if (nextHandler != null) {
            return nextHandler.handle(claim);
        }
        return true;
    }
}

class ValidationHandler extends ClaimHandler {

    @Override
    public boolean handle(Claim claim) {

        if (claim.getPatientNic() == null || claim.getAmount() == 0) {
            claim.setStatus("DENIED - Invalid data");
            return false;
        }

        if (claim.getAmount() <= 0) {
            claim.setStatus("DENIED - Invalid amount");
            return false;
        }

        System.out.println("Validation passed");
        return passToNext(claim);
    }
}

class EligibilityHandler extends ClaimHandler {

    @Override
    public boolean handle(Claim claim) {
        System.out.println("Checking patient eligibility");

        if (claim.getPatientNic().equals(null)) {
            claim.setStatus("DENIED - Not eligible");
            return false;
        }

        System.out.println("Patient is eligible");
        return passToNext(claim);
    }
}

class CoverageHandler extends ClaimHandler {

    @Override
    public boolean handle(Claim claim) {
        System.out.println("Checking coverage");

        String serviceType = claim.getServiceType();

        if (serviceType.equals("COSMETIC")) {
            claim.setStatus("DENIED - Not covered");
            return false;
        }

        System.out.println("Service is covered");
        return passToNext(claim);
    }
}

class ApprovalHandler extends ClaimHandler {

    @Override
    public boolean handle(Claim claim) {
        System.out.println("Final approval check");

        double amount = claim.getAmount();

        if (amount > 5000) {
            System.out.println("️High amount - needs manager approval");

            if (hasManagerApproval(claim)) {
                claim.setStatus("APPROVED");
                System.out.println("Manager approved");
                return true;
            } else {
                claim.setStatus("PENDING - Manager approval needed");
                return false;
            }
        }

        claim.setStatus("APPROVED");
        System.out.println("Claim approved");
        return true;
    }

    private boolean hasManagerApproval(Claim claim) {

        return true;
    }
}

public class ClaimProcessor {

    public boolean processStandardClaim(Claim claim) {
        System.out.println("Processing Standard Claim");

        ValidationHandler validation = new ValidationHandler();
        EligibilityHandler eligibility = new EligibilityHandler();
        CoverageHandler coverage = new CoverageHandler();
        ApprovalHandler approval = new ApprovalHandler();

        validation.setNext(eligibility);
        eligibility.setNext(coverage);
        coverage.setNext(approval);

        return validation.handle(claim);
    }

    public boolean processEmergencyClaim(Claim claim) {
        System.out.println("Processing Emergency Claim");

        ValidationHandler validation = new ValidationHandler();
        EligibilityHandler eligibility = new EligibilityHandler();
        ApprovalHandler approval = new ApprovalHandler();

        validation.setNext(eligibility);
        eligibility.setNext(approval);

        return validation.handle(claim);
    }

    public boolean processDirectPayment(Claim claim) {
        System.out.println("Processing Direct Payment");

        ValidationHandler validation = new ValidationHandler();

        boolean result = validation.handle(claim);
        if (result) {
            claim.setStatus("PAID");
            System.out.println("Direct payment processed");
        }
        return result;
    }
}
