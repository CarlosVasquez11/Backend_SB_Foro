package com.crud_mensaje2.ms_mensaje2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_mensaje2.ms_mensaje2.model.Usuario;
import com.crud_mensaje2.ms_mensaje2.repository.IUsuarioRepository;


@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Override
    public int deleteById(int id) {
        int row;
        try{    
            row=iUsuarioRepository.deleteById(id);

        }catch(Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> list;
        try{    
            list=iUsuarioRepository.findAll();

        }catch(Exception ex){
            throw ex;
        }
        return list;
    }


    @Override
    public int save(Usuario usuario) {
        int row;
        try{    
            row=iUsuarioRepository.save(usuario);

        }catch(Exception ex){
            throw ex;
        }
        return row;
    }
    @Override
    public Usuario returnUserById(int id_usuario){
        Usuario usuarioSaved;
        try{    
            usuarioSaved=iUsuarioRepository.returnUserById(id_usuario);
        }catch(Exception ex){
            throw ex;
        }
        return usuarioSaved;
    }
    @Override
    public Usuario returnLastCreated(){
        Usuario usuarioSaved;
        try{    
            usuarioSaved=iUsuarioRepository.returnLastCreated();
        }catch(Exception ex){
            throw ex;
        }
        return usuarioSaved;
    }
    
}
