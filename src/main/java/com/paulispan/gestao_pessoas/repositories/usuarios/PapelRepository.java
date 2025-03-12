package com.paulispan.gestao_pessoas.repositories.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PapelRepository extends JpaRepository<Papel, UUID> {
}
