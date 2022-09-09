package empresa.proyectoempresa.controllers;

import org.springframework.util.ReflectionUtils;

import empresa.proyectoempresa.repositories.tbEnterpriseRepository;
import empresa.proyectoempresa.repositories.tbTransactionRepository;
import empresa.proyectoempresa.modelo.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;


@RestController
@RequestMapping("/enterprises")
public class tbTransactionController {
    //Ruta anterior: transactions   
    @Autowired
    private tbTransactionRepository repository;

    //Listar todas las transacciones----GET
    @GetMapping(value = "/{enterprise}/movements")
    public List<tbTransaction> transaccionesPorEmpresa(@PathVariable tbEnterprise enterprise) {
        return repository.findByEnterpriseId(enterprise.getId());
    }
    
    //Consultar un transaccion por ID---"
    @GetMapping(value = "/{enterprise}/movements/{idTran}")
    public tbTransaction transaccionesPorId(@PathVariable long idTran) {
        return repository.findById(idTran).get();
    }

    //Agregar transaccion-----POST
    @PostMapping(value = "/{enterprise}/movements/add")
     public tbTransaction create(@RequestBody tbTransaction transaction, @PathVariable tbEnterprise enterprise){
        transaction.setEnterprise(enterprise);
        transaction.setCreatedAt(LocalDate.now());
        transaction.setUpdatedAt(LocalDate.now()); 
        return repository.save(transaction) ;
    }
    //Eliminar transaccion----delete
    @DeleteMapping(value = "/{enterprise}/movements/{idTran}/delete")
    public String eliminar(@PathVariable long idTran){
        repository.delete(repository.findById(idTran).get());
        return "Eliminada con exito";

    }
    //Editar parcialmente ---- PATCH
    @PatchMapping(value = "/{enterprise}/movements/{idTran}/update" )
    public tbTransaction actualizar(@PathVariable long idTran, @RequestBody Map<Object, Object> fields){
        tbTransaction transaction=repository.findById(idTran).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(tbTransaction.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, transaction, v);
        });
        transaction.setUpdatedAt(LocalDate.now());       
        return repository.save(transaction);

    }
   }    


