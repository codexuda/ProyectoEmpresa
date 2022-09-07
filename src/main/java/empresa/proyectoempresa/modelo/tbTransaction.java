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
    private Long idtran;

 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    //@ManyToOne
    //@JoinColumn(name="idemp", referencedColumnName = "idemp" )
    //private Double idemp;
    //Foreing Key
    //@ManyToOne
    //@JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    //private Double idEnt;

    
    @Column(name="createdAt", nullable=true)
    private String createdAt;


    @Column(name="updatedAt", nullable=true)
    private Date updatedAt;
  
     
  
    
     //Cosntructor
                                                                    //Double idemp,Double idEnt,                                     
    public tbTransaction(Long idtran, String concept, Double amount, String createdAt,
            Date updatedAt) {
        this.idtran = idtran;
        this.concept = concept;
        this.amount = amount;
        //this.idemp = idemp;
        //this.idEnt = idEnt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    //Getters and Setters
    public tbTransaction() {}

    public Long getidtran() {
        return idtran;
    }

    public void setidtran(Long idtran) {
        this.idtran = idtran;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    


    


}
