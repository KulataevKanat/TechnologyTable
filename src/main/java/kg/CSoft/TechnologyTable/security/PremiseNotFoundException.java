package kg.CSoft.TechnologyTable.security;

public class PremiseNotFoundException extends RuntimeException {
    public PremiseNotFoundException() {
    }

    public PremiseNotFoundException(Long premiseId) {
        super("Premise: " + premiseId + " not found.");
    }
}
