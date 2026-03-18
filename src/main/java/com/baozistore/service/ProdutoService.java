package com.baozistore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baozistore.entity.Produto;
import com.baozistore.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAll()  {
        return repository.findAll();
    }

    public Produto create(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
