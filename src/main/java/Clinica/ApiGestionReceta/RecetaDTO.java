/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

public class RecetaDTO {

    private Long id;
    private String fec;
    private String hor;
    private Long idAte;
    private Long idMed;
    private double tot;

    public RecetaDTO() {
    }

    public RecetaDTO(Long id, String fec, String hor, Long idAte, Long idMed, double tot) {
        this.id = id;
        this.fec = fec;
        this.hor = hor;
        this.idAte = idAte;
        this.idMed = idMed;
        this.tot = tot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public Long getIdAte() {
        return idAte;
    }

    public void setIdAte(Long idAte) {
        this.idAte = idAte;
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }

}
