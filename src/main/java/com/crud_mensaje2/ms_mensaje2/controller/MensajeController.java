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

import com.crud_mensaje2.ms_mensaje2.model.Mensaje;
import com.crud_mensaje2.ms_mensaje2.model.ServiceResponse;
import com.crud_mensaje2.ms_mensaje2.service.IMensajeService;

@RestController
@RequestMapping("api/v1/mensaje")
@CrossOrigin("*")
public class MensajeController {
    @Autowired
    private IMensajeService imensajeService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Mensaje>> list(@PathVariable int id){
        var result = imensajeService.findAllByIDUser(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Mensaje mensaje){
        ServiceResponse serviceResponse= new ServiceResponse();
        int result=imensajeService.save(mensaje);
        if(result==1){
            serviceResponse.setMessage("Mensaje guardado satisfactoriamente");
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

    @PostMapping("/updatePuntos")
    public ResponseEntity<ServiceResponse> updatePuntos(@RequestBody Mensaje mensaje){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result =imensajeService.updatePuntos(mensaje);
        if(result==1){
            serviceResponse.setMessage("Mensaje actualizado con exito");
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

   
}
