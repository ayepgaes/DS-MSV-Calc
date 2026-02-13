package com.calculadora.backend.Controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.calculadora.backend.Servicios.OperacionesBasicasServicios;

@Controller

public class OperacionesBasicasControladores {

        private final OperacionesBasicasServicios servicios;

    public OperacionesBasicasControladores(OperacionesBasicasServicios service) {
        this.servicios = service;
    }  

    @PostMapping("/sumar")
    public ResponseEntity<Object> sumar(@RequestBody Map<String,Double> a) {
        double resp;
        resp = servicios.sumar(a.get("a"), a.get("b"));
        
        Map<String,Double> stResp;
        stResp = new HashMap();

        stResp.put("result", resp);
        return ResponseEntity.ok(stResp);
    }

    @PostMapping("/restar")
    public ResponseEntity<Object> restar(@RequestBody Map<String,Double> a) {
        double resp;
        resp = servicios.restar(a.get("a"), a.get("b"));
        
        Map<String,Double> stResp;
        stResp = new HashMap();

        stResp.put("result", resp);
        return ResponseEntity.ok(stResp);
    }

    @PostMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return servicios.multiplicar(a, b);
    }

    @PostMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        return servicios.dividir(a, b);
    }
}






