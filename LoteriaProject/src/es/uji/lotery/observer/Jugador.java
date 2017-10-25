package es.uji.lotery.observer;

import java.util.ArrayList;
import java.util.List;

import es.uji.lotery.notificator.INotificator;

public class Jugador implements IJugador {
	
	private String nombre;
	private int[] boleto;
	
	private List<INotificator> notificadores; 
	
	public Jugador(String nombre, int[] boleto){
		this.setNombre(nombre);
		this.boleto=boleto;
		this.setPeriodicos(new ArrayList<INotificator>());
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
//			System.out.println("Soy "+nombre+ " y he acertado "+ numeroAciertos(boletoAComparar) +" números.");
			for(IObserver periodico:notificadores)
				periodico.actualizar(nombre+"_"+numeroAciertos(boletoAComparar), boleto);
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
		notificadores.add((INotificator)periodicoObservador);
		
	}

	public void eliminarObservador(IObserver observador) throws Exception {
		notificadores.remove(observador);
	}

	public void notificar() {
		for(IObserver periodico: notificadores)
			periodico.actualizar(nombre, boleto);
		
	}

	public List<INotificator> getPeriodicos() {
		return notificadores;
	}

	public void setPeriodicos(List<INotificator> periodicos) {
		this.notificadores = periodicos;
	}

}
