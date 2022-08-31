package empresa.proyectoempresa;

import javax.persistence.*;
@Entity
public class Employee {
<<<<<<< HEAD
    @Column(name="createdate", nullable=true, length=undefined)
    private String createdate;
    private long idemp;
    @Column(name="updatedate", nullable=true, length=undefined)
    private String updatedate;
    @Column(name="email", nullable=true, length=100)
    private String email;
=======

    //Atributos
    private String nombre, rol, correo;
    private int nitEmpresa, idEmpleado;
    
    public Employee(String nombre, String correo, String rol, int id, int nit){
        this.nombre=nombre;
        this.correo=correo;
        this.idEmpleado=id;
        this.nitEmpresa=nit;
        this.rol=rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getCorreo() {
        return correo;
    }

    public int getNit() {
        return nitEmpresa;
    }

    public int getId() {
        return idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNit(int nit) {
        this.nitEmpresa = nit;
    }

    public void setId(int id) {
        this.idEmpleado = id;
    }
>>>>>>> 1bba0d65b9628dd60daf101efea208d3449c6e86
    
    public Employee() {}


    public String getcreatedate() {
        return createdate;
    }
    public void setcreatedate(String createdate) {
        this.createdate = createdate;
    }


    public long getIdemp() {
        return idemp;
    }
    public void setIdemp(long idemp) {
        this.idemp = idemp;
    }


    public String getupdatedate() {
        return updatedate;
    }
    public void setupdatedate(String updatedate) {
        this.updatedate = updatedate;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}