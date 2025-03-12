package com.paulispan.gestao_pessoas.services.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Permissao;
import com.paulispan.gestao_pessoas.repositories.usuarios.PermissaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PermissaoService {
    private final PermissaoRepository permissaoRepository;

    @Transactional
    public Permissao salvarPermissao(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    public List<Permissao> buscarTodasPermissoes() {
        return permissaoRepository.findAll();
    }

    public Optional<Permissao> buscarPermissaoPorId(UUID id) {
        return permissaoRepository.findById(id);
    }

    @Transactional
    public void excluirPermissao(UUID id) {
        if (!permissaoRepository.existsById(id)) {
            throw new RuntimeException("Permissao não encontrada!");
        }
        permissaoRepository.deleteById(id);
    }

    @Transactional
    public Permissao editarPermissao(UUID id, Permissao permissao) {
        return permissaoRepository.findById(id)
                .map(updatePermissao -> {
                    updatePermissao.setNome(permissao.getNome());
                    updatePermissao.setPapeis(permissao.getPapeis());
                    return permissaoRepository.save(updatePermissao);
                })
                .orElseThrow(()-> new RuntimeException("Permissao não encontrada!"));
    }
}
