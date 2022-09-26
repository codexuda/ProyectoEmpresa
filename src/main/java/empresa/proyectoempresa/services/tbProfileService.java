package empresa.proyectoempresa.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbProfile;
import empresa.proyectoempresa.repositories.tbProfileRepository;

@Service
public class tbProfileService {

    @Autowired
    tbProfileRepository repository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public tbProfile agregarPerfil(tbProfile profile){
        profile.setCreated(LocalDate.now());
        profile.setUpdated(LocalDate.now());
        return repository.save(profile);
    }
    
}
