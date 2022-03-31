package nft.ui;

import java.math.BigDecimal;
import java.util.ArrayList;

import nft.database.DatabaseConnectionHandler;
import nft.model.Buyers;
import nft.model.NFTOwns;

public class test {
    DatabaseConnectionHandler dHandler = new DatabaseConnectionHandler();
    ArrayList<String> strings = new ArrayList<>();

    public test() {
        NFTOwns newBuyer = new NFTOwns("12345", "54312", "ETH");
        dHandler.insertNftOwns(newBuyer);
        strings.add("token_id");
        String returned = dHandler.projection("buyers", strings);
        System.out.println(returned);
    }
    

    public static void main(String[] args) {
        new test();
    }
}
