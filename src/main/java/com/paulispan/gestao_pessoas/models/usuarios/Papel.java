package com.paulispan.gestao_pessoas.models.usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "papeis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Papel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "papel_permissao",
            joinColumns = @JoinColumn(name = "papel_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id")
    )
    private List<Permissao> permissoes;
}
