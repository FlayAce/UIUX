package controller;


import model.manager.PersonManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ObservePerson extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PersonManager personManager = new PersonManager();
        try {
            request.setAttribute("personList", personManager.getPerson());
            request.getRequestDispatcher("form/select/observePerson.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
