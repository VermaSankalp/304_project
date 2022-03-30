package nft.model;


public class HostedOn {
    private final String domain;
    private final String tokenID;

    public HostedOn(String domain, String tokenID) {
        this.domain = domain;
        this.tokenID = tokenID;
    }

    public String getDomain() {
        return domain;
    }

    public String getTokenID() {
        return tokenID;
    }
}
