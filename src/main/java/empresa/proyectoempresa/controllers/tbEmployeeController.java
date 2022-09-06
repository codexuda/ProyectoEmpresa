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
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<tbEmployee> listar() {
        return repositories.findAll();
    }

    // metodo listar un elemento por id
    @RequestMapping(value = "/obtener/{idemp}", method = RequestMethod.GET)
    public tbEmployee obtener(@PathVariable long idemp) {
        return repositories.findById(idemp).getidemp();
    }

    // metodo listar un elemento por correo
    @RequestMapping(value = "/buscar/{email}", method = RequestMethod.GET)
    public tbEmployee buscar(@PathVariable long email) {
        return repositories.buscar(email);
    }

    // metodo crear un registro
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public tbEmployee crear(@RequestBody tbEmployee employee) {
        return repositories.save(employee);

    }

    // metodo editar un registro
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public tbEmployee actualizar(@RequestBody tbEmployee employee) {
        return repositories.save(employee);

    }

    // metodo eliminar un registro
    @RequestMapping(value = "/eliminar{idemp}", method = RequestMethod.DELETE)
    public tbEmployee eliminarEmpleado(@PathVariable long idemp) {
        return repositories.eliminarEmpleado(idemp);

    }
}
