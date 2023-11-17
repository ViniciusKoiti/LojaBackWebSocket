package com.LojaVirtual.LojaVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    // You can add more generic methods here if needed
}