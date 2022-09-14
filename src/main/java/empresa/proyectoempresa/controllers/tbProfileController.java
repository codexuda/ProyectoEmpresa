package empresa.proyectoempresa.controllers;

import java.time.LocalDate;
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


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public tbProfile agregar(@RequestBody tbProfile profile){
        profile.setCreated(LocalDate.now());
        return repository.save(profile);
    }


    @RequestMapping(value="/modificar",method = RequestMethod.PUT)
    public tbProfile actualizar(@RequestBody tbProfile profile){
        return repository.save(profile);
     
    }
}
