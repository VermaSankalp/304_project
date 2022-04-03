CREATE TABLE digital_content (
    token_id varchar(20) NOT NULL,
    creator varchar(20),
    file_format varchar(20),
    PRIMARY KEY (token_id)
);

CREATE TABLE collaterals (
    token_id varchar(20) NOT NULL,
    token_type varchar(20),
    loanee varchar(20),
    loaner varchar(20),
    token_rate int,
    PRIMARY KEY (token_id)
);

CREATE TABLE gaming (
    token_id varchar(20) NOT NULL,
    game_id varchar(20),
    publisher varchar(20),
    PRIMARY KEY (token_id)
);

CREATE TABLE nft_owns (
    token_id varchar(20) NOT NULL,
    token_type varchar(20),
    PRIMARY KEY (token_id)
);

CREATE TABLE people (
    person_id varchar(20) NOT NULL,
    name varchar(20),
    age integer(3),
    PRIMARY KEY (person_id)
);

CREATE TABLE sellers (
    person_id varchar(20) NOT NULL,
    c_address varchar(20),
    nft_quantity integer,
    PRIMARY KEY (person_id),
    UNIQUE (c_address)
);

CREATE TABLE buyers (
    person_id varchar(20) NOT NULL,
    buyer_id varchar(20),
    current_bid decimal(15, 2),
    PRIMARY KEY (person_id),
    UNIQUE (buyer_id)
);

CREATE TABLE sells_to (
    buyer_id varchar(20) NOT NULL,
    c_address varchar(20),
    PRIMARY KEY (buyer_id, c_address),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id),
    FOREIGN KEY (c_address) REFERENCES sellers(c_address)
);

CREATE TABLE host_website (
    domain varchar(20) NOT NULL,
    published_on date,
    nft_quantity integer,
    currency varchar(20),
    PRIMARY KEY (domain)
);

CREATE TABLE lists_on (
    domain varchar(20) NOT NULL,
    c_address varchar(20),
    PRIMARY KEY (domain, c_address),
    FOREIGN KEY (domain) REFERENCES host_website(domain),
    FOREIGN KEY (c_address) REFERENCES sellers(c_address)
);

CREATE TABLE hosted_on (
    domain varchar(20) NOT NULL,
    token_id varchar(20) NOT NULL,
    PRIMARY KEY (domain, token_id),
    FOREIGN KEY (domain) REFERENCES host_website(domain),
    FOREIGN KEY (token_id) REFERENCES nft_owns(token_id)
);

CREATE TABLE bid_on (
    token_id varchar(20) NOT NULL,
    buyer_id varchar(20) NOT NULL,
    PRIMARY KEY (token_id, buyer_id),
    FOREIGN KEY (token_id) REFERENCES nft_owns(token_id),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id)
);

CREATE TABLE buys_from (
    domain varchar(20) NOT NULL,
    buyer_id varchar(20) NOT NULL,
    PRIMARY KEY (domain, buyer_id),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id),
    FOREIGN KEY (domain) REFERENCES host_website(domain)
);

INSERT INTO digital_content VALUES ("ilpoi", "Bill russ", "mp4");
INSERT INTO collaterals VALUES ("cvbnm", "Bank", "ubc", "scotia", 30);
INSERT INTO gaming VALUES ("ixnxe", "00034", "valve");
INSERT INTO sellers VALUES ("18675", "asdfkl", 10);
INSERT INTO sellers VALUES ("22222", "qwerqwer", 5);
INSERT INTO buyers VALUES ("10298", "ascxz", new BigDecimal(30));
INSERT INTO buyers VALUES ("54453", "nftKING", new BigDecimal(25));
INSERT INTO buyers VALUES ("22222", "nft>usd", new BigDecimal(25));
INSERT INTO nft_owns VALUES ("olapo", "x-token");
INSERT INTO nft_owns VALUES ("dogeGIF", "gif");
INSERT INTO people VALUES ("18675", "Rob robson", 43);
INSERT INTO people VALUES ("99999", "Mark Bob", 23);
INSERT INTO host_website VALUES ("www.example.com", "15/2/2020", 10, "bitcoin");
INSERT INTO host_website VALUES ("www.NFTocean.com", "21/7/2019", 8, "usd");
INSERT INTO host_website VALUES ("www.openNFT.com", "18/6/2020", 23, "doge");
INSERT INTO host_website VALUES ("www.freeNFTs.com", "01/2/2021", 3, "bitcoin");
