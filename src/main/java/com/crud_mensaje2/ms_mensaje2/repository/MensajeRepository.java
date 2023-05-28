package com.crud_mensaje2.ms_mensaje2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud_mensaje2.ms_mensaje2.model.Mensaje;
@Repository
public class MensajeRepository implements IMensajeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<Mensaje> findAllByIDUser( int id_usuario) {
        String SQL= "select * from tbl_mensaje where id_usuario=? ";
        return jdbcTemplate. query(SQL,BeanPropertyRowMapper.newInstance(Mensaje.class),new Object[]{id_usuario});
    }

    @Override
    public int save(Mensaje mensaje) {
        String SQL="INSERT INTO tbl_mensaje VALUES (?,?,getDate(),?)";
        return jdbcTemplate.update(SQL,new Object[]{mensaje.getContenido(),mensaje.getPuntos(),mensaje.getId_usuario()});
    }

    @Override
    public int updatePuntos(Mensaje mensaje) {
        String SQL="UPDATE tbl_mensaje SET puntos=? WHERE id_mensaje=?";
        return jdbcTemplate.update(SQL,new Object[]{mensaje.getPuntos(),mensaje.getId_mensaje()});
    }

    
}
