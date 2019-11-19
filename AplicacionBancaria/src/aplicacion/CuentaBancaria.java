package aplicacion;

public class CuentaBancaria {
	private String titular;
	private String codigoCuenta;//en string hasta que se encuentre/ocurra otra manera
	private double saldoActual;
	
	
	
	public CuentaBancaria() {
		titular="";
		codigoCuenta="20385778983000760236";//para prueba
		saldoActual=0;
	}

	public CuentaBancaria(String titular, String codigoCuenta) {
		this.titular = titular;
		this.codigoCuenta = codigoCuenta;
		saldoActual=0;
	}
	
	public double getSaldoActual() {
		return saldoActual;
	}
	
	public void ingresarEfectivo(double ingreso) {
		
		if (ingreso>0) {
			saldoActual+= ingreso;
		}else {
			System.out.println("La operacion no se pudo efectuar");
		}
	}
	
	public void retirarEfectivo(double efectivo) {
		if ((saldoActual-efectivo)>-200) {//-200 por ciertas cuestiones
		
			if (efectivo>0) {
				saldoActual-=efectivo;
			}else {
				System.out.println("La operacion no se pudo efectuar");
			}
		
		}
	}
	
	public void comprobarDigitosCtrl() {//terminar  public para prueba
		String banco=codigoCuenta.substring(0, 8);
		String ctrlDigit=codigoCuenta.substring(8, 9);
		String numeroCuenta=codigoCuenta.substring(10, codigoCuenta.length());
		int ctrlCuenta=0;
		int ctrlBanco=0;
		int resultado=0;
		
//		System.out.println(banco);
//		System.out.println(ctrlDigit);
//		System.out.println(numeroCuenta);
		
		
				resultado+= (Integer.parseInt(banco.substring(0, 1))*4);
				
				resultado+= (Integer.parseInt(banco.substring(1, 2))*8);
				
				resultado+= (Integer.parseInt(banco.substring(2, 3))*5);
				
				resultado+= (Integer.parseInt(banco.substring(3, 4))*10);
				
				resultado+= (Integer.parseInt(banco.substring(4, 5))*9);
				
				resultado+= (Integer.parseInt(banco.substring(5, 6))*7);
				
				resultado+= (Integer.parseInt(banco.substring(6, 7))*3);
				
				resultado+= (Integer.parseInt(banco.substring(7, 8))*6);
			
		ctrlBanco=11-(resultado%11);
		
		////hacer comprobacion en caso de ser 11 o 10
		
		resultado=0;
		
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(0, 1))*1);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(1, 2))*2);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(2, 3))*4);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(3, 4))*8);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(4, 5))*5);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(5, 6))*10);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(6, 7))*9);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(7, 8))*7);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(8, 9))*3);
		
			resultado+= (Integer.parseInt(numeroCuenta.substring(9, numeroCuenta.length()))*6);
		
		ctrlCuenta=11-(resultado%11);	
		
		
		
		
		System.out.println(ctrlBanco);
		System.out.println(ctrlCuenta);
		
		////
	}
	
	
	
}
