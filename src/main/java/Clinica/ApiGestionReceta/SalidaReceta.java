/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

import java.util.List;


public class SalidaReceta {
    private Long id;
    private String fec;
    private String hor;
    private SalidaAtencionDTO ate;
    private List<DetalleRecetaDTO> detRec;
    private MedicoDTO med;
    private double tot;

    public SalidaReceta() {
    }

    public SalidaReceta(Long id, String fec, String hor, SalidaAtencionDTO ate, List<DetalleRecetaDTO> detRec, MedicoDTO med, double tot) {
        this.id = id;
        this.fec = fec;
        this.hor = hor;
        this.ate = ate;
        this.detRec = detRec;
        this.med = med;
        this.tot = tot;
    }

    public MedicoDTO getMed() {
        return med;
    }

    public void setMed(MedicoDTO med) {
        this.med = med;
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

    public SalidaAtencionDTO getAte() {
        return ate;
    }

    public void setAte(SalidaAtencionDTO ate) {
        this.ate = ate;
    }

    public List<DetalleRecetaDTO> getDetRec() {
        return detRec;
    }

    public void setDetRec(List<DetalleRecetaDTO> detRec) {
        this.detRec = detRec;
    }

    public double getTot() {
        return tot;
    }

    public void setTot(double tot) {
        this.tot = tot;
    }
    
    
}
