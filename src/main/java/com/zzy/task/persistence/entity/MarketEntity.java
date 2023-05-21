package com.zzy.task.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "market")
public class MarketEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String action;

    @Column
    private Integer typeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "marketId")
    private List<SelectionEntity> selectionsEntities;

    @Column
    private String name;

    @Column
    private Boolean display;

    @Column
    private Boolean inRunning;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "marketId")
    private List<ParticipantEntity> participantsEntities;
}
