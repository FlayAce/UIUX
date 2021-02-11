package controller;


import model.entity.Person;
import model.manager.PersonManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemovePerson extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) {

        long id = (Long.parseLong(request.getParameter("id")));
        try {
            PersonManager personManager = new PersonManager();
            Person person = new Person(id);
            personManager.removePerson(person);
            response.sendRedirect("observePerson.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
