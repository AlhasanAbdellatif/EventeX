/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * This class handles the notification part of the system class
 * It represents a notification that has three attributes: UserID, Content, an its status whether seen or not
 * @author Hasan Abdellatif
 */
import java.sql.*;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import Inerfaces.start;


public class Notification {
	private int UserID;
	private String Content;
       private int seen;
       private int EventID;

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public Notification(int UserID, String Content, int EventID,int seen) {
        this.UserID = UserID;
        this.Content = Content;
        this.EventID = EventID;
        this.seen = seen;
    }
       

    public Notification(int EventID, String Content) {
        this.EventID = EventID;
        this.Content = Content;
    }

    public int getUserID() {
        return UserID;
    }

    public int isSeen() {
        return seen;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setSeen(int seen) throws SQLException {
        this.seen = seen;
        Statement mystmt = start.conn.createStatement();
		String Query = "Update Notification"
				+ " set Status = "+seen
				+ " where EventId = "+getEventID(); 
		mystmt.executeUpdate(Query);
    }
    
    
    /** The storeNot method stores a notification in the database  
	   * @param Content is the value to set the Content of the notification to 
    	   * @param ids is the IDs of the user who have this notification */

    public  void storeNot(ArrayList<Integer> ids) throws SQLException
    {

		Statement mystmt = start.conn.createStatement();
		String Query = "Insert into Notification "
				+ "(Content,UserId,Status,EventId)";
                
                for(int i=0;i<ids.size();i++)
                {
                    Query = Query + " values (\'" +getContent()+"\',\'" +ids.get(i)+"\',\'0\',\'"+ getEventID()+"\') ";
                }
		mystmt.executeUpdate(Query);   
}


	

	
	/** The getContent method returns the Content of the notification.
     * @return returns the String value of the Content */

	public String getContent() {
		return Content;
	}


	
	/** The setContent method assigns a String value to the Notification Content 
	   * @param Content is the value to set the Content of the notification to */

	public void setContent(String content) {
		Content = content;
	}

}

