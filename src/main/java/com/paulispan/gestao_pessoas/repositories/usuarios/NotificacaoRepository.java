package com.paulispan.gestao_pessoas.repositories.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificacaoRepository extends JpaRepository<Notificacao,UUID> {
    List<Notificacao> findAllByUsuarioId(UUID id);
}
