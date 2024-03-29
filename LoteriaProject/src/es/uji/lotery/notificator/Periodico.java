package es.uji.lotery.notificator;

import java.util.ArrayList;

import es.uji.lotery.observer.IObserver;
import es.uji.lotery.subject.ILoteria;

public class Periodico implements INotificator{

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
	
	/**
	** Los n�meros del sorteo 
	** El n�mero de acertantes de 3, 4, 5 y 6 n�meros
	**/
	
	public void show(){
		
		System.out.print("El sorteo con numeros: {{ ");
		for(int i = 1; i<ILoteria.LENGTH;i++){
			System.out.print(" "+boletoPremiado[i] +" ");
		}
		System.out.println(" }} ha tenido como premiados a: \n");
		
		for(String j: jugadores){
			String[] strWords = j.split("_");
			if(Integer.parseInt(strWords[1])>2)
				System.out.println("\t"+strWords[0] + " con "+strWords[1]+" n�meros acertados.");
		}
		System.out.println();
	}


}
