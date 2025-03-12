package com.paulispan.gestao_pessoas.mappers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.PermissaoRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PermissaoResponse;
import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PermissaoMapper {
    public static Permissao map(PermissaoRequest permissaoRequest) {
        return Permissao.builder()
                .nome(permissaoRequest.nome())
                .build();
    }

    public static PermissaoResponse map(Permissao permissao) {
        return PermissaoResponse.builder()
                .id(permissao.getId())
                .nome(permissao.getNome())
                .build();
    }
}
