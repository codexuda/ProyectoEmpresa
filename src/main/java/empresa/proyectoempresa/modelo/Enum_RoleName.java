package empresa.proyectoempresa.modelo;

import javax.persistence.*;

@Table(name = "idRole")
public enum Enum_RoleName {
    ADMIN, 
    OPERARIO
}