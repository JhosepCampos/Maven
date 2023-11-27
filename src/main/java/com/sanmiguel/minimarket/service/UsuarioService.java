package com.sanmiguel.minimarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.Usuario;
import com.sanmiguel.minimarket.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepositorio ur;
	
	public List<Usuario> listarUsuarios() {
        return (List<Usuario>) ur.findAll();
    }
	
	public void guardarUsuario(Usuario usuario) {
		ur.save(usuario);
	}
	
	public Usuario obtenerUsuarioPorId(Integer id) {
		return ur.findById(id).orElse(null);
	}
	
	public void eliminarUsuarioPorId(Integer id) {
		Usuario usuarioDel = ur.findById(id).orElse(null);
		ur.delete(usuarioDel);
	}
}
