package com.paulispan.gestao_pessoas.dto.usuarios.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record NotificacaoResponse(
        UUID id,
        UsuarioResponse usuario,
        String mensagem,
        Boolean lida,
        LocalDate dataCricao,
        LocalDate dataVisualizacao
)
{
}
