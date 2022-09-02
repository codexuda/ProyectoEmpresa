package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.repositories.tbenumrolenameRepository;
import empresa.proyectoempresa.modelo.*;

@RestController
@RequestMapping("/role")
public class tbenumrolenameController {

    @Autowired
    private tbenumrolenameRepository repository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<tbenumrolename> listar() {
        return repository.findAll();
    }

}