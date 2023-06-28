package com.javaBrains.javaBrains.service.graphl.DataFetcher;

import com.javaBrains.javaBrains.entity.Person;
import com.javaBrains.javaBrains.repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleDataFetcher implements DataFetcher<List<Person>> {
    private final PersonRepository personRepository;

    public PeopleDataFetcher(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> get(DataFetchingEnvironment environment) throws Exception {
        return personRepository.findAll();
    }
}
