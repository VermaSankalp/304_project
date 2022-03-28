package nft.model;

/**
 * The intent for this class is to update/store information about digital content
 */
public class DigitalContent {
	private final String tokenID;
	private final String creator;
	private final String fileFormat;
	
	public DigitalContent(String tokenID, String creator, String fileFormat) {
		this.tokenID = tokenID;
		this.creator = creator;
		this.fileFormat = fileFormat;
	}

	public String getTokenID() {
		return tokenID;
	}

	public String getCreator() {
		return creator;
	}

	public String getFileFormat() {
		return fileFormat;
	}
}
