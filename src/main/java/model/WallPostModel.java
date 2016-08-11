package model;

import dao.WallPostDao;
import entity.WallPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.Collection;


public class WallPostModel {
    private static final Logger MEGALOG = LogManager.getLogger(WallPostModel.class);

    /**
     * Создаёт запись на стене
     *
     * @param user     пользоатель
     * @param postBody тело поста
     * @return ошибки создания или CORRECT_ADDPOST
     */
    public boolean createPost(final int user, final int wall, final String postBody) {

        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
        System.out.println("try dao with -> " + user +"-"+ wall +"-"+  postBody);
        WallPost post = new WallPost(user, wall, postBody, sqlDate);

        WallPostDao dao = new WallPostDao();

        return (dao.create(post) != null);
    }

    /**
     * Получает все стенозаписи пользователя
     * @return список записей
     */
    public Collection<WallPost> getUserPosts(final int wall) {
        WallPostDao dao = new WallPostDao();
        return dao.getByUser(wall);
    }
}