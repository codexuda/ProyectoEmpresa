package empresa.proyectoempresa.modelo;

import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;


import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class tbEmployee {

//Atributos
    //campo llave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemp")
    private Long id;
    
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idprof", referencedColumnName = "idprof" )
    private tbProfile profile;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="idrole")
    private tbenumrolename rol;

    @ManyToOne
    @JoinColumn(name = "ident", referencedColumnName = "ident")
    private tbEnterprise enterprise;

    @Column(name = "createdate", nullable = true)
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updatedate", nullable = true)
    @CreationTimestamp
    private LocalDate updated;

 // constructor
    
public tbEmployee() {
}


}
