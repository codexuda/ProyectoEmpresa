package empresa.proyectoempresa.controllers;

import org.springframework.util.ReflectionUtils;
import empresa.proyectoempresa.repositories.tbTransactionRepository;
import empresa.proyectoempresa.modelo.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/enterprises/{enterprise}/movements")
public class tbTransactionController {
    //Ruta anterior: transactions   
    @Autowired
    private tbTransactionRepository repositiorio;

    //Listar todas las transacciones----GET
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<tbTransaction> listarTransaccion() {
        return repositiorio.findAll();

    }
    //Consultar un transaccion por ID---"
    @RequestMapping(value = "/get/{idTran}", method = RequestMethod.GET)
    public tbTransaction buscartransaccion(@PathVariable long idTran) {
        return repositiorio.findById(idTran).get();
    }

     //Actulización parcial -- PATCH
     @RequestMapping(value = "/update/{idTran}", method =  RequestMethod.PATCH)
     public tbTransaction actualizar(@RequestBody tbTransaction tbtransaction){
     return repositiorio.save(tbtransaction);
     }
    //Agregar transaccion-----POST
    @RequestMapping (value = "/add",method = RequestMethod.POST)
     public tbTransaction create(@RequestBody tbTransaction tbtransaction){  
        return repositiorio.save(tbtransaction) ;
    }
    //Eliminar transaccion----delete
    @DeleteMapping(value = "delete/{idTran}")
    public String eliminar(@PathVariable long idTran){
        repositiorio.delete(repositiorio.findById(idTran).get());
        return "Eliminada con exito";

    }

    @PatchMapping(value = "/{idTran}/update" )
    public tbTransaction actualizar(@PathVariable long idTran, @RequestBody Map<Object, Object> fields){
        tbTransaction transaction=repositiorio.findById(idTran).get();
        fields.forEach((k,v)->{
            Field field= ReflectionUtils.findField(tbTransaction.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, transaction, v);
        });
        transaction.setUpdatedAt(LocalDate.now());       
        return repositiorio.save(transaction);

    }
   }    


