package com.example.demomongo.noobcoderravivarma.Controllers;

import com.example.demomongo.noobcoderravivarma.Collections.Person;
import com.example.demomongo.noobcoderravivarma.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Person> getoneperson(@PathVariable Long id){
        return personService.findById(id);
    }
    @PostMapping("/create")
    public Long createrecord(@RequestBody Person person){
        return personService.save(person);
    }
}
