package nft.delegates;

import nft.model.Collaterals;
import nft.model.DigitalContent;
import nft.model.HostWebsite;

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
	public void updateHostWebsite(String domain, String publishedOn, int nftQuantity, String currency);

	public void selection(BigDecimal bid);

	public void terminalTransactionsFinished();
}
