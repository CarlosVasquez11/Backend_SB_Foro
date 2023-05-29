package com.crud_mensaje2.ms_mensaje2.repository;

import java.util.List;

import com.crud_mensaje2.ms_mensaje2.model.Mensaje;

public interface IMensajeRepository {
    public List<Mensaje> findAllByIDUser(int id_usuario);
    public int save(Mensaje mensaje);
    public int subirPuntos(Mensaje mensaje);
    public int disminuirPuntos(Mensaje mensaje);
}
