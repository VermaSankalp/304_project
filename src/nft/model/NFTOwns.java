package nft.model;


public class NFTOwns {
    private final String tokenID;
    private final String tokenType;


    public NFTOwns(String tokenID, String tokenType) {
        this.tokenID = tokenID;
        this.tokenType = tokenType;
    }


    public String getTokenID() {
        return tokenID;
    }

    public String getTokenType() {
        return tokenType;
    }

}
