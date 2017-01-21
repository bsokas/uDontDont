package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;



/**
 * This class pulls data from the Oracle database hosted in Amazon Web Services.
 * @author veronikaalex
 *
 */
public class Database {

	// Database information and credentials
	Connection conn = null;
	Statement stmt = null;
	private final String DB_URL = "cheating.czp0ytib1pp5.us-east-1.rds.amazonaws.com";
	// DB_NAME is the name of the DB from the AWS field NOT the SQLDeveloper name
	private final String DB_NAME = "ORCL";
	private final String USER = "swap";
	private final String PASSWORD = "cheating";
	
	private int typeOfAssignment;
	private int mcNumber;
	private int saNumber;
	private int frNumber;
	private int otherNumber;
	private int reusedQuestions;
	private int questionSourceTextbook;
	private int questionSourcePersonalBook;
	private int questionSourceHandCrafted;
	private int assignmentDifficulty;
	private int studentOwnership;
	private int solutionsProvided;
	private int typeOfCheating;



	/**
	 * Constructor for the database class
	* @param typeOfAssignment
	* @param mcNumber
	* @param saNumber
	* @param frNumber
	* @param otherNumber
	* @param reusedQuestions
	* @param questionSourceTextbook
	* @param questionSourcePersonalBook
	* @param questionSourceHandCrafted
	* @param assignmentDifficulty
	* @param studentOwnership
	* @param solutionsProvided
	* @param typeOfCheating
	*/
	public Database(int typeOfAssignment, int mcNumber, int saNumber, int frNumber, int otherNumber, 
			int reusedQuestions, int questionSourceTextbook, int questionSourcePersonalBook, 
			int questionSourceHandCrafted, int assignmentDifficulty, int studentOwnership, 
			int solutionsProvided, int typeOfCheating){
		this.typeOfAssignment = typeOfAssignment;
		this.mcNumber = mcNumber;
		this.saNumber = saNumber;
		this.frNumber = frNumber;
		this.otherNumber = otherNumber;
		this.reusedQuestions = reusedQuestions;
		this.questionSourceTextbook = questionSourceTextbook;
		this.questionSourcePersonalBook = questionSourcePersonalBook;
		this.questionSourceHandCrafted = questionSourceHandCrafted;
		this.assignmentDifficulty = assignmentDifficulty;
		this.studentOwnership = studentOwnership;
		this.solutionsProvided = solutionsProvided;
		this.typeOfCheating = typeOfCheating;
	}
	
	
	
	
	/**
	 * Connects to database, inserts new cheating instance with criteria.
	 */
	public void addCheatingData() {

		try {
			// Standard setup
			DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@//" + DB_URL + "/" + DB_NAME, USER, PASSWORD);
			stmt = conn.createStatement();

			// Build sql string
			String sqlQuery;
			sqlQuery = "INSERT INTO DUMMYCHEATINGDATA VALUES (" + typeOfAssignment + ", " + mcNumber + ", " + saNumber + ", " +
					frNumber + ", " + otherNumber + ", " + reusedQuestions + ", " + questionSourceTextbook + ", " + questionSourcePersonalBook + ", " + 
					questionSourceHandCrafted + ", " + assignmentDifficulty + ", " + studentOwnership + ", " + solutionsProvided + ", " + 
					typeOfCheating + ")";

			System.out.print(sqlQuery);

			// Execute sql string
			//System.out.println("Executing query... " + sqlQuery);
			ResultSet rs = stmt.executeQuery(sqlQuery);

			
			// Iterate over rs to retrieve results
//			while(rs.next()) {
//				//Retrieve by column name
//				int month  = rs.getInt("MONTH");
//				int dayOfWeek = rs.getInt("DAY_OF_WEEK");
//				int departTime = rs.getInt("CRS_DEP_TIME");
//				String carr = rs.getString("CARRIER");
//				int delayTime = rs.getInt("DEP_DELAY");
//			}

			// Clean-up time
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do

			try {
				if (conn != null)
					conn.close();
			} catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}



