package com.LojaVirtual.LojaVirtual.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.LojaVirtual.entity.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Page<Estado> buscaPaginada(Pageable pageable);
}
