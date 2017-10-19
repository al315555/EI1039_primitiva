package es.uji.lotery.observer;

public class Jugador implements IJugador {
	
	private String nombre;
	private int[] boleto;
	
	public Jugador(String nombre, int[] boleto){
		this.setNombre(nombre);
		this.boleto=boleto;
	}

	public int numeroAciertos(int[] boletoAComparar) throws Exception{
		int nAciertos=0;
		for(int i = 0 ; i<boleto.length; i++){
			nAciertos+=boleto[i]==boletoAComparar[i]?1:0;
		}
		return nAciertos;
	}

	public void actualizar(int[] boletoAComparar) {
		try{
			System.out.println("Soy "+nombre+ " y he acertado "+ numeroAciertos(boletoAComparar) +" números.");
		}catch(Exception ex){
			System.out.println("--ERROR INESPERADO--");
			ex.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
