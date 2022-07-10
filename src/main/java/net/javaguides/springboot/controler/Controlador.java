package net.javaguides.springboot.controler;
import net.javaguides.springboot.interfaceService.IpersonaService;
import net.javaguides.springboot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
@RestController
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping ("/")
    public String hellow(){
        return "Hola Mundo";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona>personas=service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona",new Persona());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Persona p, Model model){
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona>persona=service.listarId(id);
        model.addAttribute("persona",persona);
        return "form";
    }

    @GetMapping ("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/listar";
    }
}
