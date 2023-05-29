package com.crud_mensaje2.ms_mensaje2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud_mensaje2.ms_mensaje2.model.ServiceResponse;
import com.crud_mensaje2.ms_mensaje2.model.Usuario;
import com.crud_mensaje2.ms_mensaje2.service.IUsuarioService;

@RestController
@RequestMapping("api/v1/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private IUsuarioService iUsuarioService;

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> list(){
        var result = iUsuarioService.findAll();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/returnUserById/{id}")
    public ResponseEntity<Usuario> returnUserById(@PathVariable int id){
        var result = iUsuarioService.returnUserById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/returnLastCreated")
    public ResponseEntity<Usuario> returnLastCreated(){
        var result = iUsuarioService.returnLastCreated();
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        ServiceResponse serviceResponse= new ServiceResponse();
        int result=iUsuarioService.save(usuario);
        Usuario usuarioSaved=new Usuario();
        if(result==1){
            
            usuarioSaved.setId_usuario(iUsuarioService.returnLastCreated().getId_usuario());
            usuarioSaved.setNombre(iUsuarioService.returnLastCreated().getNombre());
            usuarioSaved.setApellido(iUsuarioService.returnLastCreated().getApellido());
            serviceResponse.setMessage("usuario guradado con exito");
        }
        return new ResponseEntity<>(usuarioSaved ,HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result= iUsuarioService.deleteById(id);
        if(result==1){
            serviceResponse.setMessage("usuario borrado con exito");

        }
        return new ResponseEntity<ServiceResponse>(serviceResponse,HttpStatus.OK);
    }
}
