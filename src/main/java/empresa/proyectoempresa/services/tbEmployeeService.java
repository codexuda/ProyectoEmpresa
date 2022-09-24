package empresa.proyectoempresa.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.modelo.tbEmployee;
import empresa.proyectoempresa.modelo.tbEnterprise;
import empresa.proyectoempresa.modelo.tbProfile;
import empresa.proyectoempresa.repositories.tbEmployeeRepository;
import empresa.proyectoempresa.repositories.tbEnterpriseRepository;
import empresa.proyectoempresa.repositories.tbProfileRepository;


@Service
public class tbEmployeeService {

   // metodo
   
   @Autowired
   private tbEmployeeRepository repository;
   @Autowired
   private tbEnterpriseRepository entRepo;
   @Autowired
   private tbProfileRepository profRepo;

   public List<tbEmployee> getAllEmployees() {
      return (List<tbEmployee>) this.repository.findAll();
   }

   // metodo

   // metodo crear un registro
   @PostMapping(value = "/add")
   public tbEmployee agregarUsuario(@RequestBody tbEmployee employee) {
      // Perfil por id
      Optional<tbProfile> optProfile = profRepo.findById(employee.getProfile().getId());
      tbProfile profile = optProfile.get();

      // Empresa por id
      Optional<tbEnterprise> optEnterprise = entRepo.findById(employee.getEnterprise().getId());
      tbEnterprise enterprise = optEnterprise.get();
      employee.setEnterprise(enterprise);
      employee.setProfile(profile);
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
   public tbEmployee actualizarUsuario(@PathVariable long idemp, @RequestBody Map<Object, Object> fields) {
      tbEmployee employee = repository.findById(idemp).get();
      fields.forEach((y, h) -> {
         Field field = ReflectionUtils.findField(tbEmployee.class, (String) y);
         field.setAccessible(true);
         ReflectionUtils.setField(field, employee, h);
      });
      employee.setUpdated(LocalDate.now());
      return repository.save(employee);
   }

   // metodo eliminar un registro
   @DeleteMapping(value = "/{idemp}/delete")
   public String eliminarUsuario(@PathVariable long idemp) {
      repository.delete(repository.findById(idemp).get());
      return "Eliminada con éxito";
   }

}
