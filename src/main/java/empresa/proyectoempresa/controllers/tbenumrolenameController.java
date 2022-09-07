package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbenumrolename;
import empresa.proyectoempresa.repositories.tbenumrolenameRepository;


@RestController
@RequestMapping("/role")
public class tbenumrolenameController {

    @Autowired
    private tbenumrolenameRepository repositories;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<tbenumrolename> listar() {
        return repositories.findAll();
    }

    @RequestMapping(value = "/obtener/{idrole}", method = RequestMethod.GET)
    public tbenumrolename obtener(@PathVariable long idrole) {
        return repositories.findById(idrole).get();
    }
    @RequestMapping(value="/agregar",method = RequestMethod.POST)
    public tbenumrolename crear(@RequestBody tbenumrolename role){
        return repositories.save(role);
     
    }

    //@RequestMapping(value="/modificar",method = RequestMethod.PUT)
    //public tbenumrolename actualizar(@RequestBody tbenumrolename role){
    //    return repositories.save(role);

    //metodo para editar registros
    @RequestMapping(value = "/update/{idrole}", method =  RequestMethod.PATCH)
    public tbenumrolename actualizar(@RequestBody tbenumrolename role){
        return repository.save(role);    
   
    }
    // metodo eliminar un registro
    @RequestMapping(value = "/eliminar/{idrole}", method = RequestMethod.DELETE)
    public String eliminarRole(@PathVariable long idrole) {
        tbenumrolename role=repository.findById(idrole).get();
        repository.delete(role);
        return "Eliminado con éxito";

}