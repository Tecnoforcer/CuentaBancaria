package aplicacion;

import java.util.Scanner;

public class AplicacionCuentaBancaria {

	private static String transformarFormato(String numCuenta) {// ¿se intenta con un vector? ahora mismo no que esta en
																// prueba
		String resultado = "";
		String banco = "";
		String oficina = "";
		String digitoCtrl = "";
		String numCuen = "";

		for (int i = 0; i < 4; i++) {
			banco += numCuenta.charAt(i);
		}
		for (int i = 0; i < 4; i++) {
			oficina += numCuenta.charAt(i + 4);
		}
		for (int i = 0; i < 2; i++) {
			digitoCtrl += numCuenta.charAt(i + 8);
		}
		for (int i = 0; i < 10; i++) {
			numCuen += numCuenta.charAt(i + 10);
		}
		resultado = banco + "-" + oficina + "-" + digitoCtrl + "-" + numCuen;

		return resultado;
	}

	public static void main(String[] args) {
		String titular = "";
		String numCuenta = "";
		String numCuenta1 = "";
		int opc = 0;
		double ingreso = 0;
		double efectivo = 0;
		Scanner leer = new Scanner(System.in);
		Scanner leernum = new Scanner(System.in);

		CuentaBancaria cuenta;

		// Pedida de datos
		do {
			System.out.println("Nombre del TITULAR");
			titular = leer.nextLine();
			System.out.println("Numero de CUENTA     Formato: xxxx-xxxx-xx-xxxxxxxxxx");
			numCuenta1 = leer.nextLine();

			if (numCuenta1.length() == 20) {
				numCuenta = transformarFormato(numCuenta1);
			}

			cuenta = new CuentaBancaria(titular, numCuenta);

			if (!cuenta.comprobarDigitosCtrl()) {
				System.err.println("La cuenta NO es valida");
			}

		} while (!cuenta.comprobarDigitosCtrl());

		// ***** fin pedida de datos
		// Inicio de la gestion de la cuenta

		do {
			opc = Menu.menuPrincipal();
			switch (opc) {
			case 1:
				System.out.println("numero de cuenta: " + cuenta.getCuenta());
				break;
			case 2:
				System.out.println("nombre del titular: " + cuenta.getTitular());
				break;
			case 3:
				System.out.println("codigo del banco: " + cuenta.getCuenta().substring(0, 4));
				break;
			case 4:
				System.out.println("codigo de la oficina: " + cuenta.getCuenta().substring(5, 9));
				break;
			case 5:
				System.out.println("numero de cuenta: " + cuenta.getCuenta().substring(13, 23));
				break;
			case 6:
				System.out.println("digito de control: " + cuenta.getCuenta().substring(10, 12));
				break;
			case 7:
				System.out.println("cuanto quieres ingresar");
				ingreso = leernum.nextDouble();
				cuenta.ingresarEfectivo(ingreso);
				break;
			case 8:
				System.out.println("cuanto quieres retirar");
				efectivo = leernum.nextDouble();
				cuenta.retirarEfectivo(efectivo);
				break;
			case 9:
				System.out.println("saldo actual: " + cuenta.getSaldoActual());
				break;
			default:
				break;
			}
		} while (opc != 10);

	}

}
