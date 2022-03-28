package nft.model;

public class BidOn {
    private final String tokenID;
    private final String buyerID;

    public BidOn(String tokenID, String buyerID) {
        this.tokenID = tokenID;
        this.buyerID = buyerID;
    }

    public String getTokenID() {
        return tokenID;
    }

    public String getBuyerID() {
        return buyerID;
    }
}
