package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "Employee")
public class tbEmployee {

    public tbEmployee() {
    }

    public tbEmployee(String email,tbProfile profile, EnumRole rol, tbEnterprise enterprise) {
        this.email=email;
        this.enterprise=enterprise;
        this.profile=profile;
        this.rol=rol;
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
    @Column(name ="rol")
    private EnumRole rol;

    @ManyToOne
    @JoinColumn(name = "ident", referencedColumnName = "ident")
    private tbEnterprise enterprise;

    @Column(name = "createdAt", nullable = true)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updatedAt", nullable = true)
    @UpdateTimestamp
    private LocalDate updated;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<tbTransaction> transactions;

}
