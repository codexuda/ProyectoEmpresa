package empresa.proyectoempresa.modelo;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name = "Profile")
public class tbProfile {
    public tbProfile(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprof")
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createdAt")
    @CreationTimestamp
    private LocalDate created;

    @Column(name = "updatedAt")
    @UpdateTimestamp
    private LocalDate updated;

    @Column(name = "image")
    private String image;

    @JsonIgnore
    @OneToOne(mappedBy = "profile")
    private tbEmployee employee;
    
    
}