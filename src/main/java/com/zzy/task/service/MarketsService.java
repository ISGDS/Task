package com.zzy.task.service;

import com.zzy.task.controller.dto.Market;
import com.zzy.task.controller.dto.Participant;
import com.zzy.task.controller.dto.Selection;

import java.util.List;

public interface MarketsService {

    Market findMarketById(Long id);

    Market addMarket(Market market);

    String removeMarket(Long id);

    Market updateMarket(Market market);

    List<Market> findAllMarkets();

    Participant addParticipantToMarket(Long id, Participant participant);

    Selection addSelectionToMarkets(Long id, Selection selection);

}
