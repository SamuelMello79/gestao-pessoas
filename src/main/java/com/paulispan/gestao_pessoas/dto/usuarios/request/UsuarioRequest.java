package com.paulispan.gestao_pessoas.dto.usuarios.request;

import java.util.UUID;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,
        UUID papel
) {
}
