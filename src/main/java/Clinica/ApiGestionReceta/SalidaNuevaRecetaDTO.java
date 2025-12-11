/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

public class SalidaNuevaRecetaDTO {

    private SalidaAtencionDTO ate;

    public SalidaNuevaRecetaDTO() {
    }

    public SalidaNuevaRecetaDTO(SalidaAtencionDTO ate) {
        this.ate = ate;
    }

    public SalidaAtencionDTO getAte() {
        return ate;
    }

    public void setAte(SalidaAtencionDTO ate) {
        this.ate = ate;
    }

}
