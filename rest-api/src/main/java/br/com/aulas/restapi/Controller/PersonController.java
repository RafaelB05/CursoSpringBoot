package br.com.aulas.restapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.aulas.restapi.Data.Vo.PersonVO;
import br.com.aulas.restapi.Services.PersonServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;


    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id")Long id) throws Exception{
        return service.findById(id);
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return service.findAll();
    }
    
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO creatPerson(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PutMapping(value = "", produces =  MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO person) {
        return service.update(person);
    }
    
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id")Long id) throws Exception{
        service.delete(id);
    }

}
