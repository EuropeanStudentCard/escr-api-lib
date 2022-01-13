package fr.lescrous.escr.services;

import fr.lescrous.escr.entities.Card;

public interface CardService {

    Card getCardByEscn(String escn) throws Exception;
}
