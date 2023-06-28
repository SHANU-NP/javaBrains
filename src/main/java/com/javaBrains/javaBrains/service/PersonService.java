package com.javaBrains.javaBrains.service;

import com.javaBrains.javaBrains.entity.Person;
import com.javaBrains.javaBrains.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @PostConstruct
    private void init(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("shanu","np",123456L,"shanu@gmail.com","shanu 123 house"));
        personList.add(new Person("anu","np",2468L,"anu@gmail.com","anu 123 house"));
        personList.add(new Person("ishan","np",1357L,"ishan@gmail.com","ishan 123 house"));
        personList.add( new Person("anusha","np",25984L,"anusha@gmail.com","anusha 123 house"));
        personList.add(new Person("asha","np",123456L,"asha@gmail.com","asha 123 house"));
        personRepository.saveAll(personList);


    }
}
