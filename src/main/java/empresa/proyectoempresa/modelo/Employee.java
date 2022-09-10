package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Employee {

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmp")
    private Long id;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "profile", referencedColumnName = "idProf" )
    private Profile profile;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name ="roleName")
    private enumrolename rol;

    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "idEnt")
    private Enterprise enterprise;

    @OneToMany
    @JoinColumn(name = "transactions", referencedColumnName = "idTran")
    private List<Transaction> trasactions;

    @Column(name = "createdAt", nullable = true)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updatedAt", nullable = true)
    @CreationTimestamp
    private LocalDate updated;

   

}
