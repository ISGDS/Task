package com.zzy.task.persistence.repository;

import com.zzy.task.persistence.entity.MarketEntity;
import com.zzy.task.persistence.entity.ParticipantEntity;
import com.zzy.task.persistence.entity.SelectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Repository
public class CustomRepository {

    private final MarketsRepository marketsRepository;

    private final SelectionRepository selectionRepository;

    private final ParticipantRepository participantRepository;

    @Autowired
    public CustomRepository(MarketsRepository marketsRepository, SelectionRepository selectionRepository,
                            ParticipantRepository participantRepository) {
        this.marketsRepository = marketsRepository;
        this.selectionRepository = selectionRepository;
        this.participantRepository = participantRepository;
    }

    public MarketEntity findMarketsEntityById(Long id) {
        return marketsRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Markets with id:" + id + " not found"));
    }

    @Transactional
    public MarketEntity saveMarketsEntity(MarketEntity marketEntity) {
        try {
            return marketsRepository.save(marketEntity);
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void deleteMarketsEntity(MarketEntity marketEntity) {
        try {
            selectionRepository.deleteAll(marketEntity.getSelectionsEntities());
            participantRepository.deleteAll(marketEntity.getParticipantsEntities());
            marketsRepository.delete(marketEntity);
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
