package empresa.proyectoempresa.modelo;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="tbTransaction")
public class tbTransaction {

    //Atributos

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtran")
    private Integer idtran;

 
    @Column(name = "concept", length = 100)
    private String concept;

    @Column(name="amount")
    private Double amount;

    //Foreing Key
    //@ManyToOne
    //@JoinColumn(name="idemp", referencedColumnName = "idemp" )
    //private Double idemp;
    //Foreing Key
    //@ManyToOne
    //@JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    //private Double idEnt;

    
    @Column(name="createdAt")
    private Date createdAt;


    @Column(name="updatedAt")
    private Date updatedAt;
  
     
  
    
     //Cosntructor
                                                                    //Double idemp,Double idEnt,                                     
    public tbTransaction(Integer idtran, String concept, Double amount, Date createdAt,Date updatedAt) {
        this.idtran = idtran;
        this.concept = concept;
        this.amount = amount;
        //this.idemp = idemp;
        //this.idEnt = idEnt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
   
    public tbTransaction() {
    }

    //Getters and Setters
   

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

    //public Double getidemp() {
      //  return idemp;
    //}

    //public void setidemp(Double idemp) {
    //    this.idemp = idemp;
    //}

    //public Double getIdEnt() {
    //    return idEnt;
    //}

    //public void setIdEnt(Double idEnt) {
    //    this.idEnt = idEnt;
    //}

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

    public Integer getIdtran() {
        return idtran;
    }

    public void setIdtran(Integer idtran) {
        this.idtran = idtran;
    }
    

    


    


}
