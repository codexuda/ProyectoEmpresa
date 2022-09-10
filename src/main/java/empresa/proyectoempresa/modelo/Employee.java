package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Entity
@AllArgsConstructor
@Data
public class Employee {

    public Employee() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private long id;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "profile", referencedColumnName = "idprof" )
    private Profile profile;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name ="roleName")
    private Enum_RoleName rol;

    @ManyToOne
    @JoinColumn(name = "enterprise", referencedColumnName = "ident")
    private Enterprise enterprise;

    @CreationTimestamp
    @Column(name = "created_at", nullable = true)
    private LocalDate created;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true)
    private LocalDate updated;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

}
