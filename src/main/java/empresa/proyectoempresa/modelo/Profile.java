package empresa.proyectoempresa.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name="PROFILES")
public class Profile {
    
    public Profile(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprof")
    private long id;

    @Column(name = "phone", nullable = false)
    private long phone;

    @Column(name = "createdAt")
    private LocalDate created;

    @Column(name = "updatedAt")
    private LocalDate updated;

    @Column(name = "image")
    private String image;

    @OneToOne(mappedBy = "profile")
    private Employee user;

    
    
}