package com.gerenciamentoFinancas.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentoFinancas.financas.entities.TransacaoFinanceira;

public interface TransacaoFinanceiraRepository extends JpaRepository<TransacaoFinanceira, Long> {
    
}
