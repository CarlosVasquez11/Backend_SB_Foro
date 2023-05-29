package com.crud_mensaje2.ms_mensaje2.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud_mensaje2.ms_mensaje2.model.Usuario;
@Repository
public class UsuarioRepository implements IUsuarioRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int deleteById(int id) {
        String SQL="DELETE tbl_usuario WHERE id_usuario=?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }

    @Override
    public List<Usuario> findAll() {
        String SQL= "SELECT * FROM tbl_usuario";
        return jdbcTemplate.query(SQL,BeanPropertyRowMapper.newInstance(Usuario.class));
    }
    @Override
    public Usuario returnUserById(int id_usuario){
        String SQL="SELECT * from tbl_usuario where id_usuario=?";
        List<Usuario> listUser=jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Usuario.class),new Object[]{id_usuario});
        return listUser.get(0);
    }
    @Override
    public Usuario returnLastCreated(){
        String SQL="SELECT * from tbl_usuario where id_usuario=(SELECT top 1 id_usuario from tbl_usuario ORDER BY id_usuario DESC)";
        List<Usuario> listUser=jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Usuario.class));
        return listUser.get(0);
    }

    @Override
    public int save(Usuario usuario) {
        String SQL="INSERT INTO tbl_usuario VALUES (?,?)";
        return jdbcTemplate.update(SQL,new Object[]{usuario.getNombre(),usuario.getApellido()});
    }
}
