package com.crud_mensaje2.ms_mensaje2.service;

import java.util.List;

import com.crud_mensaje2.ms_mensaje2.model.Usuario;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public int save(Usuario usuario);
    public Usuario returnUserById(int id_usuario);
    public Usuario returnLastCreated();;
    public int deleteById(int id);

}
