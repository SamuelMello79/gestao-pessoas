package com.paulispan.gestao_pessoas.services.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Papel;
import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import com.paulispan.gestao_pessoas.repositories.usuarios.PapelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PapelService {
    private final PermissaoService permissaoService;
    private final PapelRepository papelRepository;

    @Transactional
    public Papel salvarUsuario(Papel papel) {
        return papelRepository.save(papel);
    }

    public List<Papel> buscarTodosPapeis() {
        return papelRepository.findAll();
    }

    public Optional<Papel> buscarPapelPorId(UUID id) {
        return papelRepository.findById(id);
    }

    @Transactional
    public void excluirPapel(UUID id) {
        Papel papel = papelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Papel não encontrado!"));

        papel.getPermissoes().clear();
        papelRepository.save(papel);

        papelRepository.deleteById(id);
    }

    @Transactional
    public Papel editarPapel(UUID id, Papel papel) {
        List<Permissao> permissaos = findPermissoes(papel);
        return papelRepository.findById(id)
                .map(updatePapel -> {
                    updatePapel.setNome(papel.getNome());

                    updatePapel.getPermissoes().clear();
                    updatePapel.getPermissoes().addAll(permissaos);

                    return papelRepository.save(updatePapel);
                })
                .orElseThrow(()-> new RuntimeException("Papel não encontrado!"));
    }

    private List<Permissao> findPermissoes(Papel papel) {
        return papel.getPermissoes().stream()
                .map(permissao -> permissaoService.buscarPermissaoPorId(permissao.getId())
                        .orElseThrow(() -> new RuntimeException("Permissão não encontrada!")))
                .toList();
    }
}
