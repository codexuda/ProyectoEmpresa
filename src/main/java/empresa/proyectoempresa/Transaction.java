package empresa.proyectoempresa;


import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tbtransaction")
public class transaction {
    @Column(name="updatedate", nullable=true)
    private Date updatedate;
    @Column(name="amount", nullable=true, length=undefined)
    private String amount;
    
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtran")
    private Long idtran;
    
   
    @Column(name="cratedate", nullable=true, length=undefined)
    private String cratedate;
    @Column(name="concept", nullable=true, length=100)
    private String concept;
    
    public transaction() {}

    public String getUpdatedate() {
        return updatedate;
    }
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }


    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }


    public long getIdtran() {
        return idtran;
    }
    public void setIdtran(long idtran) {
        this.idtran = idtran;
    }


    public String getCratedate() {
        return cratedate;
    }
    public void setCratedate(String cratedate) {
        this.cratedate = cratedate;
    }


    public String getConcept() {
        return concept;
    }
    public void setConcept(String concept) {
        this.concept = concept;
    }


}
