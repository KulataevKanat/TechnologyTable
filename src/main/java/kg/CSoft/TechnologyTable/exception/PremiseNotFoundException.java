package kg.CSoft.TechnologyTable.exception;

public class PremiseNotFoundException extends RuntimeException {
    public PremiseNotFoundException() {
    }

    public PremiseNotFoundException(Long premiseId) {
        super("Premise: " + premiseId + " not found.");
    }
}
