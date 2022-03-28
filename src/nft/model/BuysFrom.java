package nft.model;

public class BuysFrom {
    private final String domain;
    private final String buyerID;

    public BuysFrom(String domain, String buyerID) {
        this.domain = domain;
        this.buyerID = buyerID;
    }

    public String getDomain() {
        return domain;
    }

    public String getBuyerID() {
        return buyerID;
    }
}
