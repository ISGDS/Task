package com.zzy.task.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Selection {

    @NotBlank
    private Long id;

    private String action;

    private String name;

    private Integer displayOrder;

    private String bettingStatus;

    private Boolean display;

    private Boolean characteristic;

    private Boolean participantKey;
}
