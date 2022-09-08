package empresa.proyectoempresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEmployee;
import empresa.proyectoempresa.repositories.tbEmployeeRepository;

@RestController
@RequestMapping("/employee")
public class tbEmployeeController {
    @Autowired
    private tbEmployeeRepository repository;

    // metodo listar toda la tabla
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<tbEmployee> listar() {
        return repository.findAll();
    }

    // metodo listar un elemento por id
    @RequestMapping(value = "/get/{idemp}", method = RequestMethod.GET)
    public tbEmployee obtener(@PathVariable long idemp) {
        return repository.findById(idemp).get();
    }

    // metodo crear un registro
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public tbEmployee crear(@RequestBody tbEmployee employee) {
        return repository.save(employee);

    }

    // metodo editar un registro
    //@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    //public tbEmployee actualizar(@RequestBody tbEmployee employee) {
    //    return repository.save(employee);
    //}

    //metodo para editar registros
    @RequestMapping(value = "/update/{idemp}", method =  RequestMethod.PATCH)
    public tbEmployee actualizar(@RequestBody tbEmployee employee){
        return repository.save(employee);
    }

    // metodo eliminar un registro
    @RequestMapping(value = "/delete/{idemp}", method = RequestMethod.DELETE)
    public String eliminarEmpleado(@PathVariable long idemp) {
        tbEmployee employee=repository.findById(idemp).get();
        repository.delete(employee);
        return "Eliminado con éxito";
    }
}
