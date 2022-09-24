package empresa.proyectoempresa.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEnterprise;
import empresa.proyectoempresa.repositories.tbEnterpriseRepository;

//En desarrollo
@Service
 public class tbEnterpriseService {

    @Autowired
    private tbEnterpriseRepository repository;

    public List<tbEnterprise> listarEmpresas() {
        return repository.findAll();
    }


    public tbEnterprise agregarEmpresa(tbEnterprise enterprise){
        enterprise.setCreated(LocalDate.now());
        enterprise.setUpdated(LocalDate.now());
        return repository.save(enterprise);
    }

    public tbEnterprise obtenerEmpresa(@PathVariable long ident){
        return repository.findById(ident).get();
    }


    public tbEnterprise actualizarEmpresa(@PathVariable long ident, @RequestBody Map<Object, Object> fields){
        tbEnterprise enterprise=repository.findById(ident).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(tbEnterprise.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, enterprise, v);
        });
        enterprise.setUpdated(LocalDate.now());
        return repository.save(enterprise);
    }
    
    public String eliminarEmpresa(@PathVariable long ident){
        repository.delete(repository.findById(ident).get());
        return "Eliminada con exito";
    }

}
