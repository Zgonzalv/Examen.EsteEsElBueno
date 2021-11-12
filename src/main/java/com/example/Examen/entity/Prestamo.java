package com.example.Examen.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
public class Prestamo  {
    private String fecha;
    private int fechaDevolucion;
    private String estado;
    private ItemPrestamo item;



}
