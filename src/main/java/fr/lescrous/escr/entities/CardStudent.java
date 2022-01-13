package fr.lescrous.escr.entities;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * The type Card student.
 */
@Entity
@Immutable
@Table(name="cardstudent")
public class CardStudent {

    private Integer idCard;

    private String europeanStudentCardNumber;

    private Integer idStudent;

    private String europeanStudentIdentifier;

    private Integer academicLevel;

    private Timestamp expiryDate;

    /**
     * Gets european student card number.
     *
     * @return the european student card number
     */
    public String getEuropeanStudentCardNumber() {
        return europeanStudentCardNumber;
    }

    /**
     * Sets european student card number.
     *
     * @param europeanStudentCardNumber the european student card number
     */
    public void setEuropeanStudentCardNumber(String europeanStudentCardNumber) {
        this.europeanStudentCardNumber = europeanStudentCardNumber;
    }

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
    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets expiry date.
     *
     * @param expiryDate the expiry date
     */
    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Sets id card.
     *
     * @param idCard the id card
     */
    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    /**
     * Gets id card.
     *
     * @return the id card
     */
    @Id
    public Integer getIdCard() {
        return idCard;
    }
}
