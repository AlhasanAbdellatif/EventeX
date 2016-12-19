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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Inerfaces.start;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private boolean Passed;

    public boolean isPassed() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            Date date1 = sdf.parse(Date);
            Date date2 = sdf.parse(dtf.format(localDate));
            Passed = date1.before(date2);
        return Passed;
    }

    public void setPassed(boolean hasPassed) {
        
        this.Passed = hasPassed;
    }
   
    
    

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
    
    public  ArrayList<Integer> getAttendeeIds() throws SQLException
    {
         Statement ss = start.conn.createStatement();
        String sql = "Select UserId from Attended where EventId = "+getEventID();
                ResultSet rs = ss.executeQuery(sql);
                ArrayList<Integer> ids = new   ArrayList<Integer>();
                while(rs.next())
                {
                    ids.add(Integer.parseInt(rs.getString("UserId")));
                }
                return ids;
    }
    public boolean checkattendee (int id) throws SQLException
    {
        boolean case1 = false;
         Statement ss = start.conn.createStatement();
        String sql = "Select UserId from Attended where EventId = "+getEventID()+" And UserId = "+id;
        ResultSet rs = ss.executeQuery(sql);
        if(rs.next())
        {
            case1 = true;
        }
        
        return case1;
    }
     public boolean checkattendee (String name) throws SQLException
    {
        boolean case1 = false;
         Statement ss = start.conn.createStatement();
        String sql = "Select Id from User where Name = \'"+name+"\'";
        ResultSet rs = ss.executeQuery(sql);
        if(rs.next())
        {
           int id = Integer.parseInt(rs.getString("Id"));
           case1 = checkattendee(id);
        }    
        return case1;
    }
    
}
    
    

