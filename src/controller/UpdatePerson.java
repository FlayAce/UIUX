package controller;

import jdk.nashorn.internal.runtime.ECMAException;
import model.entity.Person;
import model.manager.PersonManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdatePerson extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        if (username != null && password != null && !(username.equals("")) && !(password.equals(""))){
            PersonManager personManager = new PersonManager();
            try {
                personManager.updatePerson(new Person(username,password));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
