package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.repositories.tbEmployeeRepository;
import empresa.proyectoempresa.modelo.*;

@RestController
@RequestMapping("/employee")
public class tbEmployeeController {

    @Autowired
    private tbEmployeeRepository repository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<tbEmployee> listar() {
        return repository.findAll();
    }

}
