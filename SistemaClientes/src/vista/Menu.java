package vista;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;

public class Menu extends MenuAbs {
	 
	 private ClienteServicio clienteServicio = new ClienteServicio();
	 private ExportadorCsv exportarCsv = new ExportadorCsv();
	 private ExportadorTxt exportarTxt = new ExportadorTxt();
	 private String fileName = "Clientes";
	 private String fileName1 = "DBClientes.csv";
	 private Scanner teclado = new Scanner(System.in);
	 

	@Override
	public void listarCliente() {
		clienteServicio.listarClientes();
		
		
	}

	@Override
	public void agregarCliente() {
		
		Cliente client = new Cliente();
	
	
		System.out.println("----------Crear Cliente----------");

		System.out.println("Ingresa RUN del Cliente: ");
		client.setRunCliente(teclado.nextLine().trim());
	
		System.out.println("Ingresa Nombre del Cliente: ");
		client.setNombreCliente(teclado.nextLine().trim());

		System.out.println("Ingresa Apellido del Cliente: ");
		client.setApellidoCliente(teclado.nextLine().trim());
		
		System.out.println("Ingresa A?os del Cliente: ");
		client.setAniosCliente(teclado.nextLine().trim());
		
		client.setNombreCategoria(CategoriaEnum.Activo);
		
		
		clienteServicio.agregarCliente(client);
		
		
	}

	@Override
	public void editarCliente() {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qu? desea hacer: ");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion: ");
		
		int opcionEditar = Integer.parseInt(teclado.nextLine().trim());
		
		System.out.println("Ingrese RUN del Cliente a editar: ");
		String runClienteT = teclado.nextLine().trim();
		
		int posicion = -1, contador = 0;
		
		for (Cliente c: clienteServicio.getListaClientes()) {
			if (c.getRunCliente().equals(runClienteT)) {
				posicion = contador;
			}
			contador++;
		}
		
		if (posicion >= 0) {
			Cliente cEditar = clienteServicio.getListaClientes().get(posicion);
			if (opcionEditar == 1) {
				System.out.println("\n-----Actualizando estado del Cliente----\n");
				if (cEditar.getNombreCategoria().equals(CategoriaEnum.Activo))
					cEditar.setNombreCategoria(CategoriaEnum.Inactivo);
				else 
					cEditar.setNombreCategoria(CategoriaEnum.Activo);
				System.out.println("El estado del Cliente ha sido modificado.");
			}
			
			else if (opcionEditar == 2 ){
				System.out.println("\n----Actualizando datos del Cliente-----\n");
				System.out.println("1.-El RUN del Cliente es: " + cEditar.getRunCliente());
				System.out.println("2.-El Nombre del Cliente es: " + cEditar.getNombreCliente());
				System.out.println("3.-El Apellido del Cliente es: " + cEditar.getApellidoCliente());
				System.out.println("4.-Los a?os como Cliente son: " + cEditar.getAniosCliente());
				
				System.out.println("\nIngrese opcion a editar de los datos del cliente: ");
				int cliEdit = Integer.parseInt(teclado.nextLine().trim());
				
				switch (cliEdit) {
				case 1:
					System.out.println("1.-Ingrese nuevo RUN del Cliente: ");
					String runNew = teclado.nextLine().trim();
					cEditar.setRunCliente(runNew);
					break;
				case 2:
					System.out.println("1.-Ingrese nuevo Nombre del Cliente: ");
					String nombreNew = teclado.nextLine().trim();
					cEditar.setNombreCliente(nombreNew);
					break;
				case 3:
					System.out.println("1.-Ingrese nuevo Apellido del Cliente: ");
					String apellidoNew = teclado.nextLine().trim();
					cEditar.setApellidoCliente(apellidoNew);
					break;
				case 4:
					System.out.println("1.-Ingrese nueva cantidad de a?os como Cliente: ");
					String aniosNew = teclado.nextLine().trim();
					cEditar.setAniosCliente(aniosNew);
					break;
				}
				
				System.out.println("Datos cambiados con ?xito.");
			}
			clienteServicio.getListaClientes().set(posicion, cEditar);
		}
		
		else {
			System.out.println("No se ha encontrado cliente con n?mero RUN asociado " + runClienteT);
		}

		
	}

	@Override
	public void importarDatos() {
		System.out.println("\n---------Cargar Datos en Windows---------------\n");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
		
		try {
			String ubicacion = this.teclado.nextLine().trim();
			String ubicacionArchivo = ubicacion + "\\" + this.fileName1;
			File archivo = new File(ubicacionArchivo);
			FileReader fileR = new FileReader(archivo);
			BufferedReader buRed = new BufferedReader(fileR);
			
			clienteServicio.getListaClientes().clear();
			
			String capturaLinea = buRed.readLine();
			
			while (capturaLinea != null ) {
				String [] info = capturaLinea.split(",");
				if (info.length == 5); {
					Cliente registro = new Cliente();
					registro.setRunCliente(info[0]);
					registro.setNombreCliente(info[1]);
					registro.setApellidoCliente(info[2]);
					registro.setAniosCliente(info[3]);
					CategoriaEnum nombreCategoria;
					if (info [4].equals("Activo")); {
						nombreCategoria = CategoriaEnum.Activo;
					}
					
					registro.setNombreCategoria(nombreCategoria);
					clienteServicio.getListaClientes().add(registro);
				}
					
				capturaLinea = buRed.readLine();
			}
			buRed.close();
			System.out.println("Los clientes han sido registrados exitosamente.");
		}
		catch(FileNotFoundException e) {
			System.out.println("El archivo no ha sido encontrado.");
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("El archivo no pudo ser le?do");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void exportarDatos() {
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar: ");
		System.out.println("1.-Formato csv");
		System.out.println("2.-Formato txt");
		System.out.println("\nIngrese una opci?n para exportar: \n");
		System.out.println("----------------------------------");
		
		int opcionExp = Integer.parseInt(this.teclado.nextLine().trim());
		
		if (opcionExp == 1) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv: ");
			String rutaExp = this.teclado.nextLine().trim();
			
			String rutaArchivo = rutaExp + "\\" + this.fileName + ".csv";
			exportarCsv.exportar(rutaArchivo, this.clienteServicio.getListaClientes());
			
			
		}
		else if (opcionExp == 2) {
			System.out.println("---------Exportar Datos en Windows---------------");
			System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt: ");
			String rutaExp = this.teclado.nextLine().trim();
			
			String rutaArchivo = rutaExp + "\\" + this.fileName + ".txt";
			exportarTxt.exportar(rutaArchivo, this.clienteServicio.getListaClientes());
			
		}
		}
	@Override
	public void terminarPrograma() {

	}

	

}
