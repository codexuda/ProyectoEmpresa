package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Enterprise  {

    public Enterprise() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnt")
    private long id;

    @Column(name="name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    @OneToMany(mappedBy = "enterprise")
    private List<Employee> users;
    
    @OneToMany(mappedBy = "enterprise")
    private List<Transaction> transactions;
    
    @Column(name="createdAt", updatable = false)
    @CreationTimestamp
    private LocalDate created;
    
    @UpdateTimestamp
    @Column(name="updatedAt")
    private LocalDate updated;

    
}




