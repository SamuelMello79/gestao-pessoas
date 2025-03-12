package com.paulispan.gestao_pessoas.services.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Notificacao;
import com.paulispan.gestao_pessoas.repositories.usuarios.NotificacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificaoService {
    private final NotificacaoRepository notificacaoRepository;

    @Transactional
    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> buscarTodasNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> buscarNotificacaoPorId(UUID id) {
        return notificacaoRepository.findById(id);
    }

    @Transactional
    public void excluirNotificacao(UUID id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new RuntimeException("Notificacao não encontrada!");
        }
        notificacaoRepository.deleteById(id);
    }

    @Transactional
    public Notificacao editarNotificacao(UUID id, Notificacao notificacao) {
        return notificacaoRepository.findById(id)
                .map(updateNotificacao -> {
                    updateNotificacao.setDataCriacao(notificacao.getDataCriacao());
                    updateNotificacao.setLida(notificacao.getLida());
                    updateNotificacao.setUsuario(notificacao.getUsuario());
                    updateNotificacao.setMensagem(notificacao.getMensagem());
                    updateNotificacao.setDataVisualizacao(notificacao.getDataVisualizacao());
                    return notificacaoRepository.save(updateNotificacao);
                })
                .orElseThrow(()-> new RuntimeException("Notificacao não encontrada!"));
    }
}
