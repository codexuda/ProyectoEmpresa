package empresa.proyectoempresa.controllers;

import org.springframework.util.ReflectionUtils;

import empresa.proyectoempresa.repositories.TransactionRepository;
import empresa.proyectoempresa.modelo.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;


@RestController
@RequestMapping("/enterprises")
public class TransactionController {
    //Ruta anterior: transactions   
    @Autowired
    private TransactionRepository repository;

    //Listar todas las transacciones----GET
    @GetMapping(value = "/{enterprise}/movements")
    public List<Transaction> transaccionesPorEmpresa(@PathVariable Enterprise enterprise) {
        return repository.findByEnterpriseId(enterprise.getId());
    }
    
    //Consultar un transaccion por ID---"
    @GetMapping(value = "/{enterprise}/movements/{idTran}")
    public Transaction transaccionesPorId(@PathVariable long idtran) {
        return repository.findById(idtran).get();
    }

    //Agregar transaccion-----POST
    @PostMapping(value = "/{enterprise}/movements/add")
     public Transaction create(@RequestBody Transaction transaction, @PathVariable Enterprise enterprise){
        transaction.setEnterprise(enterprise);
        transaction.setCreated(LocalDate.now());
        transaction.setUpdated(LocalDate.now()); 
        return repository.save(transaction) ;
    }
    //Eliminar transaccion----delete
    @DeleteMapping(value = "/{enterprise}/movements/{idTran}/delete")
    public String eliminar(@PathVariable long idtran){
        repository.delete(repository.findById(idtran).get());
        return "Eliminada con exito";

    }
    //Editar parcialmente ---- PATCH
    @PatchMapping(value = "/{enterprise}/movements/{idTran}/update" )
    public Transaction actualizar(@PathVariable long idtran, @RequestBody Map<Object, Object> fields){
        Transaction transaction=repository.findById(idtran).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(Transaction.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, transaction, v);
        });
        transaction.setUpdated(LocalDate.now());       
        return repository.save(transaction);

    }
   }    


