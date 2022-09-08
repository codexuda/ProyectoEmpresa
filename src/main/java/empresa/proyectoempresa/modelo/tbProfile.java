package empresa.proyectoempresa.modelo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name="tb_profile")
public class tbProfile {
    public tbProfile(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprof")
    private long id;

    @Column(name = "phone")
    private long phone;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "updatedAt")
    private String updatedAt;

    @Column(name = "image")
    private String image;

    @Column(name = "userp")
    private String user;

    
    
}