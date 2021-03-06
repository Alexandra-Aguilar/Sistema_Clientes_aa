package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String filName, List<Cliente> listaClientes) {
		try {
			File file = new File(filName);
			FileWriter fileW = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileW);
			
			for (Cliente client : listaClientes) {
				
				String categoria = "Activo";
				if (client.getNombreCategoria().equals(CategoriaEnum.Activo)) {
					categoria = "Activo";
					}
				else if (client.getNombreCategoria().equals(CategoriaEnum.Inactivo)) {
					categoria = "Inactivo";
				}
	
				bufferedWriter.write("\n-------------Datos del Cliente-------------\n\n");
				bufferedWriter.write("RUN del Cliente: " + client.getRunCliente() + "\n");
				bufferedWriter.write("Nombre del Cliente: " + client.getNombreCliente() + "\n");
				bufferedWriter.write("Apellido del Cliente: " + client.getApellidoCliente() + "\n");
				bufferedWriter.write("A?os como Cliente: " + client.getAniosCliente() + "\n");
				bufferedWriter.write("Categor?a del Cliente: " + categoria + "\n");
				bufferedWriter.write("\n-------------------------------------------\n");
			}
			bufferedWriter.close();
			System.out.println("Datos de clientes exportados correctamente en formato txt.");
		} 
		catch (IOException e) {
			System.out.println("Error al abrir Archivo");
			System.out.println(e.getMessage());
		}
		
	}

}
