package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbProfile;
import empresa.proyectoempresa.repositories.tbProfileRepository;


@RestController
@RequestMapping("/profile")
public class tbProfileController {

    @Autowired
    private tbProfileRepository repository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<tbProfile> listar() {
        return repository.findAll();

    }

    


    
}
