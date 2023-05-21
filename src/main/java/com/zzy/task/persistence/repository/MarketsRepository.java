package com.zzy.task.persistence.repository;

import com.zzy.task.persistence.entity.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketsRepository extends JpaRepository<MarketEntity, Long> {

    List<MarketEntity> findAll();

}
