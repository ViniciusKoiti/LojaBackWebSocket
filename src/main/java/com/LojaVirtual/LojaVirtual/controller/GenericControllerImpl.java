package com.LojaVirtual.LojaVirtual.controller;

import com.LojaVirtual.LojaVirtual.entity.Auditoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.LojaVirtual.LojaVirtual.service.GenericServiceImpl;

import jakarta.servlet.GenericFilter;

public abstract class GenericControllerImpl<T extends Auditoria> implements GenericController<T>{
    
    public final GenericServiceImpl<T,Long> service;

    protected GenericControllerImpl(GenericServiceImpl<T, Long> service) {
        this.service = service;
    }

    public ResponseEntity<Page<T>> getPaginatedData(
            GenericFilter filter, 
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> resultPage = service.buscaTodosPaginado(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }
}