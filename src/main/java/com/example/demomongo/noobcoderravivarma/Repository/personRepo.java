package com.example.demomongo.noobcoderravivarma.Repository;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface personRepo extends MongoRepository<Person,Long> {

    @Query(value = "{'age' : {$gt : ?0,$lt : ?1}}", fields = "{address : 0}")
    List<Person> findPersonBetweenAge(Integer min ,Integer max);


}
