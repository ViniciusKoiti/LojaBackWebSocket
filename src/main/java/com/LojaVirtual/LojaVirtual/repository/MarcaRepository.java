package com.LojaVirtual.LojaVirtual.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.LojaVirtual.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Page<Marca> buscaPaginada(Pageable pageable);
}
