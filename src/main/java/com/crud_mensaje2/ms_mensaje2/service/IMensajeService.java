package com.crud_mensaje2.ms_mensaje2.service;

import java.util.List;

import com.crud_mensaje2.ms_mensaje2.model.Mensaje;

public interface IMensajeService  {
    public List<Mensaje> findAllByIDUser(int id_usuario);
    public int save(Mensaje mensaje);
    public int updatePuntos(Mensaje mensaje);
}


