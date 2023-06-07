package com.nttdata.nttdata.Service;

import com.nttdata.nttdata.Entity.Cliente;

public interface ServiceCliente {

    Cliente obtenerCliente(String tipoDocumento, String documento);
    boolean validaTipoDocumento(String tipoDocumento);
    boolean validaDocumento(String documento);
    boolean existeCliente(String tipoDocumento, String documento);
    void generarError500(String tipoDocumento, String numeroDocumento);


}
