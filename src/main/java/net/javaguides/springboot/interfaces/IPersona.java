package net.javaguides.springboot.interfaces;

import net.javaguides.springboot.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
