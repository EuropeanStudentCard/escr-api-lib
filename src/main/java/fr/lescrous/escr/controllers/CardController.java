package fr.lescrous.escr.controllers;

import fr.lescrous.escr.entities.Card;
import fr.lescrous.escr.entities.CardStudent;
import fr.lescrous.escr.exceptions.UnknownTechnicalException;
import fr.lescrous.escr.response.StatusCardResponse;
import fr.lescrous.escr.services.CardService;
import fr.lescrous.escr.services.CardStudentService;
import fr.lescrous.escr.utils.CommonsUtils;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.persistence.metamodel.EntityType;
import java.util.Set;

@RestController
@RequestMapping("/cards")
public class CardController {

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CardStudentService cardStudentService;

    @GetMapping("/status/{escn}")
    public @ResponseBody ResponseEntity<StatusCardResponse> getStatusStudentCard(@PathVariable String escn)
            throws NoResultException, UnknownTechnicalException {
        try{
            Set<EntityType<?>> entities = sessionFactory.getMetamodel().getEntities();
            CardStudent card = null;
            Integer pic = CommonsUtils.getPicEtablissementFromEscn(escn);
            card = cardStudentService.getCardByEscn(escn);

            StatusCardResponse statusCardResponse = new StatusCardResponse();
            if (card != null) {

                statusCardResponse.setEuropeanStudentCardNumber(card.getEuropeanStudentCardNumber());
                statusCardResponse.setAcademicLevel(card.getAcademicLevel());
                statusCardResponse.setExpiryDate(card.getExpiryDate());
                statusCardResponse.setEuropeanStudentIdentifier(card.getEuropeanStudentIdentifier());
            } else {
                throw new NoResultException("student not found.");
            }




            return ResponseEntity.ok(statusCardResponse);

        } catch (NoResultException e){
            LOG.debug(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            LOG.debug(e.getMessage(), e);
            throw new UnknownTechnicalException(e.getMessage(), e);
        }
    }

    @GetMapping("/stats")
    public @ResponseBody ResponseEntity<Long> getStatusStudentCard()
            throws NoResultException, UnknownTechnicalException {
        try{
            Set<EntityType<?>> entities = sessionFactory.getMetamodel().getEntities();
            Long qty = cardStudentService.countCards();

            return ResponseEntity.ok(qty);

        } catch (NoResultException e){
            LOG.debug(e.getMessage(), e);
            throw e;
        } catch (Exception e){
            LOG.debug(e.getMessage(), e);
            throw new UnknownTechnicalException(e.getMessage(), e);
        }
    }
}
