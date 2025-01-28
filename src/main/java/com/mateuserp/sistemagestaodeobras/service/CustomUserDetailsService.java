package com.mateuserp.sistemagestaodeobras.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mateuserp.sistemagestaodeobras.model.Usuario;
import com.mateuserp.sistemagestaodeobras.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username); 
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        // Retorna o usuário com a senha e as permissões
        return org.springframework.security.core.userdetails.User
            .builder()
            .username(usuario.getUsuario())
            .password(usuario.getSenha())
            .authorities("ROLE_USER") // Adiciona as roles/autoridades
            .build();
    }
}
