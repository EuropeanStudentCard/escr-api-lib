package fr.lescrous.escr.dao;

import fr.lescrous.escr.entities.CardStudent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardStudentRepository extends CrudRepository<CardStudent, Integer> {

    @Query("select c from CardStudent c where c.europeanStudentCardNumber = ?1")
    CardStudent getCardByEscn(String escn);
}
