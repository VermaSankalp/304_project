package nft.database;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import nft.model.*;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
	// Use this version of the ORACLE_URL if you are running the code off of the server
	// private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
	// Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	
	private Connection connection = null;
	
	public DatabaseConnectionHandler() {

		try {

			// Load the Oracle JDBC driver
			// Note that the path could change for new drivers
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//			this.connection = DriverManager.getConnection(ORACLE_URL, "ora_brendons", "a87271490");
//			ScriptRunner sr = new ScriptRunner(connection, false, true);
//			Reader reader = new BufferedReader(new FileReader("src/nft/sql/scripts/databaseNFT.sql"));
//			sr.runScript(reader);
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

//	public void deleteBranch(int branchId) {
//		try {
//			PreparedStatement ps = connection.prepareStatement("DELETE FROM branch WHERE branch_id = ?");
//			ps.setInt(1, branchId);
//
//			int rowCount = ps.executeUpdate();
//			if (rowCount == 0) {
//				System.out.println(WARNING_TAG + " Branch " + branchId + " does not exist!");
//			}
//
//			connection.commit();
//
//			ps.close();
//		} catch (SQLException e) {
//			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
//			rollbackConnection();
//		}
//	}
	
	public void insertHostWebsite(HostWebsite model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO host_website VALUES (?,?,?,?)");
			ps.setString(1, model.getDomain());
			ps.setString(2, model.getPublishedOn());
			ps.setInt(3, model.getNFTQuantity());
			ps.setString(4, model.getCurrency());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteHostWebsite(String domain) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM host_website WHERE domain = ?");
			ps.setString(1, domain);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + domain + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertPeople(People model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO people VALUES (?,?,?)");
			ps.setString(1, model.getPersonID());
			ps.setString(2, model.getName());
			ps.setInt(3, model.getAge());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deletePeople(String personID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM people WHERE person_id = ?");
			ps.setString(1, personID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + personID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertBuyers(Buyers model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO buyers VALUES (?,?,?)");
			ps.setString(1, model.getPersonID());
			ps.setString(2, model.getBuyerID());
			ps.setBigDecimal(3, model.getCurrentBid());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteBuyers(String personID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM buyers WHERE person_id = ?");
			ps.setString(1, personID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + personID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertSellers(Sellers model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO sellers VALUES (?,?,?)");
			ps.setString(1, model.getPersonID());
			ps.setString(2, model.getCAddress());
			ps.setBigDecimal(3, model.getCurrentBid());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteSellers(String personID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM sellers WHERE person_id = ?");
			ps.setString(1, personID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + personID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertNftOwns(NFTOwns model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO nft_owns VALUES (?,?,?)");
			ps.setString(1, model.getTokenID());
			ps.setString(2, model.getPersonID());
			ps.setString(3, model.getTokenType());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteNFTOwns(String tokenID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM buyers WHERE token_id = ?");
			ps.setString(1, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + tokenID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertDigitalContent(DigitalContent model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO digital_content VALUES (?,?,?)");
			ps.setString(1, model.getTokenID());
			ps.setString(2, model.getCreator());
			ps.setString(3, model.getFileFormat());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteDigitalContent(String tokenID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM digital_content WHERE token_id = ?");
			ps.setString(1, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + tokenID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertCollaterals(Collaterals model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO collaterals VALUES (?,?,?,?,?)");
			ps.setString(1, model.getTokenID());
			ps.setString(2, model.getTokenType());
			ps.setString(3, model.getLoanee());
			ps.setString(4, model.getLoaner());
			ps.setInt(5, model.getTokenRate());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteCollaterals(String tokenID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM collaterals WHERE token_id = ?");
			ps.setString(1, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + tokenID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void insertGaming(Gaming model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO gaming VALUES (?,?,?)");
			ps.setString(1, model.getTokenID());
			ps.setString(2, model.getGameID());
			ps.setString(3, model.getPublisher());

			ps.executeUpdate();
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void deleteGaming(String tokenID) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM buyers WHERE domain = ?");
			ps.setString(1, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + tokenID + " does not exist!");
			}

			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	// find buyers with current bids > ?
	public Buyers[] selectionBuyersWithBidsGreaterThan(BigDecimal bid) {
		ArrayList<Buyers> result = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM buyers WHERE current_bid > ?");
			ps.setBigDecimal(1, bid);

			ps.execute();

			ResultSet queryResult = ps.getResultSet();
			String personID;
			String buyerID;
			BigDecimal currentBid;
			int i = 1;
			while (queryResult.next()) {
				personID = queryResult.getString(1);
				buyerID = queryResult.getString(2);
				currentBid = queryResult.getBigDecimal(3);
				result.add(new Buyers(personID, buyerID, currentBid));
				System.out.println(i + ": " + buyerID);
				i++;
			}

			ps.close();
			queryResult.close();

		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		return result.toArray(new Buyers[0]);
	}

	// find everyone that own NFTs
	public People[] divisionAllNFTOwners() {
		ArrayList<People> result = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM people p WHERE NOT EXISTS (SELECT o.person_id FROM nft_owns o WHERE o.person_id <> p.person_id)");
			ps.execute();
			ResultSet queryResult = ps.getResultSet();

			String personID;
			String name;
			int age;
			int i = 1;
			while (queryResult.next()) {
				personID = queryResult.getString(1);
				name = queryResult.getString(2);
				age = queryResult.getInt(3);
				result.add(new People(personID, name, age));
				System.out.println(i + ": " + name);
				i++;
			}

		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		return result.toArray(new People[0]);
	}
	
	public String projection(String table, ArrayList<String> attributes) {
		String finalResult = null;
		try {
			StringBuilder result = new StringBuilder(10000);
			int tupleCount = 1;

			PreparedStatement ps = connection.prepareStatement("SELECT ? FROM ?");
			ps.setArray(1, (Array) attributes);
			ps.setString(2, table);

			ps.execute();
			ResultSet queryResult = ps.getResultSet();

			while (queryResult.next()) {
				result.append(tupleCount).append(") ");
				for (String attribute : attributes) {
					result.append(attribute).append("= ").append(queryResult.getString(attribute)).append(" ");
				}
				result.append("\n");
				++tupleCount;
			}

			connection.commit();
			ps.close();
			queryResult.close();

			finalResult = result.toString();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		return finalResult;
	}

	public String aggregation() {
		String finalResult = null;
		try {
			StringBuilder result = new StringBuilder(10000);

			Statement stmt = connection.createStatement();
			ResultSet queryResult = stmt.executeQuery("SELECT COUNT(*) FROM buyers");

			while (queryResult.next()) {
				result.append(queryResult.getInt(1));
			}

			stmt.close();
			queryResult.close();

			finalResult = result.toString();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		System.out.println("Number of buyers: " + finalResult);
		return finalResult;
	}

	public String aggregationWithGroupBy() {
		String finalResult = null;
		try {
			StringBuilder result = new StringBuilder(10000);
			int tupleCount = 1;

			Statement stmt = connection.createStatement();
			ResultSet queryResult = stmt.executeQuery("SELECT currency, AVG(nft_quantity) FROM host_website GROUP BY currency");

			while (queryResult.next()) {
				result.append(tupleCount).append(") ");
				result.append("Currency: ").append(queryResult.getString(1));
				result.append(", ");
				result.append("Average number of NFTs: ").append(queryResult.getString(2));
				result.append("\n");
				++tupleCount;
			}

			stmt.close();
			queryResult.close();

			finalResult = result.toString();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		System.out.println(finalResult);
		return finalResult;
	}
	
	//Join the sellers and buyers
	public String join() {
		String finalResult = null;
		try {
			StringBuilder result = new StringBuilder(10000);
			int tupleCount = 1;

			Statement stmt = connection.createStatement();
			ResultSet queryResult = stmt.executeQuery("SELECT * FROM sellers S, buyers B WHERE S.person_id = B.person_id");

			while (queryResult.next()) {
				result.append(tupleCount).append(") ");
				result.append("Person_id: ").append(queryResult.getString("person_id"));
				result.append(", ");
				result.append("c_address: ").append(queryResult.getString("c_address"));
				result.append(", ");
				result.append("nft_quantity: ").append(queryResult.getString("nft_quantity"));
				result.append(", ");
				result.append("buyer_id: ").append(queryResult.getString("buyer_id"));
				result.append(", ");
				result.append("current_bid: ").append(queryResult.getString("current_bid"));
				result.append("\n");
				++tupleCount;
			}

			stmt.close();
			queryResult.close();

			finalResult = result.toString();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
		System.out.println(finalResult);
		return finalResult;
	}

	public void updateHostWebsite(String domain, String publishedDate, int nftQuantity, String currency) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE host_website SET published_on = ?, nft_quantity = ?, currency = ? WHERE domain = ?");
			ps.setString(1, publishedDate);
			ps.setInt(2, nftQuantity);
			ps.setString(3, currency);
			ps.setString(4, domain);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Host website " + domain + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updatePeople(String peopleId, String name, int age) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE people SET name = ?, age = ? WHERE person_id = ?");
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, peopleId);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Person " + peopleId + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateSellers(String personId, String cAddress, int nftQuantity) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE sellers SET nft_quantity = ? WHERE person_id = ? AND c_address = ?");
			ps.setInt(1, nftQuantity);
			ps.setString(2, personId);
			ps.setString(3, cAddress);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Seller " + personId + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateBuyers(String personId, String buyerId, BigDecimal currentBid) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE buyers SET current_bid = ? WHERE person_id = ? AND buyer_id = ?");
			ps.setBigDecimal(1, currentBid);
			ps.setString(2, personId);
			ps.setString(3, buyerId);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Buyer " + buyerId + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateNFTOwns(String tokenID, String personID, String tokenType) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE nft_owns SET token_id = ?, token_type = ? WHERE person_id = ?");
			ps.setString(1, tokenID);
			ps.setString(2, tokenType);
			ps.setString(3, personID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Person " + personID + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateCollaterals(String tokenID, String token_type, String loanee, String loaner, int tokenRate) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE collaterals SET loanee = ?, loaner = ?, token_type = ?, token_rate = ? WHERE token_id = ?");
			ps.setString(1, loanee);
			ps.setString(2, loaner);
			ps.setString(3, token_type);
			ps.setInt(4, tokenRate);
			ps.setString(5, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Collateral " + tokenID + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public void updateDigitalContent(String tokenID, String creator, String fileFormat) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE digital_content SET creator = ?, file_format = ? WHERE token_id = ?");
			ps.setString(1, creator);
			ps.setString(2, fileFormat);
			ps.setString(3, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Digital Content " + tokenID + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}
	public void updateGaming(String tokenID, String gameID, String publisher) {
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE gaming SET game_id = ?, publisher = ? WHERE token_id = ?");
			ps.setString(1, gameID);
			ps.setString(2, publisher);
			ps.setString(3, tokenID);

			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Gaming " + tokenID + " does not exist!");
			}
			connection.commit();

			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}

	public DigitalContent[] getDigitalContentInfo() {
		ArrayList<DigitalContent> result = new ArrayList<>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM digital_content");

			while(rs.next()) {
				DigitalContent model = new DigitalContent(rs.getString("token_id"),
						rs.getString("creator"),
						rs.getString("file_format"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}

		return result.toArray(new DigitalContent[result.size()]);
	}

	public Collaterals[] getCollateralsInfo() {
		ArrayList<Collaterals> result = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM collaterals");

			while(rs.next()) {
				Collaterals model = new Collaterals(rs.getString("token_id"),
						rs.getString("token_type"),
						rs.getString("loanee"),
						rs.getString("loaner"),
						rs.getInt("token_rate"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}

		return result.toArray(new Collaterals[result.size()]);
	}

	public HostWebsite[] getHostWebsiteInfo() {
		ArrayList<HostWebsite> result = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM host_website");

			while(rs.next()) {
				HostWebsite model = new HostWebsite(rs.getString("domain"),
						rs.getString("published_on"),
						rs.getInt("nft_quantity"),
						rs.getString("currency"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}

		return result.toArray(new HostWebsite[result.size()]);
	}
	
	public boolean login(String username, String password) {
		try {
			if (connection != null) {
				connection.close();
			}
	
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);
	
			System.out.println("\nConnected to Oracle!");
			return true;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return false;
		}
	}

	private void rollbackConnection() {
		try  {
			connection.rollback();	
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
	
	public void databaseSetup() {
		dropTableIfExists();

		createTableDigitalContent();
		createTableCollaterals();
		createTableGaming();
		createTableSellers();
		createTableBuyers();
		createTableNftOwns();
		createTablePeople();
		createTableHostWebsite();

	}

	public void createTableDigitalContent() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE digital_content (token_id varchar(20) NOT NULL, creator varchar(20), file_format varchar(20), PRIMARY KEY (token_id))");

			DigitalContent digitalContent1 = new DigitalContent("ilpoi", "Bill russ", "mp4");
			insertDigitalContent(digitalContent1);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableCollaterals() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE collaterals (token_id varchar(20) NOT NULL, token_type varchar(20), loanee varchar(20), loaner varchar(20), token_rate int, PRIMARY KEY (token_id))");

			Collaterals collateral1 = new Collaterals("cvbnm", "Bank", "ubc", "scotia", 30);
			insertCollaterals(collateral1);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableGaming() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE gaming (token_id varchar(20) NOT NULL, game_id varchar(20), publisher varchar(20), PRIMARY KEY (token_id))");

			Gaming gameItem1 = new Gaming("ixnxe", "00034", "valve");
			insertGaming(gameItem1);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableSellers() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE sellers (person_id varchar(20) NOT NULL, c_address varchar(20), nft_quantity integer, PRIMARY KEY (person_id), UNIQUE (c_address))");

			Sellers seller1 = new Sellers("18675", "asdfkl", new BigDecimal(10));
			insertSellers(seller1);
			Sellers seller2 = new Sellers("22222", "qwerqwer", new BigDecimal(5));
			insertSellers(seller2);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableBuyers() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE buyers (person_id varchar(20) NOT NULL, buyer_id varchar(20), current_bid decimal(15, 2), PRIMARY KEY (person_id), UNIQUE (buyer_id))");

			Buyers buyer1 = new Buyers("10298", "ascxz", new BigDecimal(30));
			insertBuyers(buyer1);
			Buyers buyer2 = new Buyers("54453", "nftKING", new BigDecimal(25));
			insertBuyers(buyer2);
			Buyers buyer3 = new Buyers("22222", "nft>usd", new BigDecimal(25));
			insertBuyers(buyer3);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableNftOwns() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE nft_owns (token_id varchar(20) NOT NULL, person_id varchar(20) NOT NULL, token_type varchar(20), PRIMARY KEY (token_id), FOREIGN KEY (person_id) REFERENCES sellers(person_id))");
			NFTOwns nft1 = new NFTOwns("olapo", "18675", "x-token");
			insertNftOwns(nft1);
			NFTOwns nft2 = new NFTOwns("dogeGIF", "22222", "gif");
			insertNftOwns(nft2);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTablePeople() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE people (person_id varchar(20) NOT NULL, name varchar(20), age integer, PRIMARY KEY (person_id))");

			People person1 = new People("18675", "Rob robson", 43);
			insertPeople(person1);
			People person2 = new People("99999", "Mark Bob", 23);
			insertPeople(person2);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void createTableHostWebsite() {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE host_website (domain varchar(20) NOT NULL, published_on varchar(20), nft_quantity integer, currency varchar(20), PRIMARY KEY (domain))");

			HostWebsite website1 = new HostWebsite("www.example.com", "15/2/2020", 10, "bitcoin");
			insertHostWebsite(website1);
			HostWebsite website2 = new HostWebsite("www.NFTocean.com", "21/7/2019", 8, "usd");
			insertHostWebsite(website2);
			HostWebsite website3 = new HostWebsite("www.openNFT.com", "18/6/2020", 23, "doge");
			insertHostWebsite(website3);
			HostWebsite website4 = new HostWebsite("www.freeNFTs.com", "01/2/2021", 3, "bitcoin");
			insertHostWebsite(website4);

			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropTableIfExists() {
		dropDigitalContentTableIfExists();
		dropCollateralsTableIfExists();
		dropGamingTableIfExists();
		dropNFTOwnsTableIfExists();
		dropPeopleTableIfExists();
		dropSellersTableIfExists();
		dropBuyersTableIfExists();
		dropSellsToTableIfExists();
		dropHostWebsiteTableIfExists();
		dropListsOnTableIfExists();
		dropHostedOnTableIfExists();
		dropBidOnTableIfExists();
		dropBuysFromTableIfExists();
	}
	
	private void dropDigitalContentTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("digital_content")) {
					stmt.execute("DROP TABLE digital_content");
					break;
				}
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropCollateralsTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("collaterals")) {
					stmt.execute("DROP TABLE collaterals");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropGamingTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("gaming")) {
					stmt.execute("DROP TABLE gaming");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropNFTOwnsTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("nft_owns")) {
					stmt.execute("DROP TABLE nft_owns");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropPeopleTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("people")) {
					stmt.execute("DROP TABLE people");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropSellersTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("sellers")) {
					stmt.execute("DROP TABLE sellers");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropBuyersTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("buyers")) {
					stmt.execute("DROP TABLE buyers");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropSellsToTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("sells_to")) {
					stmt.execute("DROP TABLE sells_to");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropHostWebsiteTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("host_website")) {
					stmt.execute("DROP TABLE host_website");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropListsOnTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("lists_on")) {
					stmt.execute("DROP TABLE lists_on");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropHostedOnTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("hosted_on")) {
					stmt.execute("DROP TABLE hosted_on");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropBidOnTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("bid_on")) {
					stmt.execute("DROP TABLE bid_on");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	private void dropBuysFromTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");

			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("buys_from")) {
					stmt.execute("DROP TABLE buys_from");
					break;
				}
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
}
