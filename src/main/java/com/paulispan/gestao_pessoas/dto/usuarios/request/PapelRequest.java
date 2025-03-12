package com.paulispan.gestao_pessoas.dto.usuarios.request;

import java.util.List;
import java.util.UUID;

public record PapelRequest(
        String nome,
        List<UUID> permissoes
) {
}
