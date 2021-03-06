package com.fayda.command.repository;

import com.fayda.command.constants.TransactionTypes;
import com.fayda.command.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
  List<TransactionModel> findAllByUserIdAndTypeInAndIsActiveTrueOrderByCreateDateDesc(UUID userId, TransactionTypes... types);
}
