package com.baozistore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.baozistore.entity.Pedido;
import com.baozistore.entity.Produto;
import com.baozistore.entity.Cliente;
import com.baozistore.service.PedidoService;
import com.baozistore.service.ProdutoService;
import com.baozistore.service.ClienteService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido request) {
        
        if (request == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: O corpo da requisição não pode estar vazio.");
        }

        if (request.getClienteId() == null || request.getClienteId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: Um 'clienteId' válido é obrigatório.");
        }

        if (request.getProdutoId() == null || request.getProdutoId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: Um 'produtoId' válido é obrigatório.");
        }

        if (request.getQuantidade() == null || request.getQuantidade() < 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Validação: A 'quantidade' deve ser no mínimo 1.");
        }

        Optional<Cliente> clienteExistente = clienteService.findById(request.getClienteId());
        
        if (clienteExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Cliente com ID " + request.getClienteId() + " não encontrado no sistema.");
        }

        Optional<Produto> produtoExistente = produtoService.findById(request.getProdutoId());
        
        if (produtoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Produto com ID " + request.getProdutoId() + " não encontrado no sistema.");
        }

        Produto produto = produtoExistente.get();
        if (!produto.getEstoque()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro de Negócio: O produto '" + produto.getNome() + "' encontra-se sem estoque no momento.");
        }

        Pedido pedidoNovo = service.create(request);
        return new ResponseEntity<>(pedidoNovo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = service.findById(id);
        return pedido.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}