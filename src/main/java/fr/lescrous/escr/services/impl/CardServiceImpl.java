package fr.lescrous.escr.services.impl;

import fr.lescrous.escr.dao.CardRepository;
import fr.lescrous.escr.entities.Card;
import fr.lescrous.escr.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService {

    CardRepository cardRepository;


    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCardByEscn(String escn) throws Exception {
        List<String> columnList = new ArrayList<>();
        return cardRepository.getCardByEscn(escn);
    }
}
