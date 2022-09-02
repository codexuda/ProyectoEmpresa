package empresa.proyectoempresa.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class tbEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private long idemp;
    
    @Column(name = "email", length = 100, unique = true)
    private String email;
    
    
    @ManyToOne
    @JoinColumn(name = "idprof", referencedColumnName = "idprof" )
    private Profile profile;
    
    @ManyToOne
    @JoinColumn(name ="idrole", referencedColumnName = "idrole")
    private tbenumrolename Enumrolename;

    @ManyToOne
    @JoinColumn(name = "ident", referencedColumnName = "ident")
    private tbEnterprise tbenterprise;

    @Column(name = "updatedate", nullable = true)
    private Date updatedate;
    @Column(name = "createdate", nullable = true)
    private Date createdate;

    public tbEmployee(Long idemp, String email, long idprof, long idrole, long ident, Date updatedate, Date createdate) {
        this.idemp = idemp;
        this.email = email;
        this.idprof = idprof;
        this.idrole = idrole;
        this.ident = ident;
        this.updatedate = updatedate;
        this.createdate = createdate;
    }

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

    public Profile getProfile() {
        return profile;
    }

    public void setIdprof(Profile profile) {
        this.profile = profile;
    }

    public tbenumrolename getenumrolename() {
        return Enumrolename;
    }

    public void setIdrole(tbenumrolename Enumrolename) {
        this.Enumrolename = Enumrolename;
    }

    public tbEnterprise gettbEnterprise() {
        return tbenterprise;
    }

    public void setIdent(tbEnterprise tbenterprise) {
        this.tbenterprise = tbenterprise;
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