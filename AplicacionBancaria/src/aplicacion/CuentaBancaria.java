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
	public String getTitular() {
		return titular;
	}
	
	public double getSaldoActual() {
		return saldoActual;
	}
	public String getCuenta() {
		return codigoCuenta;
	}
	
	public void ingresarEfectivo(double ingreso) {
		
		if (ingreso>0) {
			saldoActual+= ingreso;
		}else {
			System.out.println("La operacion no se pudo efectuar");
		}
	}
	
	public void retirarEfectivo(double efectivo) {
		if ((saldoActual-efectivo)>=0) {
		
			if (efectivo>0) {
				saldoActual-=efectivo;
			}else {
				System.out.println("La operacion no se pudo efectuar");
			}
		
		}
	}
	
	public boolean comprobarDigitosCtrl() {
		String banco=codigoCuenta.substring(0, 9);
		String ctrlDigit=codigoCuenta.substring(10, 12);
		String numeroCuenta=codigoCuenta.substring(13, codigoCuenta.length());
		int ctrlCuenta=0;
		int ctrlBanco=0;
		int resultado=0;
		String result="";

		//primer numero
			resultado+= (Integer.parseInt(banco.substring(0, 1))*4);
			resultado+= (Integer.parseInt(banco.substring(1, 2))*8);
			resultado+= (Integer.parseInt(banco.substring(2, 3))*5);
			resultado+= (Integer.parseInt(banco.substring(3, 4))*10);
			resultado+= (Integer.parseInt(banco.substring(5, 6))*9);
			resultado+= (Integer.parseInt(banco.substring(6, 7))*7);
			resultado+= (Integer.parseInt(banco.substring(7, 8))*3);
			resultado+= (Integer.parseInt(banco.substring(8, 9))*6);
			
		ctrlBanco=11-(resultado%11);
		
		
		if (ctrlBanco==10) {
			ctrlBanco=1;
		}else if (ctrlBanco==11) {
			ctrlBanco=0;
		}
		
		resultado=0;
		//segundo numero
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
		
		if (ctrlCuenta==10) {
			ctrlCuenta=1;
		}else if (ctrlCuenta==11) {
			ctrlCuenta=0;
		}
		
		//digito ctrl calculado
		result=ctrlBanco+""+ctrlCuenta;
		
		if (result.equalsIgnoreCase(ctrlDigit)) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	
}
