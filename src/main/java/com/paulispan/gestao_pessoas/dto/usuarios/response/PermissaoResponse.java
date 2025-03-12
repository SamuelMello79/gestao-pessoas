package com.paulispan.gestao_pessoas.dto.usuarios.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PermissaoResponse(
        UUID id,
        String nome
) {
}
