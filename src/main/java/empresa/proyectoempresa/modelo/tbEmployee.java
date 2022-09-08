package empresa.proyectoempresa.modelo;

import java.sql.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class tbEmployee {

    public tbEmployee() {
    }

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
    private Date created;

    @Column(name = "updatedate", nullable = true)
    private Date updated;

   

}
