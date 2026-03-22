package com.baozistore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.baozistore.entity.Produto;
import com.baozistore.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Produto request) {
        
        if (request == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: O corpo da requisição não pode estar vazio.");
        }

        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: O atributo 'nome' é obrigatório.");
        }

        if (request.getPreco() == null || request.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: O 'preco' é obrigatório e deve ser maior que zero.");
        }

        if (request.getEstoque() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: O status de 'estoque' (true/false) é obrigatório.");
        }

        Produto produtoNovo = service.create(request);
        return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = service.findById(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}