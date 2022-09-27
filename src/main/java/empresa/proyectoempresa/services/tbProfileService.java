package empresa.proyectoempresa.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import empresa.proyectoempresa.modelo.tbProfile;
import empresa.proyectoempresa.repositories.tbProfileRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public List<tbProfile> listarPerfiles() {
        return repository.findAll();
    }

    @RequestMapping(value="/getlast", method=RequestMethod.GET)
    public tbProfile getLast() {
        List<tbProfile> perfiles=listarPerfiles();
        tbProfile lastProfile=perfiles.get(perfiles.size()-1);
        return lastProfile;
    }
    
}
