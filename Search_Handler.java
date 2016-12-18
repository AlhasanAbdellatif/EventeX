import java.sql.*;

public class Search_Handler {
	private Object[] User_info = new Object[5];
	private Object[] Event_info = new Object[8];
	
	
	public void Search_Event_By_Name(String Name){
		Statement mystmt = start.conn.createStatement();
		ResultSet RS = mystmt.executeQuery("Select * from Event where Name=\'"+Name+"\'");
		//// The info is ordered by their order in the database
		int[] Attendees;
		Attendees = RS.getArray(7);
		int L = Attendees.length; 
		Event_info[0] = new String(RS.getString(1));    // Name
		Event_info[1] = new Integer(RS.getInteger(2));   // Id
 		Event_info[2] = new Integer(RS.getInteger(3));   // Owner
		Event_info[3] = new String(RS.getString(4));     // Category
		Event_info[4] = new String(RS.getString(5));      // Description
		Event_info[5] = new String(RS.getString(6));       // Date
		Event_info[6] = new int[L];                       // Attendees
		Event_info[6] = Attendees;
		Event_info[7] = new String(RS.getString(8));      // Place
	}
	
	
	
	public void Search_User(String Name){
		Statement mystmt = start.conn.createStatement();
		ResultSet RS = mystmt.executeQuery("Select * from User where Name=\'"+Name+"\'");
		//// The info is ordered by their order in the database
		User_info[0] = new String(RS.getString(1));    // Name
		User_info[1] = new Integer(RS.getInteger(2));   // Id
 		User_info[2] = new String(RS.getString(3));   // Password
		User_info[3] = new String(RS.getString(4));     // Email
		User_info[4] = new String(RS.getString(5));      // Preferences
	}
	
	
	
	public void Search_Event_By_Category(String Category){
		Statement mystmt = start.conn.createStatement();
		ResultSet RS = mystmt.executeQuery("Select * from Event where Category=\'"+Category+"\'");
		//// The info is ordered by their order in the database
		int[] Attendees;
		Attendees = RS.getArray(7);
		int L = Attendees.length; 
		Event_info[0] = new String(RS.getString(1));    // Name
		Event_info[1] = new Integer(RS.getInteger(2));   // Id
 		Event_info[2] = new Integer(RS.getInteger(3));   // Owner
		Event_info[3] = new String(RS.getString(4));     // Category
		Event_info[4] = new String(RS.getString(5));      // Description
		Event_info[5] = new String(RS.getString(6));       // Date
		Event_info[6] = new int[L];                       // Attendees
		Event_info[6] = Attendees;
		Event_info[7] = new String(RS.getString(8));      // Place
		
	}
	
	
	
	public void Search_Event_By_Date(String Date){
		Statement mystmt = start.conn.createStatement();
		ResultSet RS = mystmt.executeQuery("Select * from Event where Date=\'"+Date+"\'");
		//// The info is ordered by their order in the database
		int[] Attendees;
		Attendees = RS.getArray(7);
		int L = Attendees.length; 
		Event_info[0] = new String(RS.getString(1));    // Name
		Event_info[1] = new Integer(RS.getInteger(2));   // Id
 		Event_info[2] = new Integer(RS.getInteger(3));   // Owner
		Event_info[3] = new String(RS.getString(4));     // Category
		Event_info[4] = new String(RS.getString(5));      // Description
		Event_info[5] = new String(RS.getString(6));       // Date
		Event_info[6] = new int[L];                       // Attendees
		Event_info[6] = Attendees;
		Event_info[7] = new String(RS.getString(8));      // Place
		
	}
	


}
