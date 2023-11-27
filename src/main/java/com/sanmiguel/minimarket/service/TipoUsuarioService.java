package com.sanmiguel.minimarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanmiguel.minimarket.modelo.TipoUsuario;
import com.sanmiguel.minimarket.repositorio.TipoUsuarioRepositorio;

@Service
public class TipoUsuarioService {

	@Autowired
	TipoUsuarioRepositorio tur;
	
	public List<TipoUsuario> listarTipoUsuarios() {
        return (List<TipoUsuario>) tur.findAll();
    }
	
	public void guardarTipoUsuario(TipoUsuario tipousuario) {
		tur.save(tipousuario);
	}
	
	public TipoUsuario obtenerTipoUsuarioPorId(Integer id) {
		return tur.findById(id).orElse(null);
	}
	
	public void eliminarTipoUsuarioPorId(Integer id) {
		TipoUsuario tipousuarioDel = tur.findById(id).orElse(null);
		tur.delete(tipousuarioDel);
	}
	
}
