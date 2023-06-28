package com.javaBrains.javaBrains.controller;

import com.javaBrains.javaBrains.entity.Person;
import com.javaBrains.javaBrains.repository.PersonRepository;
import com.javaBrains.javaBrains.service.graphl.GraphqlService;
import graphql.ExecutionResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonRepository personRepository;
    private final GraphqlService graphqlService;

    public PersonController(PersonRepository personRepository, GraphqlService graphqlService) {
        this.personRepository = personRepository;
        this.graphqlService = graphqlService;
    }

    @GetMapping("/people")
    public List<Person> findAllPeople(){
        return personRepository.findAll();
    }

    @PostMapping("/graphql/people")
    public ExecutionResult findAllPeople(@RequestBody String query){
        return graphqlService.getGraphQL().execute(query);
    }

}
