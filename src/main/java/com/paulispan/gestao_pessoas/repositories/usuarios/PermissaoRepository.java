package com.paulispan.gestao_pessoas.repositories.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {
}
