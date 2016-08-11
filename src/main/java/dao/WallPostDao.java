package dao;


import connectionPool.ConnectionPool;
import entity.WallPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQueryApiInspection")
public class WallPostDao implements InterfaceDao<WallPost>{
    public static final Logger MEGALOG = LogManager.getLogger(WallPostDao.class);

    @Override
    public List<WallPost> get(){
        throw new NotImplementedException();
    }


    public ArrayList<WallPost> getByUser(final int user){
        String select = "SELECT t1.id, t1.user, t1.wall, t1.post, t1.timestamp, CONCAT_WS(' ', t2.first_name, t2.last_name) as author FROM walls t1 LEFT JOIN users t2 ON t2.id=t1.user WHERE t1.wall = ? ORDER BY timestamp DESC";
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<WallPost> result =  null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(
                     select,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY
             )
        ){
            ps.setInt(1,user);
            ArrayList<WallPost> wps = getWallPosts(ps);
            if (wps.size() > 0) {
                result = wps;
            }
        } catch (SQLException e) {
            MEGALOG.error("connection error", e);
        }
        return result;
    };

    @Override
    public WallPost getById(final int id){
        return null;
    };

    @Override
    public WallPost create (final WallPost post){
        WallPost newWallPost = null;

        java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());

        String insert = "INSERT INTO walls (user, wall, post, timestamp) VALUES (?, ?, ?, ?)";
        ConnectionPool pool = ConnectionPool.getInstance();
        try(Connection connection = pool.takeConnection();
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setInt(1, post.getUser());
            ps.setInt(2, post.getWall());
            ps.setString(3, post.getPost());
            ps.setTimestamp(4, post.getTimestamp());
            System.out.println("trying to exec -> " + ps);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int newId = rs.getInt(1);
                    newWallPost = new WallPost(newId, post.getUser(), post.getWall(),post.getPost(), post.getTimestamp());
                }
            }

        } catch (SQLException e) {
            MEGALOG.error("connection error", e);
        }
        return newWallPost;
    };

    @Override
    public void update(final WallPost post){

    };


    @Override
    public void delete(final int id){

    };

    private ArrayList<WallPost> getWallPosts(PreparedStatement ps) throws SQLException {
        ArrayList<WallPost> result = new ArrayList<>();

         try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String author =  rs.getString("author");
                String postBody = rs.getString("post");
                int user = rs.getInt("user");
                int wall = rs.getInt("wall");
                Timestamp timestamp = rs.getTimestamp("timestamp");

                result.add(new WallPost(id, user, wall, postBody, author, timestamp));
            }
        }

        return result;
    }

}
