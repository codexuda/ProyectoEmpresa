package empresa.proyectoempresa.modelo;

import javax.persistence.*;
@Entity
public class enumrolename  {
    
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrole")
    private Long idrole;

    @Column(name="roles",  length=100)
    private String roles;
    
    public enumrolename(Long idrole, String roles) {
        this.idrole = idrole;
        this.roles = roles;
    }


    public long getIdrole() {
        return idrole;
    }
    public void setIdrole(long idrole) {
        this.idrole = idrole;
    }


    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }


}