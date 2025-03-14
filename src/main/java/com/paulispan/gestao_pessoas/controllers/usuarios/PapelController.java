package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.PapelRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.NotificacaoResponse;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PapelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Papel", description = "Recurso responsável pelo gerenciamento de papeis.")
public interface PapelController {

    @Operation(summary = "Buscar papeis por id", description = "Método responsável por buscar papéis por id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Papel encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Papel não encontrado.",
            content = @Content())
    ResponseEntity<PapelResponse> buscarPorId(@PathVariable UUID id);

    @Operation(summary = "Buscar todos os papeis", description = "Método responsável por buscar todos os papéis."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Papéis encontrados com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "204", description = "Nenhum papel foi encontrado.",
            content = @Content())
    ResponseEntity<List<PapelResponse>> buscarTodosPapeis();

    @Operation(summary = "Salvar papel", description = "Método responsável por salvar papeis."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Papel salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "400", description = "Não foi possivel salvar usuario, devido a informações incorretas..",
            content = @Content())
    ResponseEntity<PapelResponse> salvarPapel(@RequestBody PapelRequest papelRequest);

    @Operation(summary = "Alterar papel", description = "Método responsável por alterar papeis pelo id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Papel alterado com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Papel não encontrado.",
            content = @Content())
    ResponseEntity<PapelResponse> editarPapel(@PathVariable UUID id, @RequestBody PapelRequest papelRequest);


    @Operation(summary = "Excluir papel", description = "Método responsável por excluir papel por id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "204", description = "Papel excluido com sucesso.",
            content = @Content(schema = @Schema(implementation = NotificacaoResponse.class)))
    @ApiResponse(responseCode = "404", description = "Papel não encontrado.",
            content = @Content())
    ResponseEntity<Void> excluirPapel(@PathVariable UUID id);
}
