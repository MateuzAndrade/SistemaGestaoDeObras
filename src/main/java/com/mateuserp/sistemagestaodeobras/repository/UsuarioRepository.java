package com.mateuserp.sistemagestaodeobras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateuserp.sistemagestaodeobras.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value="SELECT * FROM usuario where usuario = :usuario and senha = :senha", nativeQuery=true)
    Usuario findByUsuarioAndSenha(@Param("usuario") String usuario, @Param("senha") String senha);
}
