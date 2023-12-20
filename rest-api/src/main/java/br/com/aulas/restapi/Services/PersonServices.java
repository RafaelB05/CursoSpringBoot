package br.com.aulas.restapi.Services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aulas.restapi.Exception.ResourceNotFoundException;
import br.com.aulas.restapi.Models.Person;
import br.com.aulas.restapi.Repositories.PersonRepositories;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    @Autowired
    private PersonRepositories repositories;


    public List<Person> findAll(){

        return repositories.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one person");
        return repositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
    }

    public Person create(Person person){
        logger.info("Create one person");

        return repositories.save(person);
    }

    public Person update(Person person){
        logger.info("Update one person");

        Person entity = repositories.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return repositories.save(entity);
    }

    public void delete(Long id){
        Person entity = repositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        repositories.delete(entity);
    }
}
