package fr.lescrous.escr.services;

import fr.lescrous.escr.entities.CardStudent;

public interface CardStudentService {

    CardStudent getCardByEscn(String escn) throws Exception;

    Long countCards() throws Exception;
}
