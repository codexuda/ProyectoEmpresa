package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.Profile;
import empresa.proyectoempresa.repositories.ProfileRepository;


@RestController
@RequestMapping("/profile")
public class ProfileController {


    @Autowired
    private ProfileRepository repository;


    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Profile> listar() {
        return repository.findAll();

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Profile agregar(@RequestBody Profile profile){
        return repository.save(profile);
    }


    @RequestMapping(value="/modificar",method = RequestMethod.PUT)
    public Profile actualizar(@RequestBody Profile profile){
        return repository.save(profile);
     
    }
}
