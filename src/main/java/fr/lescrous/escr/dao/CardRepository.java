package fr.lescrous.escr.dao;

import fr.lescrous.escr.entities.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {

    @Query("select c from Card c where c.europeanStudentCardNumber = ?1")
    Card getCardByEscn(String escn);
}
