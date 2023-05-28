package com.crud_mensaje2.ms_mensaje2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_mensaje2.ms_mensaje2.model.Mensaje;
import com.crud_mensaje2.ms_mensaje2.repository.IMensajeRepository;
@Service
public class MensajeService implements IMensajeService{
    @Autowired
    private IMensajeRepository iMensajeRepository;
    @Override
    public List<Mensaje> findAllByIDUser(int id_usuario) {
        List<Mensaje> mensajes;
        try{
            mensajes=iMensajeRepository.findAllByIDUser(id_usuario);
        }catch(Exception ex){
            throw ex;
        }
        return mensajes;
    }

    @Override
    public int save(Mensaje mensaje) {
        int row;
        try{
            row=iMensajeRepository.save(mensaje);
        }catch(Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int updatePuntos(Mensaje mensaje) {

        int row;
        try{
            row=iMensajeRepository.updatePuntos(mensaje);

        }catch(Exception ex){
            throw ex;
        }
        return row;    }
    
}
