package nft.database;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import javafx.util.Pair;
import nft.model.Buyers;
import nft.model.Collaterals;
import nft.model.DigitalContent;
import nft.model.Gaming;
import nft.model.HostWebsite;
import nft.model.NFTOwns;
import nft.model.People;
import nft.model.Sellers;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
	// Use this version of the ORACLE_URL if you are running the code off of the server
	//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
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

	public void deleteBranch(int branchId) {
		try {
			PreparedStatement ps = connection.prepareStatement("DELETE FROM branch WHERE branch_id = ?");
			ps.setInt(1, branchId);
			
			int rowCount = ps.executeUpdate();
			if (rowCount == 0) {
				System.out.println(WARNING_TAG + " Branch " + branchId + " does not exist!");
			}
			
			connection.commit();
	
			ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
	}
	
	public void insertHostWebsite(HostWebsite model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO host_website VALUES (?,?,?,?)");
			ps.setString(1, model.getDomain());
			ps.setDate(2, (Date) model.getPublishedOn());
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

	public void insertCollaterals(Collaterals model) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO collaterals VALUES (?,?,?,?,?)");
			ps.setString(1, model.getTokenID());
			ps.setString(2, model.getType());
			ps.setString(3, model.getLoanee());
			ps.setString(4, model.getLoaner());
			ps.setBigDecimal(5, model.getTokenRate());

			ps.executeUpdate();
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

	// find buyers with current bids > ?
	public Buyers[] selectionBuyersWithBidsGreaterThan(BigDecimal bid) {
		ArrayList<Buyers> result = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT b.buyerID FROM buyers b WHERE b.currentBid > ?");
			ps.setBigDecimal(1, bid);

			ps.execute();
			ResultSet queryResult = ps.getResultSet();

			String personID;
			String buyerID;
			BigDecimal currentBid;
			while (queryResult.next()) {
				personID = queryResult.getString("personID");
				buyerID = queryResult.getString("buyerID");
				currentBid = queryResult.getBigDecimal("currentBid");
				result.add(new Buyers(personID, buyerID, currentBid));
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
			PreparedStatement ps = connection.prepareStatement("SELECT p.personID FROM People p WHERE NOT EXISTS (SELECT o.personID FROM NFTOwns o WHERE o.personID <> p.personID");

			ps.execute();
			ResultSet queryResult = ps.getResultSet();

			String personID;
			String name;
			Integer age;
			while (queryResult.next()) {
				personID = queryResult.getString("personID");
				name = queryResult.getString("name");
				age = queryResult.getInt("age");
				result.add(new People(personID, name, age));
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
				for (int i = 0; i < attributes.size(); ++i) {
					result.append(attributes.get(i)).append("= ").append(queryResult.getString(attributes.get(i))).append(" ");
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
				result.append(queryResult.getInt(0));
			}

			stmt.close();
			queryResult.close();

			finalResult = result.toString();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}
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
				result.append("Currency: ").append(queryResult.getString(0));
				result.append("Average number of NFTs: ").append(queryResult.getString(1));
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
		return finalResult;
	}
	
	public DigitalContent[] getBranchInfo() {
		ArrayList<DigitalContent> result = new ArrayList<DigitalContent>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM branch");
		
//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		System.out.println(" ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}
			
			while(rs.next()) {
				DigitalContent model = new DigitalContent(rs.getString("branch_addr"),
													rs.getString("branch_city"),
													rs.getInt("branch_id"),
													rs.getString("branch_name"),
													rs.getInt("branch_phone"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}	
		
		return result.toArray(new DigitalContent[result.size()]);
	}
	
	public void updateBranch(int id, String name) {
		try {
		  PreparedStatement ps = connection.prepareStatement("UPDATE branch SET branch_name = ? WHERE branch_id = ?");
		  ps.setString(1, name);
		  ps.setInt(2, id);
		
		  int rowCount = ps.executeUpdate();
		  if (rowCount == 0) {
		      System.out.println(WARNING_TAG + " Branch " + id + " does not exist!");
		  }
	
		  connection.commit();
		  
		  ps.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			rollbackConnection();
		}	
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
		dropBranchTableIfExists();
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE branch (branch_id integer PRIMARY KEY, branch_name varchar2(20) not null, branch_addr varchar2(50), branch_city varchar2(20) not null, branch_phone integer)");
			stmt.close();
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
		
		DigitalContent branch1 = new DigitalContent("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
		insertBranch(branch1);
		
		DigitalContent branch2 = new DigitalContent("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
		insertBranch(branch2);
	}
	
	private void dropBranchTableIfExists() {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select table_name from user_tables");
			
			while(rs.next()) {
				if(rs.getString(1).toLowerCase().equals("branch")) {
					stmt.execute("DROP TABLE branch");
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
