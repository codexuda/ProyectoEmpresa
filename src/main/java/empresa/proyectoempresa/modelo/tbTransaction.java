package empresa.proyectoempresa.modelo;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="tbTransaction")
public class tbTransaction {


    //Cosntructor vacio para que funcione el metodo get (find all)
    public tbTransaction(){

    }

    //Atributos

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTran")
    private Long idTran;

 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEmp", referencedColumnName = "idEmp" )
    private tbEmployee idEmp;
    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    private tbEnterprise idEnt;

    
    @Column(name="createdAt", nullable=true)
    private Date createdAt;


    @Column(name="updatedAt", nullable=true)
    private Date updatedAt;
  
     
  
    
     //Cosntructor

    public tbTransaction(Long idTran, String concept, Double amount, tbEmployee idEmp, tbEnterprise idEnt, Date createdAt,
            Date updatedAt) {
        this.idTran = idTran;
        this.concept = concept;
        this.amount = amount;
        this.idEmp = idEmp;
        this.idEnt = idEnt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //Getters and Setters


    public Long getIdTran() {
        return idTran;
    }




    public void setIdTran(Long idTran) {
        this.idTran = idTran;
    }




    public String getConcept() {
        return concept;
    }




    public void setConcept(String concept) {
        this.concept = concept;
    }




    public Double getAmount() {
        return amount;
    }




    public void setAmount(Double amount) {
        this.amount = amount;
    }




    public tbEmployee getIdEmp() {
        return idEmp;
    }




    public void setIdEmp(tbEmployee idEmp) {
        this.idEmp = idEmp;
    }




    public tbEnterprise getIdEnt() {
        return idEnt;
    }




    public void setIdEnt(tbEnterprise idEnt) {
        this.idEnt = idEnt;
    }




    public Date getCreatedAt() {
        return createdAt;
    }




    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




    public Date getUpdatedAt() {
        return updatedAt;
    }




    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    
    

    
    

    


    


}
