package com.petland.petland_api.cadastros.model.dto;

import java.time.LocalDate;

import com.petland.petland_api.cadastros.model.AnimalEspecie;

import lombok.Data;

@Data
public class AnimalRequestDTO {
    private String nome;  
    private LocalDate aniversário;
    private AnimalEspecie especie;
}
