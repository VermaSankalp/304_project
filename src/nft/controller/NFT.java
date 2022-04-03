 package nft.controller;

 import nft.database.DatabaseConnectionHandler;
 import nft.delegates.LoginWindowDelegate;
 import nft.delegates.TerminalTransactionsDelegate;
 import nft.model.*;
 import nft.ui2.LoginWindow;
 import nft.ui2.TerminalTransactions;

 import java.math.BigDecimal;

 /**
  * This is the main controller class that will orchestrate everything.
  */
 public class NFT implements LoginWindowDelegate, TerminalTransactionsDelegate {
 	private DatabaseConnectionHandler dbHandler = null;
 	private LoginWindow loginWindow = null;

 	public NFT() {
 		dbHandler = new DatabaseConnectionHandler();
 	}
	
 	private void start() {
 		loginWindow = new LoginWindow();
 		loginWindow.showFrame(this);
 	}
	
 	/**
 	 * LoginWindowDelegate Implementation
 	 *
      * connects to Oracle database with supplied username and password
      */
 	public void login(String username, String password) {
 		boolean didConnect = dbHandler.login(username, password);

 		if (didConnect) {
 			// Once connected, remove login window and start text transaction flow
 			loginWindow.dispose();

 			TerminalTransactions transaction = new TerminalTransactions();
 			transaction.setupDatabase(this);
 			transaction.showMainMenu(this);
 		} else {
 			loginWindow.handleLoginFailed();

 			if (loginWindow.hasReachedMaxLoginAttempts()) {
 				loginWindow.dispose();
 				System.out.println("You have exceeded your number of allowed attempts");
 				System.exit(-1);
 			}
 		}
 	}
	
 	/**
 	 * TerminalTransactionsDelegate Implementation
 	 *
 	 * Insert a branch with the given info
 	 */
     public void insertDigitalContent(DigitalContent model) {
     	dbHandler.insertDigitalContent(model);
     }

     /**
 	 * TermainalTransactionsDelegate Implementation
 	 *
 	 * Delete branch with given branch ID.
 	 */
     public void deleteDigitalContent(String tokenID) {
     	dbHandler.deleteDigitalContent(tokenID);
     }
    
     /**
 	 * TermainalTransactionsDelegate Implementation
 	 *
 	 * Update the branch name for a specific ID
 	 */

     public void updateDigitalContent(String tokenId, String name, String fileFormat) {
     	dbHandler.updateDigitalContent(tokenId, name, fileFormat);
     }

	 /**
 	 * TermainalTransactionsDelegate Implementation
 	 *
 	 * Displays information about varies bank branches.
 	 */
     public void showDigitalContent() {
     	DigitalContent[] models = dbHandler.getDigitalContentInfo();
    	
     	for (int i = 0; i < models.length; i++) {
     		DigitalContent model = models[i];
    		
     		// simplified output formatting; truncation may occur
     		System.out.printf("%-10.10s", model.getTokenID());
     		System.out.printf("%-20.20s", model.getCreator());
			System.out.printf("%-30.30s", model.getFileFormat());
    		
     		System.out.println();
     	}
     }

	 public void deleteCollaterals(String tokenID) {
		 dbHandler.deleteCollaterals(tokenID);
	 }

	 public void insertCollaterals(Collaterals model) {
		 dbHandler.insertCollaterals(model);
	 }

	 public void showCollaterals() {
		 Collaterals[] models = dbHandler.getCollateralsInfo();

		 for (int i = 0; i < models.length; i++) {
			 Collaterals model = models[i];

			 // simplified output formatting; truncation may occur
			 System.out.printf("%-10.10s", model.getTokenID());
			 System.out.printf("%-20.20s", model.getTokenType());
			 System.out.printf("%-30.30s", model.getLoanee());
			 System.out.printf("%-40.40s", model.getLoaner());
			 System.out.printf("%-50.50s", model.getTokenRate());

			 System.out.println();
		 }
	 }

	 public void updateCollaterals(String tokenId, String tokenType, String loanee, String loaner, int tokenRate) {
		 dbHandler.updateCollaterals(tokenId, tokenType, loanee, loaner, tokenRate);
	 }

	 public void insertHostWebsite(HostWebsite model) {
		 dbHandler.insertHostWebsite(model);
	 }
	 public void deleteHostWebsite(String domain) {dbHandler.deleteHostWebsite(domain);}
	 public void updateHostWebsite(String domain, String publishedOn, int nftQuantity, String currency) {
		 dbHandler.updateHostWebsite(domain, publishedOn, nftQuantity, currency);
	 }
	 public void showHostWebsite() {
		 HostWebsite[] models = dbHandler.getHostWebsiteInfo();

		 for (int i = 0; i < models.length; i++) {
			 HostWebsite model = models[i];

			 // simplified output formatting; truncation may occur
			 System.out.printf("%-10.10s", model.getDomain());
			 System.out.printf("%-20.20s", model.getPublishedOn());
			 System.out.printf("%-30.30s", model.getNFTQuantity());
			 System.out.printf("%-40.40s", model.getCurrency());

			 System.out.println();
		 }
	 }

	 public void insertGaming(Gaming model) {dbHandler.insertGaming(model);}
	 public void deleteGaming(String tokenId) {dbHandler.deleteGaming(tokenId);}
	 public void updateGaming(String tokenId, String gameId, String publisher) {
		 dbHandler.updateGaming(tokenId, gameId, publisher);
	 }

	 public void insertNft(NFTOwns model) {dbHandler.insertNftOwns(model);}
	 public void deleteNft(String tokenId) {dbHandler.deleteNFTOwns(tokenId);}
	 public void updateNft(String tokenId, String personId, String tokenType) {
		 dbHandler.updateNFTOwns(tokenId, personId, tokenType);
	 }

	 public void insertPeople(People model) { dbHandler.insertPeople(model); }
	 public void deletePeople(String personId) {dbHandler.deletePeople(personId);}
	 public void updatePeople(String personId, String name, int age) {
		 dbHandler.updatePeople(personId, name, age);
	 }

	 public void insertSellers(Sellers model) {dbHandler.insertSellers(model);}
	 public void deleteSellers(String personId) {dbHandler.deleteSellers(personId);}
	 public void updateSellers(String personId, String cAddress, int nftQuantity) {
		 dbHandler.updateSellers(personId, cAddress, nftQuantity);
	 }

	 public void insertBuyers(Buyers model) {dbHandler.insertBuyers(model);}
	 public void deleteBuyers(String personId) {dbHandler.deleteBuyers(personId);}
	 public void updateBuyers(String personId, String buyerId, BigDecimal currentBid) {
		 dbHandler.updateBuyers(personId, buyerId, currentBid);
	 }

	 public void selection(BigDecimal bid) {
		 dbHandler.selectionBuyersWithBidsGreaterThan(bid);
	 }

	 public void projection() {dbHandler.projection();}

	 public void division() {dbHandler.divisionAllNFTOwners();};

	 public void aggregation() {dbHandler.aggregation();}

	 public void aggregationWithGroupBy() {dbHandler.aggregationWithGroupBy();}

	 public void join() {dbHandler.join();}

	 /**
 	 * TerminalTransactionsDelegate Implementation
 	 *
      * The TerminalTransaction instance tells us that it is done with what it's
      * doing so we are cleaning up the connection since it's no longer needed.
      */
     public void terminalTransactionsFinished() {
     	dbHandler.close();
     	dbHandler = null;
    	
     	System.exit(0);
     }
    
     /**
 	 * TerminalTransactionsDelegate Implementation
 	 *
      * The TerminalTransaction instance tells us that the user is fine with dropping any existing table
      * called branch and creating a new one for this project to use
      */
 	public void databaseSetup() {
 		dbHandler.databaseSetup();;
 	}

 	/**
 	 * Main method called at launch time
 	 */
 	public static void main(String args[]) {
 		NFT NFT = new NFT();
 		NFT.start();
 	}
 }
