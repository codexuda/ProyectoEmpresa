package empresa.proyectoempresa.modelo;


import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@Table(name="Transaction")
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
    private tbEmployee employee;
    //Foreing Key
    @ManyToOne
    @JoinColumn(name="idEnt", referencedColumnName = "idEnt" )
    private tbEnterprise enterprise;

    @CreationTimestamp
    @Column(name="createdAt")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name="updatedAt")
    private LocalDate updated;
  

}
