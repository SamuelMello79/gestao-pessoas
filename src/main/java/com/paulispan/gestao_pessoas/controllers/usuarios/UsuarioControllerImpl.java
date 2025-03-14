package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.UsuarioRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.UsuarioResponse;
import com.paulispan.gestao_pessoas.mappers.usuarios.UsuarioMapper;
import com.paulispan.gestao_pessoas.models.usuarios.Usuario;
import com.paulispan.gestao_pessoas.services.usuarios.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioResponse> buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email)
                .map(usuario -> ResponseEntity.ok(UsuarioMapper.map(usuario)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable UUID id) {
        return usuarioService.buscarUsuarioPorId(id)
                .map(usuario -> ResponseEntity.ok(UsuarioMapper.map(usuario)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioResponse>> buscarTodosUsuarios() {
        return ResponseEntity.ok(usuarioService.buscarTodosUsuarios().stream()
                .map(UsuarioMapper::map)
                .toList());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> salvarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.map(usuarioRequest));
        return ResponseEntity.ok(UsuarioMapper.map(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> editarUsuario(@PathVariable UUID id, @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.editarUsuario(id, UsuarioMapper.map(usuarioRequest));
        return ResponseEntity.ok(UsuarioMapper.map(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable UUID id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
