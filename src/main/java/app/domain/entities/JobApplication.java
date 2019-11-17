package app.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "job_applications")
public class JobApplication extends BaseEntity{
private Sector sector;
private String profession;
private BigDecimal salary;
private String description;

    public JobApplication() {
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "sector", nullable = false)
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
    @Column(name = "profession", nullable = false)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    @Column(name = "salary", nullable = false)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal sslary) {
        this.salary = sslary;
    }
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String descriotion) {
        this.description = descriotion;
    }
}
