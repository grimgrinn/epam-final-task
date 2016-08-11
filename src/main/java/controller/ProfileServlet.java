package controller;

import dao.UserDao;
import dao.WallPostDao;
import entity.User;
import entity.WallPost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Профайл пользователя
 */
@WebServlet("/profile")
public class ProfileServlet  extends HttpServlet {
    private static final Logger MEGALOG = LogManager.getLogger(ProfileServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDao userDao = new UserDao();
        WallPostDao wallPostDao  = new WallPostDao();
        User user = null;
        ArrayList<WallPost> userPosts = null;

      if(request.getParameter("id") != null && !request.getParameter("id").isEmpty() ){
          user = userDao.getById(parseInt(request.getParameter("id")));
     } else {
         HttpSession session = request.getSession(false);
          if(session.getAttribute("user") != null) {
              user = (User) session.getAttribute("user");
          } else {
              MEGALOG.error("miss user session");
              response.sendRedirect("/logout");
          }
      }
        userPosts = wallPostDao.getByUser(user.getId());
        System.out.println("this is user post -> ");
        System.out.println(userPosts);
        request.setAttribute("user",user);
        request.setAttribute("posts",userPosts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
        requestDispatcher.forward(request, response);

    }

}
