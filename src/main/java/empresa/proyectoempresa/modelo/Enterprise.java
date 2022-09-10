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

    public Enterprise() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnt")
    private Long id;

    @Column(name="name", unique = true, nullable= false)
    private String name;

    @Column(name = "document", unique = true, nullable= false)
    private String document;

    @Column(name = "phone", nullable= true)
    private String phone;

    @Column(name="address", nullable= true)
    private String address;

    @OneToMany
    @JoinColumn(name = "users", referencedColumnName="ident")
    private List<Employee> users;
    
    @OneToMany
    @JoinColumn(name = "transactions", referencedColumnName = "idEnt")
    private List<Transaction> transactions;

    @Column(name="createdAt", updatable = false)
    @CreationTimestamp
    private LocalDate created;
    
    @UpdateTimestamp
    @Column(name="updatedAt")
    private LocalDate updated;

    
}




