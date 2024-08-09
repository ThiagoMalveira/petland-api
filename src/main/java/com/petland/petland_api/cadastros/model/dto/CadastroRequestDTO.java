package com.petland.petland_api.cadastros.model.dto;

import com.petland.petland_api.cadastros.model.Endereco;
import com.petland.petland_api.cadastros.model.Perfil;

import lombok.Data;

@Data
public class CadastroRequestDTO {
    private String nome;
    private Perfil perfil;
    private Endereco endereco;
}
