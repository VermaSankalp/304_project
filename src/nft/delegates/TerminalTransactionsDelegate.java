package nft.delegates;

import nft.model.*;

import java.math.BigDecimal;

/**
 * This interface uses the delegation design pattern where instead of having
 * the TerminalTransactions class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case Bank).
 * 
 * TerminalTransactions calls the methods that we have listed below but 
 * Bank is the actual class that will implement the methods.
 */
public interface TerminalTransactionsDelegate {
	public void databaseSetup();
	
	public void deleteDigitalContent(String tokenID);
	public void insertDigitalContent(DigitalContent model);
	public void showDigitalContent();
	public void updateDigitalContent(String tokenId, String name, String fileFormat);

	public void deleteCollaterals(String tokenID);
	public void insertCollaterals(Collaterals model);
	public void showCollaterals();
	public void updateCollaterals(String tokenId, String tokenType, String loanee, String loaner, int tokenRate);

	public void insertHostWebsite(HostWebsite model);
	public void deleteHostWebsite(String domain);
	public void showHostWebsite();
	public void updateHostWebsite(String domain, String publishedOn, int nftQuantity, String currency);

	public void insertGaming(Gaming model);
	public void deleteGaming(String tokenId);
	public void updateGaming(String tokenId, String gameId, String publisher);

	public void insertNft(NFTOwns model);
	public void deleteNft(String tokenId);
	public void updateNft(String tokenId, String tokenType);

	public void insertPeople(People model);
	public void deletePeople(String personId);
	public void updatePeople(String personId, String name, int age);

	public void insertSellers(Sellers model);
	public void deleteSellers(String personId);
	public void updateSellers(String personId, String cAddress, int nftQuantity);

	public void insertBuyers(Buyers model);
	public void deleteBuyers(String personId);
	public void updateBuyers(String personId, String buyerId, BigDecimal currentBid);

	public void selection(BigDecimal bid);
	public void projection();
	public void division();
	public void aggregation();
	public void aggregationWithGroupBy();
	public void join();

	public void terminalTransactionsFinished();
}
