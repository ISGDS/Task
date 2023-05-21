package com.zzy.task.service.impl;

import com.zzy.task.controller.dto.Market;
import com.zzy.task.controller.dto.Participant;
import com.zzy.task.controller.dto.Selection;
import com.zzy.task.persistence.entity.MarketEntity;

import com.zzy.task.persistence.entity.ParticipantEntity;
import com.zzy.task.persistence.entity.SelectionEntity;
import com.zzy.task.persistence.repository.MarketsRepository;
import com.zzy.task.service.MarketsService;
import com.zzy.task.persistence.repository.CustomRepository;
import com.zzy.task.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MarketsServiceImpl implements MarketsService {

    private final CustomRepository customRepository;

    private final MarketsRepository marketsRepository;


    @Autowired
    public MarketsServiceImpl(CustomRepository customRepository, MarketsRepository marketsRepository) {
        this.marketsRepository = marketsRepository;
        this.customRepository = customRepository;
    }

    @Override
    public Market findMarketById(Long id) {
        return ModelUtil.convertToMarket(customRepository.findMarketsEntityById(id));
    }

    @Override
    public Market addMarket(Market market) {
        MarketEntity marketEntity = MarketEntity.builder()
                .id(market.getId())
                .name(market.getName())
                .action(market.getAction())
                .display(market.getDisplay())
                .inRunning(market.getInRunning())
                .selectionsEntities(market.getSelectionsEntities())
                .participantsEntities(market.getParticipantsEntities())
                .typeId(market.getTypeId())
                .build();

        return ModelUtil.convertToMarket(customRepository.saveMarketsEntity(marketEntity));
    }

    @Override
    public String removeMarket(Long id) {
        MarketEntity marketEntity = customRepository.findMarketsEntityById(id);
        customRepository.deleteMarketsEntity(marketEntity);
        return "Successfully removed markets with id:" + id;
    }

    @Override
    public Market updateMarket(Market market) {
        MarketEntity marketEntity = customRepository.findMarketsEntityById(market.getId());
        marketEntity.setAction(market.getAction());
        marketEntity.setName(market.getName());
        marketEntity.setDisplay(market.getDisplay());
        marketEntity.setParticipantsEntities(market.getParticipantsEntities());
        marketEntity.setInRunning(market.getInRunning());
        marketEntity.setSelectionsEntities(market.getSelectionsEntities());

        return ModelUtil.convertToMarket(customRepository.saveMarketsEntity(marketEntity));
    }

    @Override
    public List<Market> findAllMarkets() {
        List<Market> marketList = new ArrayList<>();
        for (MarketEntity me : marketsRepository.findAll()){
            marketList.add(ModelUtil.convertToMarket(me));
        }

        return marketList;
    }

    @Override
    public Participant addParticipantToMarket(Long id, Participant participant) {
        MarketEntity marketEntity = marketsRepository.findById(id).get();

        ParticipantEntity participantEntity = ParticipantEntity.builder()
                .id(participant.getId())
                .name(participant.getName())
                .label(participant.getLabel())
                .build();

        marketEntity.getParticipantsEntities().add(participantEntity);
        customRepository.saveMarketsEntity(marketEntity);

        return ModelUtil.convertToParticipant(participantEntity);
    }

    @Override
    public Selection addSelectionToMarkets(Long id, Selection selection) {
        MarketEntity marketEntity = marketsRepository.findById(id).get();

        SelectionEntity selectionEntity = SelectionEntity.builder()
                .id(selection.getId())
                .name(selection.getName())
                .action(selection.getAction())
                .bettingStatus(selection.getBettingStatus())
                .participantKey(selection.getParticipantKey())
                .characteristic(selection.getCharacteristic())
                .display(selection.getDisplay())
                .displayOrder(selection.getDisplayOrder())
                .build();

        marketEntity.getSelectionsEntities().add(selectionEntity);
        customRepository.saveMarketsEntity(marketEntity);

        return ModelUtil.convertToSelection(selectionEntity);
    }

}
