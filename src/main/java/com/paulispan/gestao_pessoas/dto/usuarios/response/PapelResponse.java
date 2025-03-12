package com.paulispan.gestao_pessoas.dto.usuarios.response;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record PapelResponse(
        UUID id,
        String nome,
        List<PermissaoResponse> permissoes
) {
}
