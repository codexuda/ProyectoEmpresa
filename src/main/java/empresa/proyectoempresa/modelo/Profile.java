package empresa.proyectoempresa.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private long phone;

    @Column(name = "created_at")
    private LocalDate created;

    @Column(name = "updated_at")
    private LocalDate updated;

    @Column(name = "image")
    private String image;
    
    
}