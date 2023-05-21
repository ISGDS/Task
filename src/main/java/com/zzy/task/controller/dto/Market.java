package com.zzy.task.controller.dto;

import com.zzy.task.persistence.entity.MarketEntity;
import com.zzy.task.persistence.entity.ParticipantEntity;
import com.zzy.task.persistence.entity.SelectionEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ApiModel(description = "Response body for Markets")
public class Market {

    @NotBlank
    private Long id;

    private String action;

    private Integer typeId;

    private List<SelectionEntity> selectionsEntities;

    private Integer selectionId;

    private String name;

    private Boolean display;

    private Boolean inRunning;

    private Integer participantId;

    private List<ParticipantEntity> participantsEntities;
}
