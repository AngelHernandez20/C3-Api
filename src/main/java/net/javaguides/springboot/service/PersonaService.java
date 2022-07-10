package net.javaguides.springboot.service;

import net.javaguides.springboot.interfaceService.IpersonaService;
import net.javaguides.springboot.interfaces.IPersona;
import net.javaguides.springboot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IpersonaService {
    @Autowired
    private IPersona data;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return data.findById(   id);
    }

    @Override
    public int save(Persona p) {
        int res=0;
        Persona persona=data.save(p);
        if(!persona.equals(null)){
            res=1;

        }

        return 0;
    }

    @Override
    public void delete(int id) {
        data.deleteById(id);
    }
}
