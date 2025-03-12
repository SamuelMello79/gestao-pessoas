package com.paulispan.gestao_pessoas.services.usuarios;

import com.paulispan.gestao_pessoas.models.usuarios.Usuario;
import com.paulispan.gestao_pessoas.repositories.usuarios.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(UUID id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public void excluirUsuario(UUID id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public Usuario editarUsuario(UUID id, Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(updateUsuario -> {
                    updateUsuario.setNome(usuario.getNome());
                    updateUsuario.setEmail(usuario.getEmail());
                    updateUsuario.setSenha(usuario.getSenha());
                    updateUsuario.setPapel(usuario.getPapel());
                    return usuarioRepository.save(updateUsuario);
                })
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));
    }
}
