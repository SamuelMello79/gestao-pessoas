package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.PermissaoRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PermissaoResponse;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PermissaoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Permissão", description = "Recurso responsável pelo gerenciamento de permissões.")
public interface PermissaoController {
    @Operation(summary = "Buscar todas as permissões", description = "Método responsável por buscar todas as permissões."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Permissões encontrada com sucesso.",
            content = @Content(schema = @Schema(implementation = PermissaoResponse.class)))
    @ApiResponse(responseCode = "204", description = "Permissões notificação foi encontrada.",
            content = @Content())
    ResponseEntity<PermissaoResponse> buscarPorId(@PathVariable UUID id);

    @Operation(summary = "Buscar todas as permissões", description = "Método responsável por buscar todas as notificações."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Permissões encontrada com sucesso.",
            content = @Content(schema = @Schema(implementation = PermissaoResponse.class)))
    @ApiResponse(responseCode = "204", description = "Permissões notificação foi encontrada.",
            content = @Content())
    ResponseEntity<List<PermissaoResponse>> buscarTodosPermissoes();

    @Operation(summary = "Alterar permissão", description = "Método responsável por alterar permissão pelo id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Permissão alterada com sucesso.",
            content = @Content(schema = @Schema(implementation = PermissaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Permissão não encontrada.",
            content = @Content())
    ResponseEntity<PermissaoResponse> editarPermissao(@PathVariable UUID id, @RequestBody PermissaoRequest permissaoRequest);

    @Operation(summary = "Salvar permissão", description = "Método responsável por salvar permissão."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Permissão salva com sucesso.",
            content = @Content(schema = @Schema(implementation = PermissaoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Não foi possivel salvar permissão, devido a informações incorretas.",
            content = @Content())
    ResponseEntity<PermissaoResponse> salvarPermissao(@RequestBody PermissaoRequest permissaoRequest);

    @Operation(summary = "Excluir permissão", description = "Método responsável por excluir permissão pelo id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "204", description = "Permissão excluida com sucesso.",
            content = @Content(schema = @Schema(implementation = PermissaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Permissão não encontrado.",
            content = @Content())
    ResponseEntity<Void> excluirPermissao(@PathVariable UUID id);
}
