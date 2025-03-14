package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.NotificacaoRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.NotificacaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Notificação", description = "Recurso responsável pelo gerenciamento de notificações.")
public interface NotificacaoController {

    @Operation(summary = "Buscar notificacões por id", description = "Método responsável por buscar notificações por id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Notificação encontrada com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Notificação não encontrada.",
            content = @Content())
    ResponseEntity<NotificacaoResponse> buscarPorId(@PathVariable UUID id);

    @Operation(summary = "Buscar todos as notificações", description = "Método responsável por buscar todas as notificações."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Notificações encontradas com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "204", description = "Nenhuma notificação foi encontrada.",
            content = @Content())
    ResponseEntity<List<NotificacaoResponse>> buscarTodosNotificacao();

    @Operation(summary = "Buscar todas as notificações por usuário", description = "Método responsável por buscar todas as notificações pelo id do usuário."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Notificações encontrada com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "204", description = "Nenhuma notificação foi encontrada.",
            content = @Content())
    ResponseEntity<List<NotificacaoResponse>> buscarTodosNotificacoPorUsuarioId(@PathVariable UUID id);

    @Operation(summary = "Salvar notificação", description = "Método responsável por salvar notificação."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "201", description = "Notificação salva com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Não foi possivel salvar notificação, devido a informações incorretas.",
            content = @Content())
    ResponseEntity<NotificacaoResponse> salvarNotificacao(@RequestBody NotificacaoRequest notificacaoRequest);

    @Operation(summary = "Alterar notificação", description = "Método responsável por alterar notificação pelo id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Notificação alterada com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Notificação não encontrada.",
            content = @Content())
    ResponseEntity<NotificacaoResponse> editarNotificacao(@PathVariable UUID id, @RequestBody NotificacaoRequest notificacaoRequest);

    @Operation(summary = "Excluir notificação", description = "Método responsável por excluir notificacao pelo id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "204", description = "Notificacao excluida com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Notificacao não encontrado.",
            content = @Content())
    ResponseEntity<Void> excluirNotificacao(@PathVariable UUID id);
}
