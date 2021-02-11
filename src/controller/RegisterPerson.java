package controller;


import model.entity.Person;
import model.manager.PersonManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPerson extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        if (email != null && username != null && password != null && !(email.equals("")) && !(username.equals("")) && !(password.equals(""))) {

            PersonManager personManager = new PersonManager();
            response.sendRedirect("form/register/registerPersonResponse.jsp");
            try {
                personManager.registerPerson(new Person(email, username, password));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
