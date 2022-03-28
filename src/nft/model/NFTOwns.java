package nft.model;

import java.math.BigDecimal;
import java.util.Date;

public class NFTOwns {
    private final String tokenID;
    private final String personID;
    private final String tokenType;
    private final Date publishedOn;

    public NFTOwns(String tokenID, String personID, String tokenType, Date publishedOn) {
        this.tokenID = tokenID;
        this.personID = personID;
        this.tokenType = tokenType;
        this.publishedOn = publishedOn;
    }

    public String getTokenID() {
        return tokenID;
    }

    public String getPersonID() {
        return personID;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }
}
