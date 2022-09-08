package empresa.proyectoempresa.modelo;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class tbEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private Long idemp;
    
    @Column(name = "email", length = 100, unique = true)
    private String email;
    
    
    @ManyToOne
    @JoinColumn(name = "idprof", referencedColumnName = "idprof" )
    private tbProfile profile;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="idrole")
    private tbenumrolename Enumrolename;

    @ManyToOne
    @JoinColumn(name = "ident", referencedColumnName = "ident")
    private tbEnterprise enterprise;

    @Column(name = "updatedate", nullable = true)
    private Date updatedate;

    @Column(name = "createdate", nullable = true)
    private Date createdate;

    public tbEmployee(Long idemp, String email, tbProfile idprof, tbenumrolename idrole, tbEnterprise ident, Date updatedate, Date createdate) {
        this.idemp = idemp;
        this.email = email;
        this.profile = idprof;
        this.Enumrolename = idrole;
        this.enterprise = ident;
        this.updatedate = updatedate;
        this.createdate = createdate;
    }

    public Long getIdemp() {
        return idemp;
    }

    public void setIdemp(Long idemp) {
        this.idemp = idemp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public tbProfile getProfile() {
        return profile;
    }

    public void setProfile(tbProfile profile) {
        this.profile = profile;
    }

    public tbenumrolename getEnumrolename() {
        return Enumrolename;
    }

    public void setEnumrolename(tbenumrolename enumrolename) {
        Enumrolename = enumrolename;
    }

    public tbEnterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(tbEnterprise enterprise) {
        this.enterprise = enterprise;
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
