package com.crud_mensaje2.ms_mensaje2.repository;

import java.util.List;

import com.crud_mensaje2.ms_mensaje2.model.Usuario;

public interface IUsuarioRepository {
    public List<Usuario> findAll();
    public int save(Usuario usuario);
    public Usuario returnUserById(int id_usuario);
    public Usuario returnLastCreated();
    public int update(Usuario usuario);
    public int deleteById(int id);
}
