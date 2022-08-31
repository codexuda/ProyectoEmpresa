package empresa.proyectoempresa.modelo;


import javax.persistence.*;
@Entity
public class Enterprise  {
    private long phone;
    @Column(name="createdate", nullable=true)
    private String createdate;
    @Column(name="updatedate", nullable=true)
    private String updatedate;
    private long ident;
    @Column(name="nameenterprise",  length=100)
    private String nameenterprise;
    @Column(name="address", nullable=true, length=150)
    private String address;
    
    public Enterprise () {}

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



