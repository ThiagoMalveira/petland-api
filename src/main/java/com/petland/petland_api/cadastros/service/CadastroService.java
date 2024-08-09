package com.petland.petland_api.cadastros.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.petland_api.cadastros.model.dto.CadastroRequestDTO;
import com.petland.petland_api.cadastros.model.dto.CadastroResponseDTO;
import com.petland.petland_api.cadastros.model.entities.CadastroEntity;
import com.petland.petland_api.cadastros.repository.CadastroRepository;

@Service
public class CadastroService {
    
    @Autowired
    private CadastroRepository repository;

    public Integer gravar(CadastroRequestDTO requisicao){
        CadastroEntity entidade = new CadastroEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return repository.save(entidade).getId();
    }

    public Integer alterar(Integer id, CadastroRequestDTO requisicao){
        CadastroEntity entidade =  repository.findById(id).orElse(null);
        if(entidade != null){
            BeanUtils.copyProperties(requisicao, entidade);
            return repository.save(entidade).getId();
        }
        return null;
    }

    public List<CadastroResponseDTO> listar(){
        List<CadastroEntity> entities = repository.findAll();
        List<CadastroResponseDTO> response = new ArrayList<>();
        for (CadastroEntity e: entities){
            CadastroResponseDTO res = new CadastroResponseDTO();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }
        return response;
    }

    public void excluir(Integer id){
        repository.deleteById(id); 
    }
}