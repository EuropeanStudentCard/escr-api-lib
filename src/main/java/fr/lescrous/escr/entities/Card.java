package fr.lescrous.escr.entities;


import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Card.
 */
@Entity
@Table(name = "${escr.table.card}")
public class Card {

    @Id
    @Column(name="${escr.table.card.id_card}")
    private String idCard;

    @Column(name="${escr.table.card.escn}")
    private String europeanStudentCardNumber;

    @OneToOne
    @JoinColumn( name="escr.table.student.id_student" )
    private Student student;

    /**
     * Gets id card.
     *
     * @return the id card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * Sets id card.
     *
     * @param idCard the id card
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets student.
     *
     * @param student the student
     */
    public void setStudent(Student student) {
        this.student = student;
    }
}
