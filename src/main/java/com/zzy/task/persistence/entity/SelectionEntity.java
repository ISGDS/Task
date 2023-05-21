package com.zzy.task.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "selection")
public class SelectionEntity {

    @Id
    @Getter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String action;

    @Column
    private String name;

    @Column
    private Integer displayOrder;

    @Column
    private String bettingStatus;

    @Column
    private Boolean display;

    @Column
    private Boolean characteristic;

    @Column
    private Boolean participantKey;
}
