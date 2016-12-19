/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventex;

/**
 *
 * @author Hasan Abdellatif
 */

import java.util.ArrayList;
public class Event {
    
    private String Name;
    private int EventID;
    private String Category;
    private int OwnerID;
    private int No_of_attendees = 0;
    private int Max_No_of_attendees;
    private String Description;
    private String Date;
    private String Place;

    public void setMax_No_of_attendees(int Max_No_of_attendees) {
        this.Max_No_of_attendees = Max_No_of_attendees;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public int getMax_No_of_attendees() {
        return Max_No_of_attendees;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

    public String getPlace() {
        return Place;
    }
    
    public Event(String name, String category, String date, String description,String place,int oid ){
        Name = name;
        Category = category;
        Date = date;
        Description = description;
        Place = place;
        OwnerID = oid;
    }
    
    public Boolean check_no_of_attendees(){
        return No_of_attendees < Max_No_of_attendees;    
    }
   
    
    public Boolean checkOwner(int UserId){
        /* from the database, get thr ID of the creator
        and store it in OwnerID*/
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
    public void AddAttendee() {
	No_of_attendees = No_of_attendees+1;
    }
    public void deleteAttendee() {
	No_of_attendees = No_of_attendees-1;
    }
    
    public String getDescription(){
        return Description;
    }
    
    public void setDescription(String description) {
	Description = description;
    }
    
    public String getDate(){
        return Date;
    }
    
    public void setDate(String date) {
	Date = date;
    }
}
    
    

