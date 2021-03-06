package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuAbs {
	Scanner teclado = new Scanner(System.in);

	public abstract void listarCliente();

	public abstract void agregarCliente();

	public abstract void editarCliente();

	public abstract void importarDatos();

	public abstract void exportarDatos();

	public abstract void terminarPrograma();

	public final void iniciarMenu() {

		boolean salir = false;
		while (!salir) {

			System.out.println("1. Listar Clientes\n" + "2. Agregar Cliente\n" + "3. Editar Cliente\n"
					+ "4. Cargar Datos\n" + "5. Exportar Datos\n" + "6. Salir");

			try {

				System.out.println("Ingrese una opci?n: ");
				int opcion = teclado.nextInt();

				switch (opcion) {
				case 1:
					listarCliente();
			
					break;
				case 2:
					agregarCliente();
					break;
				case 3:
					editarCliente();
					break;
				case 4:
					importarDatos();
					break;
				case 5:
					exportarDatos();
					break;
				case 6:
					terminarPrograma();
					salir = true;
					System.out.println("Saliendo del sistema de clientes...\nAcaba de salir del sistema." );
					break;
				default:
					System.out.println("La opcion no es v?lida. Ingrese una opci?n v?lida entre el 1 y el 6.");
					System.out.println("");
				}
			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir una opci?n del men?");
				System.out.println("");
				teclado.next();
			}
		}
		
		teclado.close();
	}

}
