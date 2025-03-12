package com.paulispan.gestao_pessoas.mappers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.PapelRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PapelResponse;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PermissaoResponse;
import com.paulispan.gestao_pessoas.models.usuarios.Papel;
import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class PapelMapper {
    public static Papel map(PapelRequest papelRequest) {
        List<Permissao> permissoes = papelRequest.permissoes().stream()
                .map(permissaoId -> Permissao.builder().id(permissaoId).build()).toList();

        return Papel
                .builder()
                .nome(papelRequest.nome())
                .permissoes(permissoes)
                .build();
    }

    public static PapelResponse map(Papel papel) {
        List<PermissaoResponse> permissoes = papel.getPermissoes().stream()
                .map(PermissaoMapper::map).toList();

        return PapelResponse
                .builder()
                .id(papel.getId())
                .nome(papel.getNome())
                .permissoes(permissoes)
                .build();
    }
}
