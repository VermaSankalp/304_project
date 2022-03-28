package nft.model;

import java.math.BigDecimal;

public class Collaterals {
    private final String tokenID;
    private final String type;
    private final String loanee;
    private final String loaner;
    private final BigDecimal tokenRate;

    public Collaterals(String tokenID, String type, String loanee, String loaner, BigDecimal tokenRate) {
        this.tokenID = tokenID;
        this.type = type;
        this.loanee = loanee;
        this.loaner = loaner;
        this.tokenRate = tokenRate;
    }

    public String getTokenID() {
        return tokenID;
    }

    public String getType() {
        return type;
    }

    public String getLoanee() {
        return loanee;
    }

    public String getLoaner() {
        return loaner;
    }

    public BigDecimal getTokenRate() {
        return tokenRate;
    }
}
