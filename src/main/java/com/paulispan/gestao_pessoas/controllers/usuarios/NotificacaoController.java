package com.paulispan.gestao_pessoas.controllers.usuarios;

import com.paulispan.gestao_pessoas.dto.request.NotificacaoRequest;
import com.paulispan.gestao_pessoas.dto.response.NotificacaoResponse;
import com.paulispan.gestao_pessoas.mappers.NotificacaoMapper;
import com.paulispan.gestao_pessoas.models.usuarios.Notificacao;
import com.paulispan.gestao_pessoas.services.usuarios.NotificaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notificacoes")
@RequiredArgsConstructor
public class NotificacaoController {
    private final NotificaoService notificacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoResponse> buscarPorId(@PathVariable UUID id) {
        return notificacaoService.buscarNotificacaoPorId(id)
                .map(notificacao -> ResponseEntity.ok(NotificacaoMapper.map(notificacao)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<NotificacaoResponse>> buscarTodosNotificacao() {
        return ResponseEntity.ok(notificacaoService.buscarTodasNotificacoes().stream()
                .map(NotificacaoMapper::map).toList());
    }

    @PostMapping
    public ResponseEntity<NotificacaoResponse> salvarNotificacao(@RequestBody NotificacaoRequest notificacaoRequest) {
        Notificacao notificacao = notificacaoService.salvarNotificacao(NotificacaoMapper.map(notificacaoRequest));
        return ResponseEntity.ok(NotificacaoMapper.map(notificacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoResponse> editarNotificacao(@PathVariable UUID id, @RequestBody NotificacaoRequest notificacaoRequest) {
        Notificacao notificacao = notificacaoService.editarNotificacao(id,NotificacaoMapper.map(notificacaoRequest));
        return ResponseEntity.ok(NotificacaoMapper.map(notificacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNotificacao(@PathVariable UUID id) {
        notificacaoService.excluirNotificacao(id);
        return ResponseEntity.noContent().build();
    }
}
