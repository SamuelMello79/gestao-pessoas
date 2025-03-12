package com.paulispan.gestao_pessoas.dto.usuarios.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UsuarioResponse(
        UUID id,
        String nome,
        String email,
        String senha,
        PapelResponse papel
) {
}
