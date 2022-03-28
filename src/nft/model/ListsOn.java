package nft.model;

public class ListsOn {
    private final String domain;
    private final String cAddress;

    public ListsOn(String domain, String cAddress) {
        this.domain = domain;
        this.cAddress = cAddress;
    }

    public String getDomain() {
        return domain;
    }

    public String getCAddress() {
        return cAddress;
    }
}
