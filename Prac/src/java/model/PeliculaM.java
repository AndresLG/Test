package model;

import lombok.Data;

@Data
public class PeliculaM {
    private int idPel;
    private String titulo,estado,Genero_idGen,Director_idDirect,Actor_idAct;
}
