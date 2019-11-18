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
		String banco=codigoCuenta.substring(0, 3);
		String oficina=codigoCuenta.substring(4, 7);
		String ctrlDigit=codigoCuenta.substring(8, 9);
		String numeroCuenta=codigoCuenta.substring(10, 19);
		
		System.out.println(codigoCuenta.substring(10, codigoCuenta.length()));
		System.out.println(codigoCuenta.substring(8, 10));
		System.out.println(codigoCuenta.substring(4, 8));
		System.out.println(codigoCuenta.substring(0, 4));
		
		
		
	}
	
	
	
	
	
	
}
