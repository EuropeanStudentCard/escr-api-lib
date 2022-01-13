package fr.lescrous.escr.response;

import java.util.Date;

/**
 * The type Status card response.
 */
public class StatusCardResponse {

    private String europeanStudentCardNumber;

    private String europeanStudentIdentifier;

    private Integer academicLevel;

    private Date expiryDate;

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
