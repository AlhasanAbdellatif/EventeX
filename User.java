import java.util.ArrayList;

public class User {

	private int UserID;
	private String Name;
	private String Password;
	private String Email;
	public ArrayList<String> Preferences;
	
	
	
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
   
	public ArrayList<String> getPreferences() {
		return Preferences;
	}

	
	 /** The setPreferences method assigns a given value to the user Preferences 
	   * @param preferences is the value to set the user Preferences to */
	
	public void setPreferences(ArrayList<String> preferences) {
		Preferences = preferences;
	}
	
	
	User(int ID) {
		UserID = ID;
	}
	
	
	public void Create_Event(String E_name, String Category, String Date, String Description){
		Event EV = new Event (E_name, Category, Date , Description);
		/// give the event an ID based on its entry number in the Database
		/// Add the event to the database 
		
	}
	
	
	public void attend_Event(int EventID) {		
		int User_ID = getUserID();
		/// retrieve the Event attributes from the database
		/// requires Database function to insert the U_ID to that event database
		String User_name = getName();
		// String Event_name ====> the variable which will contain the event name obtained from the database in the second line of this method  
		String R = "will attend your event";
		String Content = User_name + R + Event_name;
		Notification NT = new Notification(Content);
		NT.send_notification(User U); /// the user meant here is the owner whose attributes are also obtained from the database in the second line of this method
	    /// NOTE: The argument (User U) in the last line should be changed to UserID which corresponds to the owner ID obtained 
		///       from the database in the second line of this method 
	}

	
	public void Delete_Event(int EventID) {
		
	}
	
	
	public void InviteUser(int userID , int eventID) {
		
	}




}