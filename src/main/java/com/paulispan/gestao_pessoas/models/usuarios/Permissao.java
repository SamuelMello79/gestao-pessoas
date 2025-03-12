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
@Table(name = "permissoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
    private List<Papel> papeis;
}
