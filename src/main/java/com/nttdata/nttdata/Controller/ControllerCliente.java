package com.nttdata.nttdata.Controller;


import com.nttdata.nttdata.Entity.Cliente;
import com.nttdata.nttdata.Service.ServiceCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente{

    @Autowired
    ServiceCliente serviceCliente;


   @GetMapping("{tipoDocumento}/{numeroDocumento}")
   public ResponseEntity<Cliente> getCliente(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {

       // Respuesta 500
       serviceCliente.generarError500(tipoDocumento, numeroDocumento);

       //Respuesta 404
       if (!serviceCliente.validaTipoDocumento(tipoDocumento)) {

           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       //Respuesta 400
       if (!serviceCliente.validaDocumento(numeroDocumento)) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
       //Respuesta400
       if (!serviceCliente.existeCliente(tipoDocumento, numeroDocumento)) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       //Respuesta 200
       Cliente cliente = serviceCliente.obtenerCliente(tipoDocumento, numeroDocumento);
       return ResponseEntity.ok(cliente);
   }
}
