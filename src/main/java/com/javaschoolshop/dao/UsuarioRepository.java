package com.javaschoolshop.dao;

import com.javaschoolshop.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
