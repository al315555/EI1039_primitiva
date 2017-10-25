package es.uji.lotery.subject;

import java.util.ArrayList;
import java.util.Random;

import es.uji.lotery.notificator.INotificator;
import es.uji.lotery.observer.IObserver;

public class LoteriaPrimitiva implements ILoteria{

	private ArrayList<IObserver> jugadores = new ArrayList<IObserver>();
	private ArrayList<INotificator> notificadores = new ArrayList<INotificator>();
	private int[] boletoPremiado= new int[LENGTH];
	
	public LoteriaPrimitiva(){
		super();
		boletoPremiado[0]=IObserver.OBSERVADOR_LOTERIA;
	}
	public void nuevoSorteo() {
		
		Random random = new Random();
		
		System.out.print("\n\nEl boleto ganador es: {{ ");
		for(int i = 1; i<LENGTH;i++){
			boletoPremiado[i]=random.nextInt(LAST_NUM)+FIRST_NUM;
			System.out.print(" "+boletoPremiado[i] +" ");
		}
		System.out.println(" }}\n\n");
		
		
		notificar();
		
	}

	public void registrarObervador(IObserver observador) {
		if(observador.getClass().getName().equals("Jugador"))
			jugadores.add(observador);
		else
			notificadores.add((INotificator)observador);
		
	}

	public void eliminarObservador(IObserver observador) throws Exception{
		jugadores.remove(observador);
	}

	public void notificar() {
		for(IObserver jugador: jugadores)
			jugador.actualizar("loteria",boletoPremiado);
		for(IObserver periodico:notificadores )
			periodico.actualizar("loteria",boletoPremiado);
	}

	public ArrayList<INotificator> getNotificadores() {
		return notificadores;
	}

	public void setNotificadores(ArrayList<INotificator> periodicos) {
		this.notificadores = periodicos;
	}

}
