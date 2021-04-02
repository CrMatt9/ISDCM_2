/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webservice.models;

import isdcm.webservice.video.search.resources.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Video {
    private String title;
    private String author;
    private Date creation_date;
    private String duration;
    private long plays;
    private String description;
    private int user_id;
    private String format;
    
    public Video(String title, String author, Date creation_date,
                    String duration, long plays, String description, int user_id,
                    String format) {
        this.title = title;
        this.author = author;
        this.creation_date = creation_date;
        this.duration = duration;
        this.plays = plays;
        this.description = description;
        this.user_id = user_id;
        this.format = format;
    }
 
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public Date getCreationDate() {
        return this.creation_date;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public long getPlays() {
        return this.plays;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public int getUser() {
        return this.user_id;
    }
    
    public String getFormat() {
        return this.format;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public void setAuthor(String value) {
        this.author = value;
    }
    
    public void setCreationDate(Date creation_date) {
        this.creation_date = creation_date;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public void setPlays(int plays) {
        this.plays = plays;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }
    
    public void setFormat(String format) {
        this.format = format;
    }
    
    private static final String QUERY_BY_AUTHOR = "SELECT * FROM video WHERE user_id = ? AND author LIKE '%?%'";
    private static final String QUERY_BY_TITLE = "SELECT * FROM video WHERE user_id = ? AND title LIKE '%?%'";
    private static final String QUERY_BY_CREATION_DATE = "SELECT * FROM video WHERE user_id = ? AND creation_date LIKE '%?%'";
    
    
    public class MAX_LENGTH {
        public static final int TITLE = 45;
        public static final int AUTHOR = 45;
        public static final int DURATION = 45;
        public static final long PLAYS = Long.MAX_VALUE;
        public static final int DESCRIPTION = 45;
        public static final int FORMAT = 45;
    }
    
    public class FIELDS {
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String AUTHOR = "author";
        public static final String DATE = "creation_date";
        public static final String DURATION = "duration";
        public static final String PLAYS = "plays";
        public static final String DESCRIPTION = "description";
        public static final String USERID = "user_id";
        public static final String FORMAT = "format";
    }
    
    
    public static List<Video> getVideosByAuthor(int user, String author_to_search) throws SQLException {
        PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_BY_AUTHOR);
        statement.setInt(1, user);
        statement.setString(2, author_to_search);
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            Date creation_date = result.getDate(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            int plays = result.getInt(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            
            oRes.add(new Video(title, author, creation_date, duration, plays, description, user_id, format));
        }
        
        return oRes;
    }
    
        
    public static List<Video> getVideosByTitle(int user, String title_to_search) throws SQLException {
        PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_BY_TITLE);
        statement.setInt(1, user);
        statement.setString(2, title_to_search);
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            Date creation_date = result.getDate(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            int plays = result.getInt(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            
            oRes.add(new Video(title, author, creation_date, duration, plays, description, user_id, format));
        }
        
        return oRes;
    }
    
        public static List<Video> getVideosByDate(int user, String date_to_search) throws SQLException {
        PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_BY_CREATION_DATE);
        statement.setInt(1, user);
        statement.setString(2, date_to_search);
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            Date creation_date = result.getDate(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            int plays = result.getInt(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            
            oRes.add(new Video(title, author, creation_date, duration, plays, description, user_id, format));
        }
        
        return oRes;
    }
    
}
