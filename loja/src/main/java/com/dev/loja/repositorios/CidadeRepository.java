package com.dev.loja.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.loja.modelos.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}