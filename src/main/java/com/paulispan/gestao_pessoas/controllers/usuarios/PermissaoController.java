package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.PermissaoRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PermissaoResponse;
import com.paulispan.gestao_pessoas.mappers.usuarios.PermissaoMapper;
import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import com.paulispan.gestao_pessoas.services.usuarios.PermissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/permissoes")
@RequiredArgsConstructor
public class PermissaoController {
    private final PermissaoService permissaoService;

    @GetMapping("/{id}")
    public ResponseEntity<PermissaoResponse> buscarPorId(@PathVariable UUID id) {
        return permissaoService.buscarPermissaoPorId(id)
                .map(permisssao -> ResponseEntity.ok(PermissaoMapper.map(permisssao)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<PermissaoResponse>> buscarTodosPermissoes() {
        return ResponseEntity.ok(permissaoService.buscarTodasPermissoes().stream()
                .map(PermissaoMapper::map).toList());
    }

    @PostMapping
    public ResponseEntity<PermissaoResponse> salvarPermissao(@RequestBody PermissaoRequest permissaoRequest) {
        Permissao permissao = permissaoService.salvarPermissao(PermissaoMapper.map(permissaoRequest));
        return ResponseEntity.ok(PermissaoMapper.map(permissao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissaoResponse> editarPermissao(@PathVariable UUID id, @RequestBody PermissaoRequest permissaoRequest) {
        Permissao permissao = permissaoService.editarPermissao(id,PermissaoMapper.map(permissaoRequest));
        return ResponseEntity.ok(PermissaoMapper.map(permissao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPermissao(@PathVariable UUID id) {
        permissaoService.excluirPermissao(id);
        return ResponseEntity.noContent().build();
    }
}
