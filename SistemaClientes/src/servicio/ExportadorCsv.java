package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ExportadorCsv extends Exportador{

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
				
				bufferedWriter.write(client.getRunCliente() + "," + client.getNombreCliente() + "," + 
				client.getApellidoCliente() + "," + client.getAniosCliente() + "," + categoria + "\n");
			}
			bufferedWriter.close();
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
		} 
		catch (IOException e) {
			System.out.println("Error al abrir Archivo");
			System.out.println(e.getMessage());
		}
		
	}

}
