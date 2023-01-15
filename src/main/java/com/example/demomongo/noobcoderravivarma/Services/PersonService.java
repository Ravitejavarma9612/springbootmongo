package com.example.demomongo.noobcoderravivarma.Services;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import com.example.demomongo.noobcoderravivarma.Repository.personRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServiceinterface {
    @Autowired
    private personRepo personrepo;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    @Override
    public List<Person> findPersonBetweenAge(Integer min, Integer max) {
        return personrepo.findPersonBetweenAge(min, max);
    }

    @Override
    public Page<Person> search(String name, Integer maxAge, Integer minAge, Pageable pageable) {
        Query query = new Query().with(pageable);

        List<Criteria> criteria = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            criteria.add(Criteria.where("name").regex(name,"i"));
        }
        if(minAge !=null && maxAge !=null) {
            criteria.add(Criteria.where("age").gte(minAge).lte(maxAge));
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria()
                    .andOperator(criteria.toArray(new Criteria[0])));
        }
        System.out.println(criteria);

        Page<Person> people = PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Person.class
                ), pageable, () -> mongoTemplate.count(query.skip(0).limit(0),Person.class));
        return people;
    }


}
