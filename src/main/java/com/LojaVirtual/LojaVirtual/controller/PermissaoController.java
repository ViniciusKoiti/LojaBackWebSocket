package com.LojaVirtual.LojaVirtual.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LojaVirtual.LojaVirtual.entity.Marca;
import com.LojaVirtual.LojaVirtual.entity.Permissao;
import com.LojaVirtual.LojaVirtual.service.PermissaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/permissao")
@CrossOrigin
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;
    @GetMapping("/")
    public List<Permissao> buscarTodos(){
        return permissaoService.buscarTodos();
    }
    @PostMapping("/")
    public Permissao inserir(@Valid@RequestBody Permissao objeto){
        return permissaoService.inserir(objeto);
    }
    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao objeto){
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPermissao(@PathVariable Long id) {
        try {
            permissaoService.excluir(id);
            return ResponseEntity.ok("Permissao excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permissao> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(permissaoService.buscarPorId(id));
    }

     @GetMapping
     public ResponseEntity<Page<Permissao>> pegaPagina(
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Permissao> resultPage = permissaoService.buscaTodosPaginado(pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }
}

