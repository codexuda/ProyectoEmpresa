package empresa.proyectoempresa;
<<<<<<< HEAD

import javax.persistence.*;
@Entity
public class Enterprise  {
    private long phone;
    @Column(name="createdate", nullable=true, length=undefined)
    private String createdate;
    @Column(name="updatedate", nullable=true, length=undefined)
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
=======
public class Enterprise {

    //Atributos
    private String name,document,phone,adress;
    private long id;

      
    //getters and setters
    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDocument() {
        return document;
    }
    public void setDocument(String document) {
        this.document = document;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

     //Constructor
     public Enterprise(String name, String document, String phone, String adress, long id) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.adress = adress;
        this.id = id;
    }

}
>>>>>>> 1bba0d65b9628dd60daf101efea208d3449c6e86
