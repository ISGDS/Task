package com.zzy.task.persistence.repository;

import com.zzy.task.persistence.entity.SelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectionRepository extends JpaRepository<SelectionEntity, Long> {

    List<SelectionEntity> findAll();

}