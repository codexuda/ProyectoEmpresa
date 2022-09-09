package empresa.proyectoempresa.controllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEmployee;
import empresa.proyectoempresa.repositories.tbEmployeeRepository;

@RestController
@RequestMapping("/employee")
public class tbEmployeeController {
    @Autowired
    private tbEmployeeRepository repository;

    // metodo listar toda la tabla
    @GetMapping(value = "")
    public List<tbEmployee> listar() {
        return repository.findAll();
    }

    // metodo listar un elemento por id
    @GetMapping(value = "/{idemp}")
    public tbEmployee obtener(@PathVariable long idemp) {
        return repository.findById(idemp).get();
    }

    // metodo crear un registro
    @PostMapping(value = "/add")
    public tbEmployee agregar(@RequestBody tbEmployee employee) {
        employee.setCreated(LocalDate.now());
        employee.setUpdated(LocalDate.now());
        return repository.save(employee);
    }

    // metodo editar un registro con el metodo PUT
    // @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    // public tbEmployee actualizar(@RequestBody tbEmployee employee) {
    // return repository.save(employee);
    // }

    // metodo para editar registros con metodo PATCH
    @PatchMapping(value = "/{idemp}/update")
    public tbEmployee actualizar(@PathVariable long idemp, @RequestBody Map<Object, Object> fields){
        tbEmployee employee=repository.findById(idemp).get();
        fields.forEach((y,h)->{
            Field field= ReflectionUtils.findField(clazz: tbEmployee.class, (String) y);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employee, h);
        });
        employee.setUpdated(LocalDate.now());
        return repository.save(employee);
    }

    // metodo eliminar un registro
    @DeleteMapping(value = "/{idemp}/delete")
    public String eliminar(@PathVariable long idemp) {
        repository.delete(repository.findById(idemp).get());
        return "Eliminada con éxito";
    }

}
