package br.com.aulas.restapi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aulas.restapi.Models.Person;

@Repository
public interface PersonRepositories extends JpaRepository<Person,Long> {}
