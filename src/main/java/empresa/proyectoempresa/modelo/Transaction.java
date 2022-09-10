package empresa.proyectoempresa.modelo;


import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
public class Transaction {
    //Cosntructor

    public Transaction(){}
    

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtran")
    private long id;
 
    @Column(name = "concept", nullable = true, length = 100)
    private String concept;

    @Column(name="amount", nullable=true)
    private Double amount;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="employee", referencedColumnName = "idemp" )
    private Employee user;

    //Foreing Key
    @ManyToOne
    @JoinColumn(name="enterprise", referencedColumnName = "ident" )
    private Enterprise enterprise;

    @CreationTimestamp
    @Column(name="createat", updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name="updatedat")
    private LocalDate updatedAt;
  

}
