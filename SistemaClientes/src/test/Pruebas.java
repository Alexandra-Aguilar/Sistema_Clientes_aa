package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class Pruebas {

	@Test
	public void agregarClienteTest() {
		Cliente client = new Cliente();
		client.setRunCliente("12.123.123-1");
		client.setNombreCliente("Fernanda");
		client.setApellidoCliente("Granado");
		client.setAniosCliente("7 Años");
		client.setNombreCategoria(CategoriaEnum.Activo);
		
		ClienteServicio clienteServicio = new ClienteServicio();
		clienteServicio.agregarCliente(client);
		
		assertTrue(client.getRunCliente().equals("12.123.123-1"));
		assertTrue(client.getNombreCliente().equals("Fernanda"));
		assertTrue(client.getApellidoCliente().equals("Granado"));
		assertTrue(client.getAniosCliente().equals("7 Años"));
		assertTrue(client.getNombreCategoria().equals(CategoriaEnum.Activo));
	}
	
	@Test
	public void agregarClienteNullTest() {
		
		Cliente client = new Cliente();
		client.setRunCliente("12.123.123-1");
		client.setNombreCliente("Fernanda");
		client.setApellidoCliente("Granado");
		client.setAniosCliente("7 Años");
		client.setNombreCategoria(CategoriaEnum.Activo);
		
		ClienteServicio clienteServicio = new ClienteServicio();
		clienteServicio.agregarCliente(client);
		
		assertNotNull(client.getRunCliente());
		assertNotNull(client.getNombreCliente());
		assertNotNull(client.getApellidoCliente());
		assertNotNull(client.getAniosCliente());
		assertNotNull(client.getNombreCategoria());
		
	}

}
