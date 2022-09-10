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
@Table(name="TRANSACTIONS")
public class Transaction {
    //Cosntructor

    public Transaction(){}
    

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTran")
    private long id;

 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="user", referencedColumnName = "idEmp" )
    private Employee user;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="enterprise", referencedColumnName = "idEnt" )
    private Enterprise enterprise;

    @CreationTimestamp
    @Column(name="createdAt")
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name="updatedAt")
    private LocalDate updatedAt;
  

}
