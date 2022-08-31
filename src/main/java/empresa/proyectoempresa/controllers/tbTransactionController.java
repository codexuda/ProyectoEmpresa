package empresa.proyectoempresa.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import empresa.proyectoempresa.repositories.tbTransactionRepository;


@RestController
@RequestMapping ("/transaction")
public class tbTransactionController {

    @Autowired
    private tbTransactionRepository repositiorio;

}
