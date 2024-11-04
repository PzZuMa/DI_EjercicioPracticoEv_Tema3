package org.example.di_ejerciciopracticoev_tema3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String correo;
    private String plataforma;
    private Boolean admin;
    private Integer software;
    private LocalDateTime fecha;

    @Override
    public String toString() {
        return "Correo: " + correo +
                "\nPlataforma: " + plataforma +
                "\nAdmin: " + admin +
                "\nSoftware: " + software +
                "\nFecha: " + fecha;
    }
}


