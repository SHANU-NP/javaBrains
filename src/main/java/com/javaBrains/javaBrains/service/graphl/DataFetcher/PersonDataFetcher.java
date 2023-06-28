package com.javaBrains.javaBrains.service.graphl.DataFetcher;

import com.javaBrains.javaBrains.entity.Person;
import com.javaBrains.javaBrains.repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

@Component
public class PersonDataFetcher implements DataFetcher<Person> {

    private final PersonRepository personRepository;

    public PersonDataFetcher(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person get(DataFetchingEnvironment environment) throws Exception {
        String email = environment.getArgument("email");
        return  personRepository.findByEmail(email);
    }
}
