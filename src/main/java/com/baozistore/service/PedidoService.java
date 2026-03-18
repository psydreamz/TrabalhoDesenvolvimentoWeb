package com.baozistore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baozistore.entity.Pedido;
import com.baozistore.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;

    public List<Pedido> getAll()  {
        return repository.findAll();
    }

    public Pedido create(Pedido pedido) {
        return repository.save(pedido);
    }

    public Optional<Pedido> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
