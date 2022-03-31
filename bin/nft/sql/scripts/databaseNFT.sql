-- drop table digital_content cascade constraints;
-- drop table collaterals cascade constraints;
-- drop table gaming cascade constraints;
-- drop table nft_owns cascade constraints;
-- drop table people cascade constraints;
-- drop table sellers cascade constraints;
-- drop table buyers cascade constraints;
-- drop table sells_to cascade constraints;
-- drop table host_website cascade constraints;
-- drop table lists_on cascade constraints;
-- drop table hosted_on cascade constraints;
-- drop table bid_on cascade constraints;
-- drop table buys_from cascade constraints;

CREATE TABLE digital_content (
    token_id varchar(20) NOT NULL,
    creator varchar(20),
    file_format varchar(20),
    PRIMARY KEY (token_id)
);

CREATE TABLE collaterals (
    token_id_c varchar(20) NOT NULL,
    tokenType varchar(20),
    loanee varchar(20),
    loaner varchar(20),
    token_rate decimal(10, 2),
    PRIMARY KEY (token_id)
);

grant select, insert, update, delete on collaterals to user2;

CREATE TABLE gaming (
    token_id varchar(20) NOT NULL,
    game_id varchar(20),
    publisher varchar(20),
    PRIMARY KEY (token_id)
);

CREATE TABLE nft_owns (
    token_id varchar(20) NOT NULL,
    person_id varchar(20) NOT NULL,
    token_type varchar(20),
    PRIMARY KEY (token_id),
    FOREIGN KEY (person_id) REFERENCES sellers(person_id)
)

CREATE TABLE people (
    person_id varchar(20) NOT NULL,
    name varchar(20),
    age integer(3),
    PRIMARY KEY (person_id)
)

CREATE TABLE sellers (
    person_id varchar(20) NOT NULL,
    c_address varchar(20),
    nft_quantity integer,
    PRIMARY KEY (person_id),
    UNIQUE (c_address)
)

CREATE TABLE buyers (
    person_id varchar(20) NOT NULL,
    buyer_id varchar(20),
    current_bid decimal(15, 2),
    PRIMARY KEY (person_id),
    UNIQUE (buyer_id)
)

CREATE TABLE sells_to (
    buyer_id varchar(20) NOT NULL,
    c_address varchar(20),
    PRIMARY KEY (buyer_id, c_address),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id),
    FOREIGN KEY (c_address) REFERENCES sellers(c_address)
)

CREATE TABLE host_website (
    domain varchar(20) NOT NULL,
    published_on date,
    nft_quantity integer,
    currency varchar(20),
    PRIMARY KEY (domain)
)

CREATE TABLE lists_on (
    domain varchar(20) NOT NULL,
    c_address varchar(20),
    PRIMARY KEY (domain, c_address),
    FOREIGN KEY (domain) REFERENCES host_website(domain),
    FOREIGN KEY (c_address) REFERENCES sellers(c_address)
)

CREATE TABLE hosted_on (
    domain varchar(20) NOT NULL,
    token_id varchar(20) NOT NULL,
    PRIMARY KEY (domain, token_id),
    FOREIGN KEY (domain) REFERENCES host_website(domain),
    FOREIGN KEY (token_id) REFERENCES nft_owns(token_id)
)

CREATE TABLE bid_on (
    token_id varchar(20) NOT NULL,
    buyer_id varchar(20) NOT NULL,
    PRIMARY KEY (token_id, buyer_id),
    FOREIGN KEY (token_id) REFERENCES nft_owns(token_id),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id)
)

CREATE TABLE buys_from (
    domain varchar(20) NOT NULL,
    buyer_id varchar(20) NOT NULL,
    PRIMARY KEY (domain, buyer_id),
    FOREIGN KEY (buyer_id) REFERENCES buyers(buyer_id),
    FOREIGN KEY (domain) REFERENCES host_website(domain)
)

grant select, insert, update, delete on customer to user2;


INSERT INTO nft_owns VALUES ("12344556", "123412", "ETH");
INSERT INTO nft_owns VALUES ("12344556", "12222", "doge");
