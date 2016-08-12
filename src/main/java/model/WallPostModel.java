package model;

import dao.WallPostDao;
import entity.WallPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;


public class WallPostModel {
    private static final Logger MEGALOG = LogManager.getLogger(WallPostModel.class);

    /**
     * удалить запись
     * @param id
     */
    public void delete(final int id){
        WallPostDao dao = new WallPostDao();
        dao.delete(id);
    }

    /**
     * запись по Юзеру
     * @param id
     * @return
     */
    public ArrayList<WallPost> getByUser(final int id){
        WallPostDao dao = new WallPostDao();
        return dao.getByUser(id);
    }

    /**
     * Создаёт запись на стене
     *
     * @param user     пользоатель
     * @param postBody тело поста
     * @return истину если все получилось
     */
    public boolean createPost(final int user, final int wall, final String postBody) {

        Timestamp sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());

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

    /**
     * обновляет запись на стене
     * @param id
     */
    public void update(final int id, final String post){
        WallPost wp = null;
        WallPostDao dao = new WallPostDao();
        wp = dao.getById(id);

        wp.setPostBody(post);
        dao.update(wp);
    }


}