package br.com.aulas.restapi.Services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aulas.restapi.Data.Vo.PersonVO;
import br.com.aulas.restapi.Exception.ResourceNotFoundException;
import br.com.aulas.restapi.Mapper.Mapper;
import br.com.aulas.restapi.Models.Person;
import br.com.aulas.restapi.Repositories.PersonRepositories;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    private Mapper mapper = new Mapper();
    
    @Autowired
    private PersonRepositories repositories;


    public List<PersonVO> findAll(){

        return mapper.parseListObject(repositories.findAll(),PersonVO.class); 
    }

    public PersonVO findById(Long id){
        logger.info("Finding one person");
        Person entity = repositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return mapper.parseObject(entity,PersonVO.class); 
    }

    public PersonVO create(PersonVO person){
        logger.info("Create one person");

        Person entity =  mapper.parseObject(person,Person.class);

        return mapper.parseObject(repositories.save(entity),PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        logger.info("Update one person");

        Person entity = repositories.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());

        return mapper.parseObject(repositories.save(entity),PersonVO.class) ;
    }

    public void delete(Long id){
        Person entity = repositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        repositories.delete(entity);
    }
}
