package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.UsuarioRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Usuário", description = "Recurso responsável pelo gerenciamento de usuários.")
public interface UsuarioController {
    @Operation(summary = "Buscar usuarios por email", description = "Método responsável por buscar usuarios por email."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.",
            content = @Content())
    ResponseEntity<UsuarioResponse> buscarPorEmail(@PathVariable String email);

    @Operation(summary = "Buscar usuarios por id", description = "Método responsável por buscar usuarios por id."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado.",
            content = @Content())
    ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable UUID id);

    @Operation(summary = "Buscar todos os usuarios", description = "Método responsável por buscar todos os usuarios."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "204", description = "Nenhum usuário foi encontrado.",
            content = @Content())
    ResponseEntity<List<UsuarioResponse>> buscarTodosUsuarios();

    @Operation(summary = "Salvar usuario", description = "Método responsável por salvar usuarios."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "201", description = "Usuário salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "400", description = "Não foi possivel salvar usuario, devido a informações incorretas.",
            content = @Content())
    ResponseEntity<UsuarioResponse> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest);

    @Operation(summary = "Alterar usuario", description = "Método responsável por alterar usuarios."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "200", description = "Usuário alterado com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "400", description = "Não foi possivel alterar usuario, devido a informações incorretas.",
            content = @Content())
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado.",
            content = @Content())
    ResponseEntity<UsuarioResponse> editarUsuario(@PathVariable UUID id, @RequestBody UsuarioRequest usuarioRequest);

    @Operation(summary = "Excluir usuario", description = "Método responsável por excluir usuarios."
            /*security = @SecurityRequirement(name = "bearerAuth")*/)
    @ApiResponse(responseCode = "204", description = "Usuário excluido com sucesso.",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    @ApiResponse(responseCode = "404", description = "Usuario não encontrado.",
            content = @Content())
    ResponseEntity<Void> excluirUsuario(@PathVariable UUID id);
}
