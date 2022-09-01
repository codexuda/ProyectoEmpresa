package empresa.proyectoempresa.modelo;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name="tbTransaction")
public class Transaction {

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

    public Transaction(Long idTran, String concept, Double amount, Double idEmp, Double idEnt, String createdAt,
            Date updatedAt) {
        this.idTran = idTran;
        this.concept = concept;
        this.amount = amount;
        this.idEmp = idEmp;
        this.idEnt = idEnt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Transaction() {}

    


}
