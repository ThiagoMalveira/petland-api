package com.petland.petland_api.cadastros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petland.petland_api.cadastros.model.ProdutoServico;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Integer>{
    
}
