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
@Table(name = "Enterprise")
public class tbEnterprise  {

    public tbEnterprise() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ident")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name = "document")
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name="createdAt", updatable = false)
    @CreationTimestamp
    private LocalDate created;
    
    @UpdateTimestamp
    @Column(name="updatedAt")
    private LocalDate updated;

    @OneToMany(mappedBy = "enterprise")
    private List<tbTransaction> transactions;

    @OneToMany(mappedBy = "enterprise")
    private List<tbEmployee> employees;

    
}




