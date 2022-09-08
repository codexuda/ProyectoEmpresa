package empresa.proyectoempresa.controllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEnterprise;
import empresa.proyectoempresa.repositories.tbEnterpriseRepository;

@RestController
@RequestMapping("/enterprises")
public class tbEnterpriseController {
    @Autowired
    private tbEnterpriseRepository repository;

    @GetMapping(value = "/list")
    public List<tbEnterprise> listar() {
        return repository.findAll();
    }

    @PostMapping(value = "/add")
    public tbEnterprise agregar(@RequestBody tbEnterprise enterprise){
        enterprise.setCreated(LocalDate.now());
        enterprise.setUpdated(LocalDate.now());
        return repository.save(enterprise);
    }
    

    //Por ID
    @GetMapping(value = "/{ident}")
    public tbEnterprise obtener(@PathVariable long ident){
        return repository.findById(ident).get();
    }

    /*@PatchMapping(value = "/update/{ident}")
    public tbEnterprise actualizar(@PathVariable long ident, tbEnterprise enterprise_upd){
        tbEnterprise enterprise=repository.findById(ident).get();
        enterprise.setName(enterprise_upd.getName());
        enterprise.setAddress(enterprise_upd.getAddress());
        enterprise.setPhone(enterprise_upd.getPhone());
        enterprise.setCreated(enterprise_upd.getCreated());
        enterprise.setUpdated(enterprise_upd.getUpdated());
        return repository.save(enterprise);
    }*/
    @PatchMapping(value = "/{ident}/update" )
    public tbEnterprise actualizar(@PathVariable long ident, @RequestBody Map<Object, Object> fields){
        tbEnterprise enterprise=repository.findById(ident).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(tbEnterprise.class, (String) k);
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
