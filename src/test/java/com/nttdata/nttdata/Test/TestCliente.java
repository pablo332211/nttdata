package com.nttdata.nttdata.Test;


import com.nttdata.nttdata.Entity.Cliente;
import com.nttdata.nttdata.Service.ServiceClienteIMPL;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCliente {

    @Test
    public void testValidaTipoDocumento() {
        ServiceClienteIMPL service = new ServiceClienteIMPL();

        assertTrue(service.validaTipoDocumento("P"));
        assertTrue(service.validaTipoDocumento("C"));
        assertFalse(service.validaTipoDocumento("A"));
        assertFalse(service.validaTipoDocumento(null));
    }

    @Test
    public void testValidaDocumento() {
        ServiceClienteIMPL service = new ServiceClienteIMPL();

        assertTrue(service.validaDocumento("23445322"));
        assertFalse(service.validaDocumento("12345678"));
        assertFalse(service.validaDocumento(null));
    }

    @Test
    public void testExisteCliente() {
        ServiceClienteIMPL service = new ServiceClienteIMPL();

        assertTrue(service.existeCliente("C", "23445322"));
        assertFalse(service.existeCliente("P", "23445322"));
        assertFalse(service.existeCliente("C", "12345678"));
        assertFalse(service.existeCliente(null, "23445322"));
        assertFalse(service.existeCliente("C", null));
    }

    @Test
    public void testObtenerCliente() {
        ServiceClienteIMPL service = new ServiceClienteIMPL();

        Cliente cliente = service.obtenerCliente("C", "23445322");

        assertNotNull(cliente);
        assertEquals("Cedula de ciudadania", cliente.getTipoDocumento());
        assertEquals("23445322", cliente.getNumeroDocumento());
        assertEquals("Pablo", cliente.getPrimerNombre());
        assertEquals("Enrique", cliente.getSegundoNombre());
        assertEquals("Noguera", cliente.getPrimerApellido());
        assertEquals("Guerrero", cliente.getSegundoApellido());
        assertEquals("3118683157", cliente.getTelefono());
        assertEquals("cll 52 g # 32 28", cliente.getDireccion());
        assertEquals("Bogotá", cliente.getCiudad());
    }

}
