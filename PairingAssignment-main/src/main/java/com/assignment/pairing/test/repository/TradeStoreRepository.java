package com.assignment.pairing.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.pairing.test.model.TradeStore;

@Repository
public interface TradeStoreRepository extends JpaRepository<TradeStore, String> {

}
