package net.javaguides.springboot.controler;
import net.javaguides.springboot.interfaceService.IpersonaService;
import net.javaguides.springboot.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

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
}
