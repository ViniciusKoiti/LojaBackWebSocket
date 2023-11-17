package com.LojaVirtual.LojaVirtual.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    protected final JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Page<T> buscaTodosPaginado(Pageable pageable) {
        return repository.findAll(pageable);
    }

}

