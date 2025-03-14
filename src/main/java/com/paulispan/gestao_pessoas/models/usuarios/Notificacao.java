package com.paulispan.gestao_pessoas.models.usuarios;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Entity
@Table(name = "notificacoes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String mensagem;
    private Boolean lida;
    private LocalDate dataCriacao;
    private LocalDate dataVisualizacao;
}
