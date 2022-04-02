package nft.model;
import java.math.BigDecimal;

public class Sellers {
    private final String personID;
    private final String cAddress;
    private final int currentBid;

    public Sellers(String personID, String cAddress, int currentBid) {
        this.personID = personID;
        this.cAddress = cAddress;
        this.currentBid = currentBid;
    }

    public String getPersonID() {
        return personID;
    }

    public String getCAddress() {
        return cAddress;
    }

    public int getCurrentBid() {
        return currentBid;
    }
}
