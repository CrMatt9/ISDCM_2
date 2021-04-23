package com.upc.isdcm_soap.models;

import com.upc.isdcm_soap.tools.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Video {
    private int id;
    private String title;
    private String author;
    private String creation_date;
    private String duration;
    private String plays;
    private String description;
    private int user_id;
    private String format;
    private String path;
    
    public Video(int id, String title, String author, String creation_date,
                    String duration, String plays, String description, int user_id,
                    String format, String path) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.creation_date = creation_date;
        this.duration = duration;
        this.plays = plays;
        this.description = description;
        this.user_id = user_id;
        this.format = format;
        this.path = path;
    }
 
    public int getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getCreationDate() {
        return this.creation_date;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public String getPlays() {
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
     
    public String getPath() {
        return this.path;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public void setAuthor(String value) {
        this.author = value;
    }
    
    public void setCreationDate(String creation_date) {
        this.creation_date = creation_date;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public void setPlays(String plays) {
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
    
    public void setPath(String path) {
        this.path = path;
    }
    
    private static final String QUERY_USER_VIDEOS = "SELECT * FROM videos WHERE user_id = ?";
    private static final String QUERY_BY_AUTHOR = "SELECT * FROM videos WHERE user_id = ? AND author LIKE ?";
    private static final String QUERY_BY_TITLE = "SELECT * FROM videos WHERE user_id = ? AND title LIKE ?";
    private static final String QUERY_BY_CREATION_DATE_1 = "SELECT * FROM videos WHERE user_id = ? AND Day(creation_date) = ? AND Month(creation_date) = ? AND Year(creation_date) = ?";
    private static final String QUERY_BY_CREATION_DATE_2 = "SELECT * FROM videos WHERE user_id = ? AND Month(creation_date) = ? AND Year(creation_date) = ?";
    private static final String QUERY_BY_CREATION_DATE_3 = "SELECT * FROM videos WHERE user_id = ? AND Year(creation_date) = ?";
        
    public class MAX_LENGTH {
        public static final int TITLE = 45;
        public static final int AUTHOR = 45;
        public static final int DURATION = 45;
        public static final long PLAYS = Long.MAX_VALUE;
        public static final int DESCRIPTION = 45;
        public static final int FORMAT = 45;
        public static final int PATH = 300;
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
        public static final String PATH = "path";
    }
    
    
    public static List<Video> getVideosByAuthor(int user, String author_to_search) throws SQLException {
            PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_BY_AUTHOR);
        statement.setInt(1, user);
        statement.setString(2, "%" + author_to_search + "%");
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            String creation_date = result.getString(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            String plays = result.getString(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            String path = result.getString(FIELDS.PATH);
            
            oRes.add(new Video(id, title, author, creation_date, duration, plays, description, user_id, format, path));
        }
        
        return oRes;
    }
    
        
    public static List<Video> getVideosByTitle(int user, String title_to_search) throws SQLException {
        PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_BY_TITLE);
        statement.setInt(1, user);
        statement.setString(2, "%" + title_to_search + "%");
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            String creation_date = result.getString(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            String plays = result.getString(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            String path = result.getString(FIELDS.PATH);
            
            oRes.add(new Video(id, title, author, creation_date, duration, plays, description, user_id, format, path));
        }
        
        return oRes;
    }
    
    public static List<Video> getUserVideos(int user) throws SQLException {
        PreparedStatement statement = Database.instance().connection.prepareStatement(QUERY_USER_VIDEOS);
        statement.setInt(1, user);
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            String creation_date = result.getString(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            String plays = result.getString(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            String path = result.getString(FIELDS.PATH);
            
            oRes.add(new Video(id, title, author, creation_date, duration, plays, description, user_id, format, path));
        }
        
        return oRes;
    }
    
    public static boolean empty(String value) {
        return value == null || value.isEmpty();
    }
    
    public static List<Video> getVideosByDate(int user, String dia, String mes, String año) throws SQLException {
        PreparedStatement statement;
        
        if (!empty(dia) && !empty(mes) && !empty(año)) {
            statement = Database.instance().connection.prepareStatement(QUERY_BY_CREATION_DATE_1);
            statement.setInt(1, user);
            statement.setInt(2, Integer.parseInt(dia));
            statement.setInt(3, Integer.parseInt(mes));
            statement.setInt(4, Integer.parseInt(año));
        } else if (!empty(mes) && !empty(año)) {
            statement = Database.instance().connection.prepareStatement(QUERY_BY_CREATION_DATE_2);
            statement.setInt(1, user);
            statement.setInt(2, Integer.parseInt(mes));
            statement.setInt(3, Integer.parseInt(año));
        } else if (!empty(año)) {
            statement = Database.instance().connection.prepareStatement(QUERY_BY_CREATION_DATE_3);
            statement.setInt(1, user);
            statement.setInt(2, Integer.parseInt(año));
        } else {
            statement = Database.instance().connection.prepareStatement(QUERY_USER_VIDEOS);
            statement.setInt(1, user);
        }
        
        ResultSet result = statement.executeQuery();
        
        ArrayList<Video> oRes = new ArrayList<>();
        while (result.next()) {
            int id = result.getInt(FIELDS.ID);
            String title = result.getString(FIELDS.TITLE);
            String author = result.getString(FIELDS.AUTHOR);
            String creation_date = result.getString(FIELDS.DATE);
            String duration = result.getString(FIELDS.DURATION);
            String plays = result.getString(FIELDS.PLAYS);
            String description = result.getString(FIELDS.DESCRIPTION);
            int user_id = result.getInt(FIELDS.USERID);
            String format = result.getString(FIELDS.FORMAT);
            String path = result.getString(FIELDS.PATH);
            
            oRes.add(new Video(id, title, author, creation_date, duration, plays, description, user_id, format, path));
        }
        
        return oRes;
    }
    
}
