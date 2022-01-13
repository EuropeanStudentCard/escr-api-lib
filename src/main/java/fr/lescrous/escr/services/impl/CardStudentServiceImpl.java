package fr.lescrous.escr.services.impl;

import fr.lescrous.escr.dao.CardStudentRepository;
import fr.lescrous.escr.entities.CardStudent;
import fr.lescrous.escr.services.CardStudentService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CardStudentServiceImpl implements CardStudentService {

    CardStudentRepository cardStudentRepository;

    public CardStudentServiceImpl(CardStudentRepository cardStudentRepository) {
        this.cardStudentRepository = cardStudentRepository;
    }

    @Override
    public CardStudent getCardByEscn(String escn) throws Exception {
        return cardStudentRepository.getCardByEscn(escn);
    }

    @Override
    public Long countCards() throws Exception {
        return cardStudentRepository.count();
    }
}
