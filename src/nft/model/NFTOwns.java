package nft.model;


public class NFTOwns {
    private final String tokenID;
    private final String personId;
    private final String tokenType;


    public NFTOwns(String tokenID, String personId, String tokenType) {
        this.tokenID = tokenID;
        this.personId = personId;
        this.tokenType = tokenType;
    }


    public String getTokenID() {
        return tokenID;
    }

    public String getPersonId() {return personId;};

    public String getTokenType() {
        return tokenType;
    }

}
