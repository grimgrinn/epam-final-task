package controller;

import dao.UserDao;
import dao.WallPostDao;
import entity.User;
import entity.WallPost;
import model.ModelUser;
import model.WallPostModel;
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
@WebServlet({"/profile", "/profile/*"})
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
        ModelUser model = new ModelUser();
        WallPostModel wpModel  = new WallPostModel();
        User user = null;
        ArrayList<WallPost> userPosts = null;

        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty() ){

          user = model.getById(parseInt(request.getParameter("id")));
     } else {
         HttpSession session = request.getSession(false);
          if(session.getAttribute("user") != null) {
              user = (User) session.getAttribute("user");
          } else {
              MEGALOG.error("miss user session");
              response.sendRedirect("/logout");
          }
      }
        userPosts = wpModel.getByUser(user.getId());
        request.setAttribute("user",user);
        request.setAttribute("posts",userPosts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
        requestDispatcher.forward(request, response);

    }

}
