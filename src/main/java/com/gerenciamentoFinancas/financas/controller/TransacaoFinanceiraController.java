package com.gerenciamentoFinancas.financas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.gerenciamentoFinancas.financas.entities.TransacaoFinanceira;
import com.gerenciamentoFinancas.financas.services.TransacaoFinanceiraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/transacoes")
public class TransacaoFinanceiraController {
    @Autowired
    private TransacaoFinanceiraService transacaoService;

    @GetMapping("/listar")
    public String listarTransacoes(Model model) {
        List<TransacaoFinanceira> transacoes = transacaoService.listarTodasTransacoes();
        model.addAttribute("transacoes", transacoes);
        return "lista-transacoes";
    }
    @PostMapping ("/adicionar")
    public ResponseEntity<TransacaoFinanceira> adicionarTransacao(@RequestBody TransacaoFinanceira transacao) {
        return ResponseEntity.status(201).body(transacaoService.adicionarTransacao(transacao));
    }

    @GetMapping("/editar/{id}")
    public String editarTransacao(@PathVariable Long id, Model model) {
    TransacaoFinanceira transacao = transacaoService.buscarTransacaoPorId(id);
    model.addAttribute("transacao", transacao);
    return "editar-transacao";
    }

    @PostMapping("/atualizar")
    public String atualizarTransacao(@ModelAttribute("transacao") TransacaoFinanceira transacao) {
    transacaoService.atualizarTransacao(transacao);
    return "redirect:/api/transacoes/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirTransacao(@PathVariable Long id) {
    transacaoService.excluirTransacao(id);
    return "redirect:/api/transacoes/listar";
    }

    @GetMapping("/criar")
    public String criarTransacaoForm(Model model) {
        model.addAttribute("transacao", new TransacaoFinanceira());
        return "criar-transacao"; 
    }

    @PostMapping("/criar")
     public String criarTransacao(@ModelAttribute("transacao") TransacaoFinanceira transacao) {
    transacaoService.adicionarTransacao(transacao);
     return "redirect:/api/transacoes/listar";
     }


}