package com.example.demomongo.noobcoderravivarma.Controllers;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import com.example.demomongo.noobcoderravivarma.Exceptions.InputIncorrectException;
import com.example.demomongo.noobcoderravivarma.Exceptions.UserNotFoundException;
import com.example.demomongo.noobcoderravivarma.Services.PersonService;
import com.fasterxml.classmate.ResolvedTypeWithMembers;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.mongodb.core.query.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class Personcontroller {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons",produces = "application/json")
    public List<Person> getallperson(){
        return personService.findAll();
    }
    @GetMapping("/person/{id}")
    public Optional<Person> getOnePerson(@PathVariable Long id){
        return personService.findById(id);
    }
    @PostMapping("/create")
    public Long createRecord(@RequestBody Person person){
        return personService.save(person);
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Person> updateDetails(@RequestBody Person person, @PathVariable long id) throws UserNotFoundException {
        Person p = getOnePerson(id).orElseThrow(()-> new UserNotFoundException("user not found"));
        p.setName(person.getName());
        p.setAddress(person.getAddress());
        p.setAge(person.getAge());
        personService.saveoptional(p);
     return ResponseEntity.ok(p);
    }
    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable long id) throws UserNotFoundException {
        Person p = getOnePerson(id).orElseThrow(()-> new UserNotFoundException("user not found"));
        personService.deleteperson(p);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @GetMapping("/fetchapi")
    public List<Person> fetchPersonBetweenAge(@RequestParam Integer min ,@RequestParam Integer max) throws InputIncorrectException {
        if(min > max){
            throw new InputIncorrectException("Min age should not be greater than Max age");
        }
        return personService.findPersonBetweenAge(min,max);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size){

        Pageable pageable = PageRequest.of(page,size);

        return personService.search(name,maxAge,minAge,pageable);

    }
}
