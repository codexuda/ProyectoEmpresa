package empresa.proyectoempresa;

import javax.persistence.*;
@Entity
public class Employee {
    @Column(name="createdate", nullable=true, length=undefined)
    private String createdate;
    private long idemp;
    @Column(name="updatedate", nullable=true, length=undefined)
    private String updatedate;
    @Column(name="email", nullable=true, length=100)
    private String email;
    
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