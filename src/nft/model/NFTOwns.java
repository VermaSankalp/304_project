package nft.model;


public class NFTOwns {
    private final String tokenID;
    private final String personID;
    private final String tokenType;


    public NFTOwns(String tokenID, String personID, String tokenType) {
        this.tokenID = tokenID;
        this.personID = personID;
        this.tokenType = tokenType;
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

}
