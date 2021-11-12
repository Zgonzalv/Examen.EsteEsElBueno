package com.example.Examen.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {
    private String nombre;
    private String dni;
    private String domicilio;
    private List <Prestamo> prestamos;


}
