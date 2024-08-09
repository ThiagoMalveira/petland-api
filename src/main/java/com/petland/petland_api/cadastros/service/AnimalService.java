package com.petland.petland_api.cadastros.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.petland_api.cadastros.model.dto.AnimalRequestDTO;
import com.petland.petland_api.cadastros.model.dto.AnimalResponseDTO;
import com.petland.petland_api.cadastros.model.entities.AnimalEntity;
import com.petland.petland_api.cadastros.repository.AnimalRepository;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository repository;

    public Integer gravar(AnimalRequestDTO requisicao){
        AnimalEntity entidade = new AnimalEntity();
        BeanUtils.copyProperties(requisicao, entidade);
        return repository.save(entidade).getId();
    }

    public Integer alterar(Integer id, AnimalRequestDTO requisicao){
        AnimalEntity entidade =  repository.findById(id).orElse(null);
        if(entidade != null){
            BeanUtils.copyProperties(requisicao, entidade);
            return repository.save(entidade).getId();
        }
        return null;
    }

    public List<AnimalResponseDTO> listar(){
        List<AnimalEntity> entities = repository.findAll();
        List<AnimalResponseDTO> response = new ArrayList<>();
        for (AnimalEntity e: entities){
            AnimalResponseDTO res = new AnimalResponseDTO();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }
        return response;
    }

    public void excluir(Integer id){
        repository.deleteById(id); 
    }
}
