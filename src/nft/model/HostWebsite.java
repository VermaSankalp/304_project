package nft.model;

import java.util.Date;

public class HostWebsite {
    private final String domain;
    private final Date publishedOn;
    private final Integer NFTQuantity;
    private final String currency;

    public HostWebsite(String domain, Date publishedOn, Integer NFTQuantity, String currency) {
        this.domain = domain;
        this.publishedOn = publishedOn;
        this.NFTQuantity = NFTQuantity;
        this.currency = currency;
    }

    public String getDomain() {
        return domain;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public Integer getNFTQuantity() {
        return NFTQuantity;
    }

    public String getCurrency() {
        return currency;
    }
}
