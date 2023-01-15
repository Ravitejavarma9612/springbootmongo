package com.example.demomongo.noobcoderravivarma.Services;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonServiceinterface {
    List<Person> findAll();


    Optional<Person> findById(Long id);

    Long save(Person person);



    void saveoptional(Person p);

    void deleteperson(Person p);

    List<Person> findPersonBetweenAge(Integer min, Integer max);

    Page<Person> search(String name, Integer maxAge, Integer minAge, Pageable pageable);
}
