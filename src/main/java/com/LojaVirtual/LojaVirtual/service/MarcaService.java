package com.LojaVirtual.LojaVirtual.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.LojaVirtual.entity.Estado;
import com.LojaVirtual.LojaVirtual.entity.Marca;
import com.LojaVirtual.LojaVirtual.repository.MarcaRepository;



@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> buscarTodos() {
        return marcaRepository.findAll();
    }

    public Marca buscarPorId(Long id) {
        return marcaRepository.findById(id).get();
    }

    public Marca inserir(Marca objeto) {
        objeto.setDataCriacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public Marca alterar(Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Marca não encontrada."));
        marcaRepository.delete(marca);

    }

     public Page<Marca> buscaTodosPaginado(Pageable pageable){
    
        return marcaRepository.findAll(pageable);
    }
}