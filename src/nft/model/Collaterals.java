package nft.model;

public class Collaterals {
    private final String tokenID;
    private final String tokenType;
    private final String loanee;
    private final String loaner;
    private final int tokenRate;

    public Collaterals(String tokenID, String type, String loanee, String loaner, int tokenRate) {
        this.tokenID = tokenID;
        this.tokenType = type;
        this.loanee = loanee;
        this.loaner = loaner;
        this.tokenRate = tokenRate;
    }

    public String getTokenID() {
        return tokenID;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getLoanee() {
        return loanee;
    }

    public String getLoaner() {
        return loaner;
    }

    public int getTokenRate() {
        return tokenRate;
    }
}
