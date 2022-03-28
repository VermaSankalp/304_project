package nft.model;

public class SellsTo {
    private final String buyerID;
    private final String cAddress;

    public SellsTo(String buyerID, String cAddress) {
        this.buyerID = buyerID;
        this.cAddress = cAddress;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public String getCAddress() {
        return cAddress;
    }
}
