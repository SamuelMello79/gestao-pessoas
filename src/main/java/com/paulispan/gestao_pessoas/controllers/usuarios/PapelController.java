package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.request.PapelRequest;
import com.paulispan.gestao_pessoas.dto.response.PapelResponse;
import com.paulispan.gestao_pessoas.mappers.PapelMapper;
import com.paulispan.gestao_pessoas.models.usuarios.Papel;
import com.paulispan.gestao_pessoas.services.usuarios.PapelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/papeis")
@RequiredArgsConstructor
public class PapelController {
    private final PapelService papelService;

    @GetMapping("/{id}")
    public ResponseEntity<PapelResponse> buscarPorId(@PathVariable UUID id) {
        return papelService.buscarPapelPorId(id)
                .map(papel -> ResponseEntity.ok(PapelMapper.map(papel)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<PapelResponse>> buscarTodosPapeis() {
        return ResponseEntity.ok(papelService.buscarTodosPapeis().stream()
                .map(PapelMapper::map).toList());
    }

    @PostMapping
    public ResponseEntity<PapelResponse> salvarPapel(@RequestBody PapelRequest papelRequest) {
        Papel papel = papelService.salvarUsuario(PapelMapper.map(papelRequest));
        return ResponseEntity.ok(PapelMapper.map(papel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PapelResponse> editarPapel(@PathVariable UUID id, @RequestBody PapelRequest papelRequest) {
        Papel papel = papelService.editarPapel(id,PapelMapper.map(papelRequest));
        return ResponseEntity.ok(PapelMapper.map(papel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPapel(@PathVariable UUID id) {
        papelService.excluirPapel(id);
        return ResponseEntity.noContent().build();
    }
}
