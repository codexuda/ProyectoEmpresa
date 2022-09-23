package empresa.proyectoempresa.services;

import java.util.List;

import empresa.proyectoempresa.modelo.tbEmployee;
import empresa.proyectoempresa.repositories.tbEmployeeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class tbEmployeeService {

   @Autowired
   private tbEmployeeRepository tbEmployeeRepository;

   public List<tbEmployee> getAllEmployees() {
      return (List<tbEmployee>) this.tbEmployeeRepository.findAll();
   }

}
