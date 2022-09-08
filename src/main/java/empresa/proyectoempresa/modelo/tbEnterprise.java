package empresa.proyectoempresa.modelo;


import java.sql.Date;

import javax.persistence.*;

@Entity
public class tbEnterprise  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ident;

    @Column(name="nameenterprise")
    private String nameenterprise;

    @Column(name="address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name="createdate")
    private Date createdate;

    @Column(name="updatedate")
    private Date updatedate;

    //Constructor
    public tbEnterprise(long ident, String nameenterprise, String address, String phone, Date createdate, Date updatedate) {
        this.ident = ident;
        this.nameenterprise = nameenterprise;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    // Getters & Setters
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getcreatedate() {
        return createdate;
    }
    public void setcreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getupdatedate() {
        return updatedate;
    }
    public void setupdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public long getIdent() {
        return ident;
    }
    public void setIdent(long ident) {
        this.ident = ident;
    }

    public String getNameenterprise() {
        return nameenterprise;
    }
    public void setNameenterprise(String nameenterprise) {
        this.nameenterprise = nameenterprise;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}




