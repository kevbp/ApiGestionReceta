/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clinica.ApiGestionReceta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiGestionReceta")
public class ApiGestionReceta {

    @Autowired
    private ServicioGestionReceta serv;

    @PostMapping("/procesarYGrabar")
    public SalidaReceta procesarYGrabar(@RequestBody EntradaReceta ent) {
        return serv.grabar(ent);
    }

    @GetMapping("/buscar/{idHis}")
    public SalidaReceta buscar(@PathVariable Long idRec) {
        return serv.buscar(idRec);
    }
}
