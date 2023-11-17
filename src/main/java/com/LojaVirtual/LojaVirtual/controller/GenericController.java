package com.LojaVirtual.LojaVirtual.controller;

import com.LojaVirtual.LojaVirtual.entity.Auditoria;
import jakarta.servlet.GenericFilter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface GenericController<T extends Auditoria> {

    ResponseEntity<Page<T>> getPaginatedData(
            GenericFilter filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size);
}
