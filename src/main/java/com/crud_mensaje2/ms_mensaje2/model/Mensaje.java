package com.crud_mensaje2.ms_mensaje2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Mensaje {
    int id_mensaje;
	String contenido;
	int puntos;
	Timestamp hora;
	int nivel;
	int jerarquia;
	int id_usuario ;
}
