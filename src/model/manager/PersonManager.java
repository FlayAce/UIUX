package model.manager;


import model.da.PersonDA;
import model.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

    public void registerPerson(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.insert(person);
        personDA.close();
    }

    public void removePerson(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        personDA.delete(person);
        personDA.close();
    }

    public ArrayList<Person> getPerson() throws Exception {
        PersonDA personDA = new PersonDA();
        ArrayList<Person> personArrayList = personDA.select();
        personDA.close();
        return personArrayList;
    }

    public boolean findPerson(Person person) throws Exception {
        PersonDA personDA = new PersonDA();
        try {
            List<Person> personList = personDA.personSelected(person);
            personDA.close();
            if (personList != null && personList.size() != 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void updatePerson(Person person) throws Exception{
        PersonDA personDA = new PersonDA();
        personDA.update(person);
        personDA.close();
    }
}

