package com.nttdata.nttdata.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdata.nttdata.Entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ServiceClienteIMPL implements ServiceCliente {

    private static Logger logger = LoggerFactory.getLogger(ServiceClienteIMPL.class);
    @Override
    public Cliente obtenerCliente(String tipoDocumento, String documento) {

            Cliente cliente = new Cliente();
            cliente.setTipoDocumento("Cedula de ciudadania");
            cliente.setNumeroDocumento(documento);
            cliente.setPrimerNombre("Pablo");
            cliente.setSegundoNombre("Enrique");
            cliente.setPrimerApellido("Noguera");
            cliente.setSegundoApellido("Guerrero");
            cliente.setTelefono("3118683157");
            cliente.setDireccion("cll 52 g # 32 28");
            cliente.setCiudad("Bogotá");
            return cliente;

    }

    @Override //Generera error 500 bajo cierto parametro
    public void generarError500(String tipoDocumento, String numeroDocumento) {
        if (numeroDocumento.equals("123456") && (tipoDocumento.equals("C") || tipoDocumento.equals("P"))) {
            logger.error("Error interno en el servidor = [500]");
            throw new RuntimeException("Error interno en el servidor");
        }
    }


    @Override //valida si existe el tipo documento o si es correcto el ingresado
    public boolean validaTipoDocumento(String tipoDocumento) {
        boolean validar = tipoDocumento != null && (tipoDocumento.equals("P") || tipoDocumento.equals("C"));
        if(!validar){
            logger.warn("404: El siguiente tipo de documento ingresado no es existe: {}", tipoDocumento);
        }
        return validar;
    }

    @Override
    public boolean validaDocumento(String documento) {
        boolean validar =  documento!=null && documento.equals("23445322");
        if (!validar){
            logger.warn("400: Cliente no registrado con numero: {}", documento);
        }
        return validar;
    }

    @Override
    public boolean existeCliente(String tipoDocumento, String documento) {
        boolean validar = tipoDocumento!=null && documento!=null && tipoDocumento.equals("C") && documento.equals("23445322");
        if (!validar){
            logger.warn("400: Cliente no registrado con numero: {}", documento);
        }else {
            logger.info("200: Documento registrado con numero: {}", documento);
        }
        return validar;
    }



}
