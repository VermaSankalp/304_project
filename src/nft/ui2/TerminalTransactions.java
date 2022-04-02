package nft.ui2;

import nft.delegates.TerminalTransactionsDelegate;
import nft.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class TerminalTransactions {
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private static final int INVALID_INPUT = Integer.MIN_VALUE;
    private static final int EMPTY_INPUT = 0;

    private BufferedReader bufferedReader = null;
    private TerminalTransactionsDelegate delegate = null;

    public TerminalTransactions() {
    }

    /**
     * Sets up the database to have a branch table with two tuples so we can insert/update/delete from it.
     * Refer to the databaseSetup.sql file to determine what tuples are going to be in the table.
     */
    public void setupDatabase(TerminalTransactionsDelegate delegate) {
        this.delegate = delegate;

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = INVALID_INPUT;

        while(choice != 1 && choice != 2) {
            System.out.println("If you have a table called Digital Content in your database (capitialization of the name does not matter), it will be dropped and a new Digital Content table will be created.\nIf you want to proceed, enter 1; if you want to quit, enter 2.");

            choice = readInteger(false);

            if (choice != INVALID_INPUT) {
                switch (choice) {
                    case 1:
                        delegate.databaseSetup();
                        break;
                    case 2:
                        handleQuitOption();
                        break;
                    default:
                        System.out.println(WARNING_TAG + " The number that you entered was not a valid option.\n");
                        break;
                }
            }
        }
    }

    /**
     * Displays simple text interface
     */
    public void showMainMenu(TerminalTransactionsDelegate delegate) {
        this.delegate = delegate;

        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = INVALID_INPUT;

        while (choice != 0) {
            System.out.println();
            System.out.println("1. Insert Digital Content");
            System.out.println("2. Delete Digital Content");
            System.out.println("3. Update Digital Content");
            System.out.println("4. Show Digital Content");
            System.out.println("5. Insert Collaterals");
            System.out.println("6. Delete Collaterals");
            System.out.println("7. Update Collaterals");
            System.out.println("8. Show Collaterals");
            System.out.println("9. Insert Host Website");
            System.out.println("10. Delete Host Website");
            System.out.println("11. Update Host Website");
            System.out.println("12. Show Host Website");
            System.out.println("13. Insert Gaming");
            System.out.println("14. Delete Gaming");
            System.out.println("15. Update Gaming");
            System.out.println("16. Insert NFT");
            System.out.println("17. Delete NFT");
            System.out.println("18. Update NFT");
            System.out.println("19. Insert People");
            System.out.println("20. Delete People");
            System.out.println("21. Update People");
            System.out.println("22. Insert Sellers");
            System.out.println("23. Delete Sellers");
            System.out.println("24. Update Sellers");
            System.out.println("25. Insert Buyers");
            System.out.println("26. Delete Buyers");
            System.out.println("27. Update Buyers");
            System.out.println("28. Find Buyers with bids > ?");
            System.out.println("29. Find everyone that owns NFTs");
            System.out.println("30. Find the number of buyers");
            System.out.println("31. Find the number of NFTs for each currency");
            System.out.println("32. Find everyone that is a buyer and a seller");
            System.out.println("33. Project Token Type, Loanee and Loaner from Collaterals");
            System.out.println("0. Quit");

            choice = readInteger(false);

            System.out.println(" ");

            if (choice != INVALID_INPUT) {
                switch (choice) {
                    case 1:
                        handleInsertOptionDigitalContent();
                        break;
                    case 2:
                        handleDeleteOptionDigitalContent();
                        break;
                    case 3:
                        handleUpdateOptionDigitalContent();
                        break;
                    case 4:
                        delegate.showDigitalContent();
                        break;
                    case 5:
                        handleInsertOptionCollaterals();
                        break;
                    case 6:
                        handleDeleteOptionCollaterals();
                        break;
                    case 7:
                        handleUpdateOptionCollaterals();
                        break;
                    case 8:
                        delegate.showCollaterals();
                        break;
                    case 9:
                        handleInsertOptionHostWebsite();
                        break;
                    case 10:
                        handleDeleteOptionHostWebsite();
                        break;
                    case 11:
                        handleUpdateOptionHostWebsite();
                        break;
                    case 12:
                        delegate.showHostWebsite();
                        break;
                    case 13:
                        handleInsertOptionGaming();
                        break;
                    case 14:
                        handleDeleteOptionGaming();
                        break;
                    case 15:
                        handleUpdateOptionGaming();
                        break;
                    case 16:
                        handleInsertOptionNft();
                        break;
                    case 17:
                        handleDeleteOptionNft();
                        break;
                    case 18:
                        handleUpdateOptionNft();
                        break;
                    case 19:
                        handleInsertOptionPeople();
                        break;
                    case 20:
                        handleDeleteOptionPeople();
                        break;
                    case 21:
                        handleUpdateOptionPeople();
                        break;
                    case 22:
                        handleInsertOptionSellers();
                        break;
                    case 23:
                        handleDeleteOptionSellers();
                        break;
                    case 24:
                        handleUpdateOptionSellers();
                        break;
                    case 25:
                        handleInsertOptionBuyers();
                        break;
                    case 26:
                        handleDeleteOptionBuyers();
                        break;
                    case 27:
                        handleUpdateOptionBuyers();
                        break;
                    case 28:
                        handleSelection();
                        break;
                    case 29:
                        handleDivision();
                        break;
                    case 30:
                        handleAggregation();
                        break;
                    case 31:
                        handleAggregationWithGroupBy();
                        break;
                    case 32:
                        handleJoin();
                        break;
                    case 33:
                        handleProjection();
                        break;
                    case 0:
                        handleQuitOption();
                        break;
                    default:
                        System.out.println(WARNING_TAG + " The number that you entered was not a valid option.");
                        break;
                }
            }
        }
    }

    private void handleInsertOptionPeople() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to insert: ");
            personId = readLine().trim();
        }

        String name = "";
        while (name == "") {
            System.out.print("Please enter the Person name you wish to insert: ");
            name = readLine().trim();
        }

        int age = INVALID_INPUT;
        while (age == INVALID_INPUT) {
            System.out.print("Please enter the Person age you wish to insert: ");
            age = readInteger(false);
        }

        People model = new People(personId, name, age);
        delegate.insertPeople(model);
    }

    private void handleDeleteOptionPeople() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to delete: ");
            personId = readLine().trim();
            if (personId != "") {
                delegate.deletePeople(personId);
            }
        }
    }

    private void handleUpdateOptionPeople() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to update: ");
            personId = readLine().trim();
        }

        String name = "";
        while (name == "") {
            System.out.print("Please enter the new Person name: ");
            name = readLine().trim();
        }

        int age = INVALID_INPUT;
        while (age == INVALID_INPUT) {
            System.out.print("Please enter the new Person age: ");
            age = readInteger(false);
        }

        delegate.updatePeople(personId, name, age);
    }

    private void handleInsertOptionSellers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Seller ID you wish to insert: ");
            personId = readLine().trim();
        }

        String cAddress = "";
        while (cAddress == "") {
            System.out.print("Please enter the Seller cAddress you wish to insert: ");
            cAddress = readLine().trim();
        }

        int nftQuantity = INVALID_INPUT;
        while (nftQuantity == INVALID_INPUT) {
            System.out.print("Please enter the Seller NFT Quantity you wish to insert: ");
            nftQuantity = readInteger(false);
        }

        Sellers model = new Sellers(personId, cAddress, nftQuantity);
        delegate.insertSellers(model);
    }

    private void handleDeleteOptionSellers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Seller ID you wish to delete: ");
            personId = readLine().trim();
            if (personId != "") {
                delegate.deleteSellers(personId);
            }
        }
    }

    private void handleUpdateOptionSellers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Seller ID you wish to update: ");
            personId = readLine().trim();
        }

        String cAddress = "";
        while (cAddress == "") {
            System.out.print("Please enter the Seller cAddress you wish to update: ");
            cAddress = readLine().trim();
        }

        int nftQuantity = INVALID_INPUT;
        while (nftQuantity == INVALID_INPUT) {
            System.out.print("Please enter the new Seller NFT Quantity: ");
            nftQuantity = readInteger(false);
        }

        delegate.updateSellers(personId, cAddress, nftQuantity);
    }

    private void handleInsertOptionBuyers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to insert: ");
            personId = readLine().trim();
        }

        String buyerId = "";
        while (buyerId == "") {
            System.out.print("Please enter the Buyer ID you wish to insert: ");
            buyerId = readLine().trim();
        }

        BigDecimal currentBid = new BigDecimal(INVALID_INPUT);
        while (currentBid.compareTo(new BigDecimal(INVALID_INPUT)) == 0) {
            System.out.print("Please enter the Buyer current bid you wish to insert: ");
            currentBid = readBigDecimal(false);
        }

        Buyers model = new Buyers(personId, buyerId, currentBid);
        delegate.insertBuyers(model);
    }

    private void handleDeleteOptionBuyers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to delete: ");
            personId = readLine().trim();
            if (personId != "") {
                delegate.deleteBuyers(personId);
            }
        }
    }

    private void handleUpdateOptionBuyers() {
        String personId = "";
        while (personId == "") {
            System.out.print("Please enter the Person ID you wish to update: ");
            personId = readLine().trim();
        }

        String buyerId = "";
        while (buyerId == "") {
            System.out.print("Please enter the Buyer ID you wish to update: ");
            buyerId = readLine().trim();
        }

        BigDecimal currentBid = new BigDecimal(INVALID_INPUT);
        while (currentBid.compareTo(new BigDecimal(INVALID_INPUT)) == 0) {
            System.out.print("Please enter the new Buyer current bid: ");
            currentBid = readBigDecimal(false);
        }

        delegate.updateBuyers(personId, buyerId, currentBid);
    }

    private void handleInsertOptionNft() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the NFT Token ID you wish to insert: ");
            tokenId = readLine().trim();
        }

        String tokenType = "";
        while (tokenType == "") {
            System.out.print("Please enter the NFT Token Type you wish to insert: ");
            tokenType = readLine().trim();
        }

        NFTOwns model = new NFTOwns(tokenId, tokenType);
        delegate.insertNft(model);
    }

    private void handleDeleteOptionNft() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the NFT Token ID you wish to delete: ");
            tokenId = readLine().trim();
            if (tokenId != "") {
                delegate.deleteNft(tokenId);
            }
        }
    }

    private void handleUpdateOptionNft() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the NFT Token ID you wish to update: ");
            tokenId = readLine().trim();
        }

        String tokenType = "";
        while (tokenType == "") {
            System.out.print("Please enter the new NFT Token Type: ");
            tokenType = readLine().trim();
        }

        delegate.updateNft(tokenId, tokenType);
    }

    private void handleInsertOptionGaming() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Gaming Token ID you wish to insert: ");
            tokenId = readLine().trim();
        }

        String gameId = "";
        while (gameId == "") {
            System.out.print("Please enter the Game ID you wish to insert: ");
            gameId = readLine().trim();
        }

        String publisher = "";
        while (publisher == "") {
            System.out.print("Please enter the Publisher you wish to insert: ");
            publisher = readLine().trim();
        }

        Gaming model = new Gaming(tokenId, gameId, publisher);
        delegate.insertGaming(model);
    }

    private void handleDeleteOptionGaming() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Gaming Token ID you wish to delete: ");
            tokenId = readLine().trim();
            if (tokenId != "") {
                delegate.deleteGaming(tokenId);
            }
        }
    }

    private void handleUpdateOptionGaming() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Gaming Token ID you wish to update: ");
            tokenId = readLine().trim();
        }

        String gameId = "";
        while (gameId == "") {
            System.out.print("Please enter the new Game ID: ");
            gameId = readLine().trim();
        }

        String publisher = "";
        while (publisher == "") {
            System.out.print("Please enter the new Publisher: ");
            publisher = readLine().trim();
        }

        delegate.updateGaming(tokenId, gameId, publisher);
    }

    private void handleInsertOptionDigitalContent() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Digital Content ID you wish to insert: ");
            tokenId = readLine().trim();
        }

        String creator = "";
        while (creator == "") {
            System.out.print("Please enter the creator name you wish to insert: ");
            creator = readLine().trim();
        }

        String fileFormat = "";
        while (fileFormat == "") {
            System.out.print("Please enter the file format you wish to insert: ");
            fileFormat = readLine().trim();
        }

        DigitalContent model = new DigitalContent(tokenId, creator, fileFormat);
        delegate.insertDigitalContent(model);
    }

    private void handleDeleteOptionDigitalContent() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Digital Content ID you wish to delete: ");
            tokenId = readLine().trim();
            if (tokenId != "") {
                delegate.deleteDigitalContent(tokenId);
            }
        }
    }

    private void handleUpdateOptionDigitalContent() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the digital content ID you wish to update: ");
            tokenId = readLine().trim();
        }

        String creator = "";
        while (creator == "") {
            System.out.print("Please enter new digital content creator: ");
            creator = readLine().trim();
        }

        String tokenType = "";
        while (tokenType == "") {
            System.out.print("Please enter new digital content token type: ");
            tokenType = readLine().trim();
        }

        delegate.updateDigitalContent(tokenId, creator, tokenType);
    }

    private void handleInsertOptionCollaterals() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Collaterals ID you wish to insert: ");
            tokenId = readLine().trim();
        }

        String tokenType = "";
        while (tokenType == "") {
            System.out.print("Please enter the tokenType name you wish to insert: ");
            tokenType = readLine().trim();
        }

        String loanee = "";
        while (loanee == "") {
            System.out.print("Please enter the loanee name you wish to insert: ");
            loanee = readLine().trim();
        }

        String loaner = "";
        while (loaner == "") {
            System.out.print("Please enter the loaner name you wish to insert: ");
            loaner = readLine().trim();
        }

        int tokenRate = INVALID_INPUT;
        while (tokenRate == INVALID_INPUT) {
            System.out.print("Please enter the token rate you wish to insert: ");
            tokenRate = readInteger(false);
        }

        Collaterals model = new Collaterals(tokenId, tokenType, loanee, loaner, tokenRate);
        delegate.insertCollaterals(model);
    }

    private void handleDeleteOptionCollaterals() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Collaterals ID you wish to delete: ");
            tokenId = readLine().trim();
            if (tokenId != "") {
                delegate.deleteCollaterals(tokenId);
            }
        }
    }

    private void handleUpdateOptionCollaterals() {
        String tokenId = "";
        while (tokenId == "") {
            System.out.print("Please enter the Collaterals ID you wish to update: ");
            tokenId = readLine().trim();
        }

        String tokenType = "";
        while (tokenType == "") {
            System.out.print("Please enter new token type: ");
            tokenType = readLine().trim();
        }

        String loanee = "";
        while (loanee == "") {
            System.out.print("Please enter new loanee: ");
            loanee = readLine().trim();
        }

        String loaner = "";
        while (loaner == "") {
            System.out.print("Please enter new loaner: ");
            loaner = readLine().trim();
        }

        int tokenRate = INVALID_INPUT;
        while (tokenRate == INVALID_INPUT) {
            System.out.print("Please enter the new token rate: ");
            tokenRate = readInteger(false);
        }

        delegate.updateCollaterals(tokenId, tokenType, loanee, loaner, tokenRate);
    }

    private void handleInsertOptionHostWebsite() {
        String domain = "";
        while (domain == "") {
            System.out.println("Please enter the Host Website domain you wish to insert: ");
            domain = readLine().trim();
        }

        String publishedOn = "";
        while (publishedOn == "") {
            System.out.println("Please enter the Host Website publish date you wish to insert: ");
            publishedOn = readLine().trim();
        }

        int nftQuantity = INVALID_INPUT;
        while (nftQuantity == INVALID_INPUT) {
            System.out.println("Please enter the Host Website nft quantity you wish to insert: ");
            nftQuantity = readInteger(false);
        }

        String currency = "";
        while (currency == "") {
            System.out.println("Please enter the Host Website currency you wish to insert: ");
            currency = readLine().trim();
        }

        HostWebsite model = new HostWebsite(domain, publishedOn, nftQuantity, currency);
        delegate.insertHostWebsite(model);
    }

    private void handleDeleteOptionHostWebsite() {
        String domain = "";
        while (domain == "") {
            System.out.print("Please enter the Host Website domain you wish to delete: ");
            domain = readLine().trim();
            if (domain != "") {
                delegate.deleteHostWebsite(domain);
            }
        }
    }

    private void handleUpdateOptionHostWebsite() {
        String domain = "";
        while (domain == "") {
            System.out.println("Please enter the Host Website domain you wish to update: ");
            domain = readLine().trim();
        }

        String publishedOn = "";
        while (publishedOn == "") {
            System.out.println("Please enter the new published on date: ");
            publishedOn = readLine().trim();
        }

        int nftQuantity = INVALID_INPUT;
        while (nftQuantity == INVALID_INPUT) {
            System.out.println("Please enter the new nft quantity: ");
            nftQuantity = readInteger(false);
        }

        String currency = "";
        while (currency == "") {
            System.out.println("Please enter the new currency: ");
            currency = readLine().trim();
        }

        delegate.updateHostWebsite(domain, publishedOn, nftQuantity, currency);
    }

    private void handleProjection() {
        delegate.projection();
    }

    private void handleSelection() {
        BigDecimal bid = null;
        while (bid  == null) {
            System.out.println("Find buyers with bids greater than: ");
            bid = readBigDecimal(false);
        }

        delegate.selection(bid);
    }

    private void handleDivision() {
        delegate.division();
    }

    private void handleAggregation() {
        delegate.aggregation();
    }

    private void handleAggregationWithGroupBy() {delegate.aggregationWithGroupBy();}

    private void handleJoin() {delegate.join();}

    private void handleQuitOption() {
        System.out.println("Good Bye!");

        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("IOException!");
            }
        }

        delegate.terminalTransactionsFinished();
    }

    private int readInteger(boolean allowEmpty) {
        String line = null;
        int input = INVALID_INPUT;
        try {
            line = bufferedReader.readLine();
            input = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        } catch (NumberFormatException e) {
            if (allowEmpty && line.length() == 0) {
                input = EMPTY_INPUT;
            } else {
                System.out.println(WARNING_TAG + " Your input was not an integer");
            }
        }
        return input;
    }

    private BigDecimal readBigDecimal(boolean allowEmpty) {
        String line = null;
        BigDecimal input = new BigDecimal(-1);
        try {
            line = bufferedReader.readLine();
            input = new BigDecimal(line);
        } catch (IOException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        } catch (NumberFormatException e) {
            if (allowEmpty && Objects.requireNonNull(line).length() == 0) {
                input = new BigDecimal(-1);
            } else {
                System.out.println(WARNING_TAG + " Your input was not correct");
            }
        }
        return input;
    }

    private String readLine() {
        String result = null;
        try {
            result = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
        return result;
    }
}

