package com.paulispan.gestao_pessoas.dto.usuarios.request;

import java.time.LocalDate;
import java.util.UUID;

public record NotificacaoRequest(
        UUID usuarioId,
        String mensagem
) {
}
