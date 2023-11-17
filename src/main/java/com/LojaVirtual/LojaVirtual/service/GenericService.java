package com.LojaVirtual.LojaVirtual.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GenericService<T, ID> {
    Page<T> buscaTodosPaginado(Pageable pageable);
}