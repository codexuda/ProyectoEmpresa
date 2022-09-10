package empresa.proyectoempresa.controllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.Profile;
import empresa.proyectoempresa.repositories.ProfileRepository;


@RestController
@RequestMapping("/profile")
public class ProfileController {


    @Autowired
    private ProfileRepository repository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Profile> listar() {
        return repository.findAll();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Profile agregar(@RequestBody Profile profile){
        profile.setCreated(LocalDate.now());
        profile.setUpdated(LocalDate.now());
        return repository.save(profile);
    }

    @PatchMapping(value = "/{idprof}/update")
    public Profile actualizar(@PathVariable long idprof, @RequestBody Map<Object, Object> fields){
        Profile profile=repository.findById(idprof).get();
        fields.forEach((key,value)->{
            Field field= ReflectionUtils.findField(Profile.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, profile, value);
        });
        profile.setUpdated(LocalDate.now());
        return repository.save(profile);
    }
}
