package empresa.proyectoempresa.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class tbEnterprise  {

    public tbEnterprise() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ident")
    private Long id;

    @Column(name="nameenterprise")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name = "phone")
    private int phone;

    @Column(name="createdat", updatable = false)
    @CreationTimestamp
    private LocalDate created;

    @Column(name="updatedat")
    private LocalDate updated;

    
}




