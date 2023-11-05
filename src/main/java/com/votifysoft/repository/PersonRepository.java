package com.votifysoft.repository;

import java.util.ArrayList;
import java.util.List;

import com.votifysoft.voter.Person;

public class PersonRepository {
    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person(1, "Barack Obama", 0));
        persons.add(new Person(2, "Elon Musk", 0));
        persons.add(new Person(3, "Cyril Muchiri", 0));
        persons.add(new Person(4, "Lopkoiyan", 0));
    }

    public static List<Person> getPersons() {
        return persons;
    }

    public static void voteForPerson(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                person.setVotes(person.getVotes() + 1);
                break;
            }
        }
    }
}

