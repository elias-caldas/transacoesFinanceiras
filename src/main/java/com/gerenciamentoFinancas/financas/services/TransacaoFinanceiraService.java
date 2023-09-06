package com.gerenciamentoFinancas.financas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gerenciamentoFinancas.financas.entities.TransacaoFinanceira;
import com.gerenciamentoFinancas.financas.repositories.TransacaoFinanceiraRepository;

@Service
public class TransacaoFinanceiraService{
    @Autowired
    private TransacaoFinanceiraRepository transacaoFinanceiraRepository;

    public TransacaoFinanceiraService(TransacaoFinanceiraRepository transacaoFinanceiraRepository) {
        this.transacaoFinanceiraRepository = transacaoFinanceiraRepository;
    }

    public List<TransacaoFinanceira> listarTodasTransacoes() {
        List<TransacaoFinanceira> transacaoFinanceira = transacaoFinanceiraRepository.findAll();
        return transacaoFinanceira; 
    }

    public TransacaoFinanceira adicionarTransacao(TransacaoFinanceira transacao) {
        TransacaoFinanceira transacaoFinanceira = transacaoFinanceiraRepository.save(transacao);
        return transacaoFinanceira;
    }

    public TransacaoFinanceira buscarTransacaoPorId(Long id) {
        return transacaoFinanceiraRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Transação não encontrada: " + id));
    }

    public void atualizarTransacao(TransacaoFinanceira transacao) {
        transacaoFinanceiraRepository.save(transacao);
    }

    public void excluirTransacao(Long id) {
        transacaoFinanceiraRepository.deleteById(id);
    }

    
}