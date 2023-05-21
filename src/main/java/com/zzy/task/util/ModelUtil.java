package com.zzy.task.util;

import com.zzy.task.controller.dto.Market;
import com.zzy.task.controller.dto.Participant;
import com.zzy.task.controller.dto.Selection;
import com.zzy.task.persistence.entity.MarketEntity;
import com.zzy.task.persistence.entity.ParticipantEntity;
import com.zzy.task.persistence.entity.SelectionEntity;
import org.modelmapper.ModelMapper;

public class ModelUtil {

    private final static ModelMapper modelMapper = new ModelMapper();

    public static Market convertToMarket(MarketEntity marketEntity) {
        return modelMapper.map(marketEntity, Market.class);
    }

    public static Selection convertToSelection(SelectionEntity selectionEntity) {
        return modelMapper.map(selectionEntity, Selection.class);
    }

    public static Participant convertToParticipant(ParticipantEntity participant) {
        return modelMapper.map(participant, Participant.class);
    }
}
