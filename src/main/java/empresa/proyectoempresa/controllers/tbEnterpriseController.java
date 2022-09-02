package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEnterprise;
import empresa.proyectoempresa.repositories.tbEnterpriseRepository;

@RestController
@RequestMapping("/enterprises")
public class tbEnterpriseController {
    @Autowired
    private tbEnterpriseRepository repository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<tbEnterprise> list() {
        return repository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public tbEnterprise agregar(@RequestBody tbEnterprise enterprise){
        return repository.save(enterprise);
    }
    
    @RequestMapping(value = "/get/{ident}", method =  RequestMethod.GET)
    public tbEnterprise obtener(@PathVariable long ident){
        return repository.findById(ident).get();
    }


    //En desarrollo
    @RequestMapping(value = "/update/{ident}", method =  RequestMethod.PATCH)
    public tbEnterprise actualizar(@RequestBody tbEnterprise enterprise){
        return repository.save(enterprise);
    }
    //En desarrollo
    @RequestMapping(value = "/delete/{ident}", method = RequestMethod.DELETE)
    public String eliminar(@PathVariable long ident){
        tbEnterprise enterprise=repository.findById(ident).get();
        repository.delete(enterprise);
        return "Eliminada con exito";
    }
}
