package empresa.proyectoempresa.modelo;


import java.sql.Date;

import javax.persistence.*;
@Entity
public class tbEnterprise  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ident;

    @Column(name="nameenterprise",  length=100)
    private String nameenterprise;

    @Column(name="address", nullable=true, length=150)
    private String address;

    @Column(name = "phone")
    private long phone;

    @Column(name="createdate", nullable=true)
    private Date createdate;

    @Column(name="updatedate", nullable=true)
    private Date updatedate;

    //Constructor
    public Enterprise(long ident, String nameenterprise, String address, long phone, Date createdate, Date updatedate) {
        this.ident = ident;
        this.nameenterprise = nameenterprise;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    // Getters & Setters
    public long getPhone() {
        return phone;
    }
    
    public void setPhone(long phone) {
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




