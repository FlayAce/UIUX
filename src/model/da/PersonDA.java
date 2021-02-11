package model.da;

import model.entity.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDA {

    private Connection connection;
    private PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PersonDA() throws Exception {
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "amin", "myjava123");
    }

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT PERSON_SEQUENCE.NEXTVAL ID FROM DUAL");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("ID"));
        preparedStatement = connection.prepareStatement("INSERT INTO PERSON (ID, USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?, ?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getUsername());
        preparedStatement.setString(3, person.getPassword());
        preparedStatement.setString(4, person.getEmail());
        preparedStatement.executeUpdate();
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("UPDATE PERSON SET USERNAME = ? , PASSWORD = ? WHERE ID = 2");
        preparedStatement.setString(1, person.getUsername());
        preparedStatement.setString(2, person.getPassword());
//        preparedStatement.setLong(3, person.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID = ?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public ArrayList<Person> select() throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Person> personArrayList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person(resultSet.getLong("ID"), resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"), resultSet.getString("EMAIL"));
            personArrayList.add(person);
        }
        return personArrayList;
    }

    public ArrayList<Person> personSelected(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE username = ? AND password = ?");
        preparedStatement.setString(1, person.getUsername());
        preparedStatement.setString(2, person.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Person> personArrayList = new ArrayList<>();
        while (resultSet.next()) {
            personArrayList.add(new Person(resultSet.getLong("ID"), resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"), resultSet.getString("EMAIL")));
        }
        return personArrayList;
    }

    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
