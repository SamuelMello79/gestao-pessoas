package com.paulispan.gestao_pessoas.mappers.usuarios;

import com.paulispan.gestao_pessoas.dto.usuarios.request.UsuarioRequest;
import com.paulispan.gestao_pessoas.dto.usuarios.response.PapelResponse;
import com.paulispan.gestao_pessoas.dto.usuarios.response.UsuarioResponse;
import com.paulispan.gestao_pessoas.models.usuarios.Papel;
import com.paulispan.gestao_pessoas.models.usuarios.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public static Usuario map(UsuarioRequest usuarioRequest) {
        Papel papel = Papel.builder().id(usuarioRequest.papel()).build();

        return Usuario
                .builder()
                .nome(usuarioRequest.nome())
                .senha(usuarioRequest.senha())
                .email(usuarioRequest.email())
                .papel(papel)
                .build();
    }

    public static UsuarioResponse map(Usuario usuario) {
        PapelResponse papel = PapelMapper.map(usuario.getPapel());

        return UsuarioResponse
                .builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .papel(papel)
                .build();
    }
}
