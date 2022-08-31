package empresa.proyectoempresa;
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
