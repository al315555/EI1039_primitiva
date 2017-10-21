package es.uji.lotery.observer;

import java.util.ArrayList;

public class Periodico implements IObserver{

	private int[] boletoPremiado; 
	private ArrayList<String> jugadores=new ArrayList<String>();
	
	public void actualizar(String cadenaNombre, int[] boleto) {
		if(boleto[0]==IObserver.OBSERVADOR_JUGADOR){
			jugadores.add(cadenaNombre);
		}
		if(boleto[0]==IObserver.OBSERVADOR_LOTERIA){
			boletoPremiado=boleto;
		}
	}
	
	public void show(){
		
		System.out.println("El sorteo con numeros:  " + boletoPremiado 
				+ "ha tenido como premiados a: ");
		for(String j: jugadores)
			System.out.println(j);
		/**los números del sorteo 
		**el número de acertantes de 3, 4, 5 y 6 números
		**/
	}


}
