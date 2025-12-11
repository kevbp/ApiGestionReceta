/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EntradaReceta {

    private String fec;
    private String hor;
    private Long idMed;

    public EntradaReceta() {
    }

    public EntradaReceta(String fec, String hor, Long idMed) {
        this.fec = fec;
        this.hor = hor;
        this.idMed = idMed;
    }

    public String getFec() {
        if (this.fec == null) {
            this.fec = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getHor() {
        if (this.hor == null) {
            this.hor = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }

}
