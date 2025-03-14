package com.paulispan.gestao_pessoas.mappers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.NotificacaoRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.NotificacaoResponse;
import com.paulispan.gestao_pessoas.dto.usuarios.response.UsuarioResponse;
import com.paulispan.gestao_pessoas.models.usuarios.Notificacao;
import com.paulispan.gestao_pessoas.models.usuarios.Usuario;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class NotificacaoMapper {
    public static Notificacao map (NotificacaoRequest notificacaoRequest) {
        Usuario usuario = Usuario.builder().id(notificacaoRequest.usuarioId()).build();

        return Notificacao.builder()
                .usuario(usuario)
                .mensagem(notificacaoRequest.mensagem())
                .lida(false)
                .dataCriacao(LocalDate.now())
                .dataVisualizacao(null)
                .build();
    }

    public static NotificacaoResponse map (Notificacao notificacao) {
        UsuarioResponse usuario = UsuarioMapper.map(notificacao.getUsuario());

        return NotificacaoResponse.builder()
                .id(notificacao.getId())
                .usuario(usuario)
                .mensagem(notificacao.getMensagem())
                .lida(notificacao.getLida())
                .dataCricao(notificacao.getDataCriacao())
                .dataVisualizacao(notificacao.getDataVisualizacao())
                .build();
    }
}
