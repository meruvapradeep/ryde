package com.ryde.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryde.rm.domain.CardInfo;

@Repository
public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {

}
