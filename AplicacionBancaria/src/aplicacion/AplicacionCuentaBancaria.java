package aplicacion;

import java.util.Scanner;

public class AplicacionCuentaBancaria {

	private static String transformarFormato(String numCuenta) {
		String resultado="";
		
		for (int i = 0; i < numCuenta.length(); i++) {
			if (numCuenta.substring(i, i+1).equalsIgnoreCase("-")) {
				resultado += " ";
			}else {
				resultado+=numCuenta.substring(i, i+1);
			}
		}
		resultado.trim();
		
		
		return resultado;
	}
	
	
	
	public static void main(String[] args) {
		String titular="";
		String numCuenta="";
		String numCuenta1="";
		Scanner leer = new Scanner(System.in);
		System.out.println("Nombre del TITULAR");
		titular=leer.nextLine();
		System.out.println("Numero de CUENTA     Formato: xxxx-xxxx-xx-xxxxxxxxxx");
		numCuenta1=leer.nextLine();
		
		numCuenta= transformarFormato(numCuenta1);
		
		CuentaBancaria cuenta= new CuentaBancaria(titular, numCuenta);
		Menu menu=new Menu();
		
		if (numCuenta.length()!=23) {
			System.err.println("La cuenta NO es valida");
			System.err.println("Asegurese de utilizar el formato adecuado");
			System.err.println("O escriba el numero completo");
			
		}else if (cuenta.comprobarDigitosCtrl()){
			int opc=0;
			Scanner leernum= new Scanner(System.in);
			double ingreso = 0;	
			double efectivo=0;
			do {
			opc = menu.menuPrincipal();
			switch (opc) {
				case 1:
					System.out.println("numero de cuenta: "+ cuenta.getCuenta());
					break;
				case 2:
					System.out.println("nombre del titular: "+ cuenta.getTitular());
					break;
				case 3:
					System.out.println("codigo del banco: "+ cuenta.getCuenta().substring(0, 4));
					break;
				case 4:
					System.out.println("codigo de la oficina: "+ cuenta.getCuenta().substring(4, 8));
					break;
				case 5:
					System.out.println("numero de cuenta: "+ cuenta.getCuenta().substring(10, 20));
					break;
				case 6:
					System.out.println("digito de control: "+ cuenta.getCuenta().substring(8, 10));
					break;
				case 7:
					System.out.println("cuanto quieres ingresar");
					ingreso=leernum.nextDouble();
					cuenta.ingresarEfectivo(ingreso);
					break;
				case 8:
					System.out.println("cuanto quieres retirar");
					efectivo=leernum.nextDouble();
					cuenta.retirarEfectivo(efectivo);
					break;
				case 9:
					System.out.println("saldo actual: "+ cuenta.getSaldoActual());
					break;
				default:
					break;
				}
			}while (opc!=10);
			
			
		}else {
			System.err.println("La cuenta NO es valida");
		}
		
		
		
		
		
	}

}
