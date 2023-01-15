package com.example.demomongo.noobcoderravivarma.Services;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import com.example.demomongo.noobcoderravivarma.Repository.personRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PersonService implements PersonServiceinterface {
     @Autowired
    private personRepo personrepo;

    @Override
    public List<Person> findAll() {
        return personrepo.findAll();
    }


    @Override
    public Optional<Person> findById(Long id) {
        return personrepo.findById(id);
    }

    public Long save(Person person) {
        return personrepo.save(person).getId();
    }

    @Override
    public void saveoptional(Person p) {
        personrepo.save(p);
    }

    @Override
    public void deleteperson(Person p) {
        personrepo.deleteById(p.getId());
    }


}
