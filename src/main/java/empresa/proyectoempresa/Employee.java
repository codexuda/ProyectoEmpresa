package empresa.proyectoempresa;
public class Employee {

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
    
}
