package servicio;


import java.util.ArrayList;
import java.util.List;
import modelo.CategoriaEnum;
import modelo.Cliente;


public class ClienteServicio {
	
	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}

	public ClienteServicio() {
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
	public void listarClientes() {
		
		Cliente clientUno = new Cliente();
		clientUno.setRunCliente("12.123.412-2");
		clientUno.setNombreCliente("Nicolas");
		clientUno.setApellidoCliente("Cake");
		clientUno.setAniosCliente("7 a?os");
		clientUno.setNombreCategoria(CategoriaEnum.Activo);
		
		
		Cliente clientDos = new Cliente();
		clientDos.setRunCliente("25.673.022-2");
		clientDos.setNombreCliente("Taylor");
		clientDos.setApellidoCliente("Shift S.");
		clientDos.setAniosCliente("1 d?a");
		clientDos.setNombreCategoria(CategoriaEnum.Activo);
		
	
		listaClientes.add(clientUno);
		listaClientes.add(clientDos);
		
		this.listaClientes.stream().forEach(
				(listaFinal) -> {
			System.out.println("----------Datos del Cliente----------");
			System.out.println("Run del Cliente: " + listaFinal.getRunCliente());
			System.out.println("Nombre del Cliente: " + listaFinal.getNombreCliente());
			System.out.println("Apellido del Cliente: " + listaFinal.getApellidoCliente());
			System.out.println("A?os como Cliente: " + listaFinal.getAniosCliente());
			System.out.println("Categor?a del Cliente: " + listaFinal.getNombreCategoria());
			System.out.println("\n------------------------------------");
		}
);
	}
	
	
	
	public void agregarCliente(Cliente client) {
		this.listaClientes.add(client);

	
	}
	public void editarCliente(Cliente cEditar) {
	

	}

}
