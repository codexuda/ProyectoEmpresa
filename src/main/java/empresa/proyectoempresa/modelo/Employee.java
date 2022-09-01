package empresa.proyectoempresa.modelo;

import java.sql.Date;

import javax.persistence.*;
@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private Long idemp;
    @Column(name="email", length=100)
    private String email;
    private long idprof;
    private long idrole;
    private long ident;
    
    @Column(name="updatedate", nullable=true)
    private Date updatedate;
    @Column(name="createdate", nullable = true)
    private Date createdate;
 
    
    public Employee() {}

    public long getIdemp() {
        return idemp;
    }
    public void setIdemp(long idemp) {
        this.idemp = idemp;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public long getIdprof() {
        return idprof;
    }
    public void setIdprof(long idprof) {
        this.idprof = idprof;
    }


    public long getIdrole() {
        return idrole;
    }
    public void setIdrole(long idrole) {
        this.idrole = idrole;
    }


    public long getIdent() {
        return ident;
    }
    public void setIdent(long ident) {
        this.ident = ident;
    }


    public Date getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }


    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }


}