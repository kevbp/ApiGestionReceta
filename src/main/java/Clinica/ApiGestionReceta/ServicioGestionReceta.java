/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioGestionReceta {
    @Autowired
    private RestTemplate resTem;
    
    public SalidaReceta grabar(EntradaReceta ent) {
        
        String urlNueRec = "http://ApiNuevaReceta/apiNuevaReceta/salida";
        SalidaNuevaRecetaDTO salNueRec = resTem.getForObject(urlNueRec, SalidaNuevaRecetaDTO.class);
        
        String urlCesRec = "http://ApiCestaReceta/apiCestaReceta/verCesta";
        ResponseEntity<List<LineaRecetaDTO>> resLisLinRec = resTem.exchange(urlCesRec, HttpMethod.GET, null, new ParameterizedTypeReference<List<LineaRecetaDTO>>() {
        });
        List<LineaRecetaDTO> lisLinRec = resLisLinRec.getBody();
        
        String urlTotCesRec = "http://ApiCestaReceta/apiCestaReceta/verTotal";
        double totCesRec = resTem.getForObject(urlTotCesRec, double.class);
        
        Long idAte = salNueRec.getAte().getIdAte();
        String fec = ent.getFec();
        String hor = ent.getHor();
        Long idMed = ent.getIdMed();

        String urlMed = "http://ApiMedico/medico/buscar/" + idMed;
        String urlAte = "http://ApiGestionAtencion/apiGestionAtencion/buscar/" + idAte;
        
        MedicoDTO med = resTem.getForObject(urlMed, MedicoDTO.class);
        SalidaAtencionDTO ate = resTem.getForObject(urlAte, SalidaAtencionDTO.class);
        
        RecetaDTO rec = new RecetaDTO();
        rec.setFec(fec);
        rec.setHor(hor);
        rec.setIdAte(ate.getIdAte());
        rec.setIdMed(med.getId());
        rec.setTot(totCesRec);
        
        String urlGraRec = "http://ApiReceta/receta/grabar";
        RecetaDTO recReg = resTem.postForObject(urlGraRec, hor, RecetaDTO.class);

        String urlGraDetRec = "http://ApiDetalleReceta/detalleReceta/grabar";
        for (LineaRecetaDTO linRec : lisLinRec) {
            DetalleRecetaDTO detRec = new DetalleRecetaDTO();
            detRec.setIdRec(recReg.getId());
            detRec.setIdMto(linRec.getIdMto());
            detRec.setNomMto(linRec.getNom());
            detRec.setDesMto(linRec.getDes());
            detRec.setPre(linRec.getPre());
            detRec.setCan(linRec.getCan());
            detRec.setImp(linRec.getImporte());
            resTem.postForObject(urlGraDetRec, detRec, DetalleRecetaDTO.class);
        }

        return buscar(recReg.getId());
    }
    
    public SalidaReceta buscar(Long id) {

        String urlBusRec = "http://ApiReceta/receta/buscar/" + id;
        RecetaDTO rec = resTem.getForObject(urlBusRec, RecetaDTO.class);

        String urlAte = "http://ApiGestionAtencion/apiGestionAtencion/buscar/" + rec.getIdAte();
        String urlLisDetRec = "http://ApiDetalleReceta/detalleReceta/listarPorReceta/" + rec.getId();
        String urlMed = "http://ApiMedico/medico/buscar/" + rec.getIdMed();

        SalidaAtencionDTO ate = resTem.getForObject(urlAte, SalidaAtencionDTO.class);
        ResponseEntity<List<DetalleRecetaDTO>> resLisDetRec = resTem.exchange(urlLisDetRec, HttpMethod.GET, null, new ParameterizedTypeReference<List<DetalleRecetaDTO>>() {
        });
        List<DetalleRecetaDTO> lisDetRec = resLisDetRec.getBody();
        MedicoDTO med = resTem.getForObject(urlMed, MedicoDTO.class);

        SalidaReceta salRec = new SalidaReceta();
        salRec.setId(rec.getId());
        salRec.setFec(rec.getFec());
        salRec.setHor(rec.getHor());
        salRec.setAte(ate);
        salRec.setDetRec(lisDetRec);
        salRec.setMed(med);
        salRec.setTot(rec.getTot());

        return salRec;
    }
}
