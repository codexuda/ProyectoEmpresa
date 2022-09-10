package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
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

    @Column(name = "created_at", nullable = true)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updated_at", nullable = true)
    @UpdateTimestamp
    private LocalDate updated;

   

}
