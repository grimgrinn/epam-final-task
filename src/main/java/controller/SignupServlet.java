package controller;

import model.ModelUser;
import model.StatusUserDataMessages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static model.StatusUserDataMessages.CORRECT_SIGNUP;

/**
 * Регистрация
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
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

            if (submit != null) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");


            ModelUser model = new ModelUser();
            ArrayList<StatusUserDataMessages> messages = model.createUser(email, lastName, firstName,  password);
            request.setAttribute("messages", messages);
            if(messages.get(0) == CORRECT_SIGNUP){
                request.setAttribute("successSignUp", 1);
            }
      }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/signup.jsp");
        requestDispatcher.forward(request, response);
    }
}
