package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp", nullable = false)
    private long id;
    
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne
    private Profile profile;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="roleName")
    private Enum_RoleName rol;

    @ManyToOne(cascade = CascadeType.ALL)
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
