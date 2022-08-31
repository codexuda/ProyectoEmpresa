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
    @Column(name = "idTran")
    private Long idTran;

 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEmp", referencedColumnName = "idEmp" )
    private Double idEmp;
    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    private Double idEnt;

    
    @Column(name="createdAt", nullable=true)
    private String createdAt;


    @Column(name="updatedAt", nullable=true)
    private Date updatedAt;
  
     
  
    
     //Cosntructor

    public tbTransaction(Long idTran, String concept, Double amount, Double idEmp, Double idEnt, String createdAt,
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
    public tbTransaction() {}

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

    public Double getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Double idEmp) {
        this.idEmp = idEmp;
    }

    public Double getIdEnt() {
        return idEnt;
    }

    public void setIdEnt(Double idEnt) {
        this.idEnt = idEnt;
    }

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
