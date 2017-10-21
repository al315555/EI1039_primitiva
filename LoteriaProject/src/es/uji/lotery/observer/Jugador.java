package es.uji.lotery.observer;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements IJugador {
	
	private String nombre;
	private int[] boleto;
	
	private List<IObserver> periodicos; 
	
	public Jugador(String nombre, int[] boleto){
		this.setNombre(nombre);
		this.boleto=boleto;
		this.setPeriodicos(new ArrayList<IObserver>());
	}

	public int numeroAciertos(int[] boletoAComparar) throws Exception{
		int nAciertos=0;
		for(int i = 0 ; i<boleto.length; i++){
			nAciertos+=boleto[i]==boletoAComparar[i]?1:0;
		}
		return nAciertos;
	}

	public void actualizar(String loteria, int[] boletoAComparar) {
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

	public void registrarObervador(IObserver periodicoObservador) {
		periodicos.add(periodicoObservador);
		
	}

	public void eliminarObservador(IObserver observador) throws Exception {
		periodicos.remove(observador);
	}

	public void notificar() {
		for(IObserver periodico: periodicos)
			periodico.actualizar(nombre, boleto);
		
	}

	public List<IObserver> getPeriodicos() {
		return periodicos;
	}

	public void setPeriodicos(List<IObserver> periodicos) {
		this.periodicos = periodicos;
	}
}
