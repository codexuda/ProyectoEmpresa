package empresa.proyectoempresa.controllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.Enterprise;
import empresa.proyectoempresa.repositories.EnterpriseRepository;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {
    @Autowired
    private EnterpriseRepository repository;

    @GetMapping(value = "")
    public List<Enterprise> listar() {
        return repository.findAll();
    }

    @PostMapping(value = "/add")
    public Enterprise agregar(@RequestBody Enterprise enterprise){
        enterprise.setCreated(LocalDate.now());
        enterprise.setUpdated(LocalDate.now());
        return repository.save(enterprise);
    }
    

    //Por ID
    @GetMapping(value = "/{ident}")
    public Enterprise obtener(@PathVariable long ident){
        return repository.findById(ident).get();
    }


    //PATCH
    @PatchMapping(value = "/{ident}/update" )
    public Enterprise actualizar(@PathVariable long ident, @RequestBody Map<Object, Object> fields){
        Enterprise enterprise=repository.findById(ident).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(Enterprise.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, enterprise, v);
        });
        enterprise.setUpdated(LocalDate.now());
        return repository.save(enterprise);

    }

    @DeleteMapping(value = "/{ident}/delete")
    public String eliminar(@PathVariable long ident){
        repository.delete(repository.findById(ident).get());
        return "Eliminada con exito";
    }

    
}
