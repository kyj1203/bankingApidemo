package com.example.demo.repository;

import com.example.demo.entity.HYPHEN_TRADE_REQUEST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRequestRepository extends JpaRepository<HYPHEN_TRADE_REQUEST, Long> {
}