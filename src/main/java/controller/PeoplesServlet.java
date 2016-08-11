package controller;

import entity.User;
import model.ModelUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * вывод все людей.
 */

@WebServlet("/peoples")
public class PeoplesServlet extends HttpServlet {
    private static final Logger MEGALOG = LogManager.getLogger(PeoplesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String url = request.getRequestURI();
        ModelUser model = new ModelUser();

        Collection<User> users = model.getAll();
        System.out.println(users);
        request.setAttribute("users", users);



        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/peoples.jsp");
        requestDispatcher.forward(request, response);

    }





    }
