package nft.model;

public class Gaming {
    private final String tokenID;
    private final String gameID;
    private final String publisher;


    public Gaming(String tokenID, String gameID, String publisher) {
        this.tokenID = tokenID;
        this.gameID = gameID;
        this.publisher = publisher;
    }

    public String getTokenID() {
        return tokenID;
    }

    public String getGameID() {
        return gameID;
    }

    public String getPublisher() {
        return publisher;
    }

}
