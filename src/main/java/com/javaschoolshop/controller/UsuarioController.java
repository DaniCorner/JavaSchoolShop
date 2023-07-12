package com.javaschoolshop.controller;

import com.javaschoolshop.dao.UsuarioRepository;
import com.javaschoolshop.entity.Rol;
import com.javaschoolshop.entity.Usuario;
import com.javaschoolshop.entity.UsuarioRol;
import com.javaschoolshop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        usuario.setPerfil("default.png");
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

    @PutMapping("/{username}")
    public Usuario actualizarUsuario(@PathVariable("username") String username, @RequestBody Usuario usuarioActualizado) throws Exception {
        Usuario usuarioExistente = usuarioService.obtenerUsuario(username);
        if (usuarioExistente == null) {
            throw new Exception("User doesn't exist");
        }
        // Actualiza los campos relevantes del usuario existente con los valores del usuario actualizado
        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setApellido(usuarioActualizado.getApellido());
        usuarioExistente.setEmail(usuarioActualizado.getEmail());
        usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        usuarioExistente.setPassword(usuarioActualizado.getPassword());
        // Guarda el usuario actualizado en la base de datos
        return usuarioService.guardarUsuario(usuarioExistente);
    }
}
