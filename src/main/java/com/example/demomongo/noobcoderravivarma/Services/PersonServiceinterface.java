package com.example.demomongo.noobcoderravivarma.Services;

import com.example.demomongo.noobcoderravivarma.Collections.Person;

import java.util.List;
import java.util.Optional;

public interface PersonServiceinterface {
    List<Person> findAll();


    Optional<Person> findById(Long id);

    Long save(Person person);



    void saveoptional(Person p);
}
