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
@Table(name = "Employee")
public class tbEmployee {

    public tbEmployee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private Long id;
    
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "idprof", referencedColumnName = "idprof" )
    private tbProfile profile;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="idrole")
    private tbenumrolename rol;

    @ManyToOne
    @JoinColumn(name = "ident", referencedColumnName = "ident")
    private tbEnterprise enterprise;

    @Column(name = "createdAt", nullable = true)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updatedAt", nullable = true)
    @CreationTimestamp
    private LocalDate updated;

    @OneToMany(mappedBy = "employee")
    private List<tbTransaction> transactions;

}
