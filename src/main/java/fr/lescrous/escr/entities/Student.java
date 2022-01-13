package fr.lescrous.escr.entities;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * The type Student.
 */
@Entity
@Table(name = "${escr.table.student}")
public class Student {
    
    @Id
    @Column(name="escr.table.student.id_student")
    private Integer idStudent;
    @Column(name="${escr.table.card.esi}")
    private String europeanStudentIdentifier;
    @Column(name="${escr.table.card.academic_level}")
    private Integer academicLevel;
    @Column(name="${escr.table.student.expiry_date}")
    private Date expiryDate;

    /**
     * Gets id student.
     *
     * @return the id student
     */
    public Integer getIdStudent() {
        return idStudent;
    }

    /**
     * Sets id student.
     *
     * @param idStudent the id student
     */
    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    /**
     * Gets european student identifier.
     *
     * @return the european student identifier
     */
    public String getEuropeanStudentIdentifier() {
        return europeanStudentIdentifier;
    }

    /**
     * Sets european student identifier.
     *
     * @param europeanStudentIdentifier the european student identifier
     */
    public void setEuropeanStudentIdentifier(String europeanStudentIdentifier) {
        this.europeanStudentIdentifier = europeanStudentIdentifier;
    }

    /**
     * Gets academic level.
     *
     * @return the academic level
     */
    public Integer getAcademicLevel() {
        return academicLevel;
    }

    /**
     * Sets academic level.
     *
     * @param academicLevel the academic level
     */
    public void setAcademicLevel(Integer academicLevel) {
        this.academicLevel = academicLevel;
    }

    /**
     * Gets expiry date.
     *
     * @return the expiry date
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets expiry date.
     *
     * @param expiryDate the expiry date
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
