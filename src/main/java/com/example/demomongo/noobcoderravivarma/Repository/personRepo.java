package com.example.demomongo.noobcoderravivarma.Repository;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface personRepo extends MongoRepository<Person,Long> {
}
