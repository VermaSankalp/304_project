package nft.model;

import java.math.BigDecimal;

public class Buyers {
    private String personID;
    private String buyerID;
    private BigDecimal currentBid;

    public Buyers(String personID, String buyerID, BigDecimal currentBid) {
        this.personID = personID;
        this.buyerID = buyerID;
        this.currentBid = currentBid;
    }

    public String getPersonID() {
        return personID;
    }

    public String getBuyerID() {
        return buyerID;
    }

    public BigDecimal getCurrentBid() {
        return currentBid;
    }
}
