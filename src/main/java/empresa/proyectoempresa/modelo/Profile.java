package empresa.proyectoempresa.modelo;

import javax.persistence.*;
@Entity
public class Profile {
    @Id
    private long idprof;
    private long phone;
    @Column(name="createdate", nullable=true)
    private String createdate;
    @Column(name="updatedate", nullable=true)
    private String updatedate;
    @Column(name="image", nullable=true, length=100)
    private String image;
    @Column(name="userp", nullable=true, length=100)
    private String userp;
    
    public Profile() {}

    public long getIdprof() {
        return idprof;
    }
    public void setIdprof(long idprof) {
        this.idprof = idprof;
    }


    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }


    public String getcreatedate() {
        return createdate;
    }
    public void setcreatedate(String createdate) {
        this.createdate = createdate;
    }


    public String getupdatedate() {
        return updatedate;
    }
    public void setupdatedate(String updatedate) {
        this.updatedate = updatedate;
    }


    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    public String getUserp() {
        return userp;
    }
    public void setUserp(String userp) {
        this.userp = userp;
    }


}