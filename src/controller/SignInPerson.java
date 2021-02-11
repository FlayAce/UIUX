package controller;

import model.entity.Person;
import model.manager.PersonManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SignInPerson extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pass");


        PersonManager personManager = new PersonManager();
        try {
            boolean result = personManager.findPerson(new Person(username, password));
            if (result) {
                response.sendRedirect("form/index.jsp");
            } else {
                response.sendRedirect("form/select/signInPersonError.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
