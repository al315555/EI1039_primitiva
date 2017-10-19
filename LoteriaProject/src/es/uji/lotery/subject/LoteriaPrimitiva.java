package es.uji.lotery.subject;

import java.util.ArrayList;
import java.util.Random;

import es.uji.lotery.observer.IObserver;

public class LoteriaPrimitiva implements ILoteria{

	private ArrayList<IObserver> jugadores = new ArrayList<IObserver>();
	private int[] boletoPremiado= new int[LENGTH];
	
	public void nuevoSorteo() {
		
		Random random = new Random();
		
		System.out.print("\n\nEl boleto ganador es: {{ ");
		for(int i = 0; i<LENGTH;i++){
			boletoPremiado[i]=random.nextInt(LAST_NUM)+FIRST_NUM;
			System.out.print(" "+boletoPremiado[i] +" ");
		}
		System.out.println(" }}\n\n");
		
		
		notificar();
		
	}

	public void registrarObervador(IObserver observador) {
		jugadores.add(observador);
		
	}

	public void eliminarObservador(IObserver observador) throws Exception{
		jugadores.remove(observador);
	}

	public void notificar() {
		for(IObserver jugador: jugadores)
			jugador.actualizar(boletoPremiado);
	}

}
