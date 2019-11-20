package aplicacion;

import java.util.Scanner;

public class Menu {
	
	
	public static int menuPrincipal() {
		int opc=0;
		Scanner leer=new Scanner(System.in);
		do {
			System.out.println("1.- Ver numero de cuenta");
			System.out.println("2.- Ver titular");
			System.out.println("3.- Ver el codigo de la entidad bancaria");
			System.out.println("4.- Ver el codigo de la oficina");
			System.out.println("5.- Ver el codigo de la cuenta");
			System.out.println("6.- Ver los digitos de control");
			System.out.println("7.- Realizar un ingreso");
			System.out.println("8.- Retirar efectivo");
			System.out.println("9.- Consultar saldo");
			System.out.println("10.- Salir");

			opc=leer.nextInt();
			
		} while (opc<0 && opc>10);

		return opc;
	}
	
	
	
	
	
	
}
