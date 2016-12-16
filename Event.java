import java.util.ArrayList;
public class Event {
    
    private String Name;
    private int EventID;
    private String Category;
    private int OwnerID;
    private int No_of_attendees;
    private int Max_No_of_attendees;
    private String Description;
    private ArrayList<Integer> Date;
    
    public Event(String name, String category, ArrayList<Integer> date, String description){
        Name = name;
        Category = category;
        Date = date;
        Description = description;
    }
    
    public Boolean check_no_of_attendees(){
        return No_of_attendees < Max_No_of_attendees;    
    }
   
    
    public Boolean checkOwner(int UserId){
        OwnerID = getOwnerID();
        return OwnerID == UserId;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name) {
	Name = name;
    }
    
    public int getEventID(){
        return EventID;
    }
    
    public String getCategory(){
        return Category;
    }
    
    public void setCategory(String category) {
	Name = category;
    }
    
    public int getOwnerID(){
        return OwnerID;
    }
    
    public int getNo_of_attendees(){
        return No_of_attendees;
    }
    
    public void setNo_of_attendees(int no_of_attendees) {
	No_of_attendees = no_of_attendees;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public void setDescription(String description) {
	Description = description;
    }
    
    public ArrayList<Integer> Date(){
        return Date;
    }
    
    public void setDate(String date) {
	Description = date;
    }
}
    
    

