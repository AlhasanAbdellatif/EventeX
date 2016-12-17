import java.sql.*;

public class Notification {
	private int NotID;
	private String Content;
	
	
	
	/// Constructor
	Notification(String content){
		Content = content;
		Statement mystmt = start.conn.createStatement();
		String Query = "Insert into Notification "
				+ "(Content)"
				+ "values (\'" +content+"\')";
		mystmt.executeUpdate(Query);
	}


	
	
	/** The getNotID method returns the value of the current Notification ID.
     * @return returns the value of the Notification ID */
	
	public int getNotID() {
		Statement mystmt = start.conn.createStatement();
		ResultSet Not_info = mystmt.executeQuery("Select Id from Notification where Content=\'" +Content+"\' ");
		NotID = Not_info.getInt(1);
		return NotID;
	}



	
	 /** The setNotID method assigns a given value to the Notification ID 
	   * @param preferences is the value to set the ID of the notification to */
	
	public void setNotID(int notID) {
		Statement mystmt = start.conn.createStatement();
		String Query = "Update Notification"
				+ "set Id= \'"+notID+"\'"
				+ "where Content = \'"+Content+"\'"; 
		mystmt.executeUpdate(Query);
		NotID = notID;
	}



	
	/** The getContent method returns the Content of the notification.
     * @return returns the String value of the Content */

	public String getContent() {
		Statement mystmt = start.conn.createStatement();
		ResultSet Not_info = mystmt.executeQuery("Select Content from Notification where Id=\'" +NotID+"\' ");
		Content = Not_info.getString(2);
		return Content;
	}


	
	/** The setContent method assigns a String value to the Notification Content 
	   * @param Content is the value to set the Content of the notification to */

	public void setContent(String content) {
		Statement mystmt = start.conn.createStatement();
		String Query = "Update Notification"
				+ "set Content= \'"+content+"\'"
				+ "where Id = \'"+NotID+"\'"; 
		mystmt.executeUpdate(Query);
		Content = content;
	}
	
	
	public void AddNotification(int[] UserIDs, int NotificationID){
		Statement mystmt = start.conn.createStatement();
		String Query = "Update Notification"
				+ "set RUsers= \'"+UserIDs+"\'"
				+ "where Id = \'"+NotificationID+"\'"; 
		mystmt.executeUpdate(Query);
	}
	
	
	public void send_notification()
	
	
}
