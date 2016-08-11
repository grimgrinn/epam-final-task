package controller;


import entity.User;
import model.WallPostModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/addwallpost")
public class WallPostServlet extends HttpServlet {
    private static final Logger MEGALOG = LogManager.getLogger(WallPostServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String submit = request.getParameter("submit");
        String url = request.getParameter("url");
        String paramid = (request.getParameter("paramid"));

        String post = request.getParameter("postBody");
        HttpSession session = request.getSession(false);

        System.out.println("now in walpost servlet this is postBody from servlet - > " + post);

        boolean succ = false;
        try{
            User master = (User) session.getAttribute("user");
            WallPostModel model = new WallPostModel();
            System.out.println("try to create post! - > " + master.getId() +  parseInt(paramid) + post);
            succ = model.createPost(master.getId(), parseInt(paramid), post);
        } catch(NullPointerException e){
            MEGALOG.error("session error");
        }
        System.out.println("this is succ -> " + succ);
        if(succ){
             request.setAttribute("postSuccess",succ);
            //return;
        }

        System.out.println("this is request uri1111! -> "+url + paramid);

       response.sendRedirect(url+"?id="+paramid);
    }

}
