package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Стенопост
 */
public class WallPost {
    private int id;
    private int user;
    private int wall;
    private String post;
    private String author;
    private Timestamp timeStamp;

    public WallPost(int user, String post, Timestamp timeStamp){
        this.user = user;
        this.post = post;
        this.timeStamp = timeStamp;
    }

    public WallPost(int user, int wall, String post, Timestamp timeStamp){
        this.user = user;
        this.post = post;
        this.wall = wall;
        this.timeStamp = timeStamp;
    }

    public WallPost(int id, int user, int wall, String post, Timestamp timeStamp){
        this.user = user;
        this.post = post;
        this.wall = wall;
        this.timeStamp = timeStamp;
    }

    public WallPost(int id, int user, int wall, String post, String author, Timestamp timeStamp){
        this.user = user;
        this.post = post;
        this.author = author;
        this.wall = wall;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString(){
        String me = this.post + " on the wall "+ this.wall;
        return me;
    }

    public int getId() {
        return id;
    }

    public int getUser() { return user;   }
    public int getWall() { return wall;   }
    public String getPost() { return post;   }
    public Timestamp getTimestamp() {return timeStamp; }
    public String getAuthor() { return author; }
    public String getTime() {
        Date date = new Date(timeStamp.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM HH:mm ");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }



}
