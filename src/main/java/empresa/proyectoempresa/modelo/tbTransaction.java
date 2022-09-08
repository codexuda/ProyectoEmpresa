package empresa.proyectoempresa.modelo;

import java.sql.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name="tbTransaction")
public class tbTransaction {
    //Cosntructor

    public tbTransaction(){

    }
    

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTran")
    private Long id;

 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEmp", referencedColumnName = "idEmp" )
    private tbEmployee enployee;
    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    private tbEnterprise enterprise;

    
    @Column(name="createdAt", nullable=true)
    private Date createdAt;


    @Column(name="updatedAt", nullable=true)
    private Date updatedAt;
  

}
