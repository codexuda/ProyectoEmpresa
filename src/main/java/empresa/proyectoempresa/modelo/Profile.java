package empresa.proyectoempresa.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.*;

@Entity
@AllArgsConstructor
@Data
public class Profile {
    
    public Profile(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprof")
    private long id;

    @Column(name = "phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate created;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updated;

    @Column(name = "image")
    private String image;
    
    @OneToOne(mappedBy = "profile")
    private Employee user;

}