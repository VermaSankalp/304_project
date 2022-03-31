 package nft.controller;

 import nft.database.DatabaseConnectionHandler;
 import nft.delegates.LoginWindowDelegate;
 import nft.delegates.TerminalTransactionsDelegate;
 import nft.model.DigitalContent;
 import nft.ui2.LoginWindow;
 import nft.ui2.TerminalTransactions;

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
//     		if (model.getAddress() == null) {
//     			System.out.printf("%-20.20s", " ");
//     		} else {
//     			System.out.printf("%-20.20s", model.getAddress());
//     		}
//     		System.out.printf("%-15.15s", model.getCity());
//     		if (model.getPhoneNumber() == 0) {
//     			System.out.printf("%-15.15s", " ");
//     		} else {
//     			System.out.printf("%-15.15s", model.getPhoneNumber());
//     		}
    		
     		System.out.println();
     	}
     }



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
