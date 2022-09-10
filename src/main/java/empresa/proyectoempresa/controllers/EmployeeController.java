package empresa.proyectoempresa.controllers;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.Employee;
import empresa.proyectoempresa.repositories.EmployeeRepository;

@RestController
@RequestMapping("/users")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    // metodo listar toda la tabla
    @GetMapping(value = "")
    public List<Employee> listar() {
        return repository.findAll();
    }

    // metodo listar un elemento por id
    @GetMapping(value = "/{idemp}")
    public Employee obtener(@PathVariable long idemp) {
        return repository.findById(idemp).get();
    }

    // metodo crear un registro
    @PostMapping(value = "/add")
    public Employee agregar(@RequestBody Employee employee) {
        employee.setCreated(LocalDate.now());
        employee.setUpdated(LocalDate.now());
        return repository.save(employee);
    }

    // metodo para editar registros con metodo PATCH
    @PatchMapping(value = "/{idemp}/update")
    public Employee actualizar(@PathVariable long idemp, @RequestBody Map<Object, Object> fields){
        Employee employee=repository.findById(idemp).get();
        fields.forEach((y,h)->{
            Field field= ReflectionUtils.findField(Employee.class, (String) y);
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
