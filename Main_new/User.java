/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Hasan Abdellatif
 */
import Inerfaces.NotBar;
import Inerfaces.Event_UI;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Inerfaces.start;


public class User {
    
Event open_ev;
	private int UserID;
	private String Name;
	private String Password;
	private String Email;
	public String Preferences;
        
	
	
	
	/** The getUserID method returns the value of the rectangle length.
     * @return returns the value of the UserID */
   
	public int getUserID() {
		return UserID;
	}

	
	 /** The setUserID method assigns a given value to the UserID 
	   * @param userID is the value to set the UserID to */
	  
	public void setUserID(int userID) {
		UserID = userID;
	}

	
	/** The getName method returns the value of the Name of the user.
     * @return returns the value of the Name */
     
	public String getName() {
		return Name;
	}

	
	 /** The setName method assigns a given value to the user Name 
	   * @param name is the value to set the Name to */
	  
	public void setName(String name) {
		Name = name;
	}

	
	/** The getPassword method returns the value of the Password.
     * @return returns the value of the Password */
    
	public String getPassword() {
		return Password;
	}

	
	 /** The setPassword method assigns a given value to the user Password 
	   * @param password is the value to set user Password to */
	  
	public void setPassword(String password) {
		Password = password;
	}

	
	/** The getEmail method returns the value of the current user Email.
     * @return returns the value of the user Email */
    
	public String getEmail() {
		return Email;
	}

	
	 /** The setEmail method assigns a given value to the user Email 
	   * @param email is the value to set the user Email to */
	  
	public void setEmail(String email) {
		Email = email;
	}

	
	/** The getPreferences method returns the value of the User Preferences.
     * @return returns the value of the user Preferences */
   
	public String getPreferences() {
		return Preferences;
	}

	
	 /** The setPreferences method assigns a given value to the user Preferences 
	   * @param preferences is the value to set the user Preferences to */
	
	public void setPreferences(String preferences) {
		Preferences = preferences;
	}

    public User(int UserID, String Name, String Password, String Email, String Preferences) {
        this.UserID = UserID;
        this.Name = Name;
        this.Password = Password;
        this.Email = Email;
        this.Preferences = Preferences;
    }
    
    public void Create_Event(String name, String category, String date, String description,String place) {
        int OwnerID = getUserID();
                try {
                Connection con = start.conn;
		Statement ss = con.createStatement();
		
		// creating the event entry in the database
		String sql = "Insert into Event "
				+ "(Name, Owner, Category, Description, Date,Place,Attendees)"
				+ "values (\'" +name+"\',\'" +OwnerID+"\',\'" +category+"\',\'" +description+"\',\'" +date+"\',\'"+place+"\',\'0\')";
               
               // String sql1 =  " "
                //System.out.println(sql);
		ss.executeUpdate(sql);

                //Ev nev = new Ev(name,  category,  date,  description, place, OwnerID,EV.getNo_of_attendees());
        
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Check Internet Connection!");
            exc.printStackTrace();   
        }
               
		
		
	}
    
    public void attend_Event()  {		
		int User_ID = getUserID();
		/// retrieve the Event attributes from the database
	try{
            Statement ss = start.conn.createStatement();
        
		//Statement ss1 = start.conn.createStatement();
                
                Event_UI.event.AddAttendee();
                ss.executeUpdate(" insert into Attended "
                     + "(UserId,EventId,EventName)"
                     + "values (\'" +User_ID+"\',\'"+Event_UI.event.getEventID()+"\',\'"+Event_UI.event.getName()+"\')");
                
                 JOptionPane.showMessageDialog(null, "Thanks, Stay Tuned !");

		Statement mystmt = start.conn.createStatement();
		String Query = "update Event "
				+ "set Attendees = "+Event_UI.event.getNo_of_attendees()+"where Id = "+ Event_UI.event.getEventID();
		mystmt.executeUpdate(Query);
                }
                catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Check Internet Connection!");
            exc.printStackTrace();   
        }
	    
	}
       public void delete_Event()  {		
		/// retrieve the Event attributes from the database
	try{
            Statement ss = start.conn.createStatement();

                Notification not = new Notification(-1,"The Event "+Event_UI.event.getName()+" has been deleted");
               ArrayList<Integer> ids = Event_UI.event.getAttendeeIds();
               not.storeNot(ids);
                int old_id = Event_UI.event.getEventID();
               ss.executeUpdate("Delete from Event where Id = "+old_id);
               ss.executeUpdate("Delete from Attended where EventId = "+old_id);
               JOptionPane.showMessageDialog(null, "The event is deleted !");
                }
                catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Check Internet Connection!");
            exc.printStackTrace();   
        }
	    
	}
       
    /** The NoNewNot method returns the number of the unseen notification by the user.
     * @returns the number of the unseen notification by the user */   
    public int NoNewNot()
    {
        int num= 0;
        try {
            Statement ss1 = start.conn.createStatement();
            String sql = "Select EventId from notification where UserId = "+ getUserID()+" AND Status = 0";
          ResultSet rs1 = ss1.executeQuery(sql);
        
        while(rs1.next())
        {
        num++;
        }   
        }
         catch (SQLException ex) {
            Logger.getLogger(NotBar.class.getName()).log(Level.SEVERE, null, ex);
        }
         return num;
    }
    
    public boolean InviteUser(String name)
    {
        boolean case1 = false;
          try {
            // TODO add your handling code here:
            Statement ss = start.conn.createStatement();
            String sql = "Select Id from User where Name = \'"+name+"\'";
            ResultSet rs = ss.executeQuery(sql);
            if(rs.next())
            {
                int id = Integer.parseInt(rs.getString("Id"));
                Notification not = new Notification(Event_UI.event.getEventID(),getName()+" has invited you to "+Event_UI.event.getName());
                ArrayList<Integer> ids =  new  ArrayList<Integer>();
                ids.add(id);
                not.storeNot(ids);
                case1 = true;
            }
            }
         catch (SQLException ex) {
            Logger.getLogger(Event_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
          return case1;
    }
    
        public void Leave_Event()  {		
	int User_ID = getUserID();
		/// retrieve the Event attributes from the database
	try{
            Statement ss = start.conn.createStatement();
        
		//Statement ss1 = start.conn.createStatement();
                
                Event_UI.event.deleteAttendee();
                ss.executeUpdate(" Delete From Attended where EventId = "+ Event_UI.event.getEventID()+" AND UserId = "+User_ID);
                
                 JOptionPane.showMessageDialog(null, "Thanks, You have leaved this event !");

		Statement mystmt = start.conn.createStatement();
		String Query = "update Event "
				+ "set Attendees = "+Event_UI.event.getNo_of_attendees()+"where Id = "+Event_UI.event.getEventID();
		mystmt.executeUpdate(Query);
                }
                catch (Exception exc){
            JOptionPane.showMessageDialog(null, "Check Internet Connection!");
            exc.printStackTrace();   
        }
	    
	}
    

}


