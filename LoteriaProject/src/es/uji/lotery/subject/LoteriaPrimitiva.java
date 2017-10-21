package es.uji.lotery.subject;

import java.util.ArrayList;
import java.util.Random;

import es.uji.lotery.observer.IObserver;

public class LoteriaPrimitiva implements ILoteria{

	private ArrayList<IObserver> jugadores = new ArrayList<IObserver>();
	private ArrayList<IObserver> periodicos = new ArrayList<IObserver>();
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

	public void registrarObervador(Object obj , IObserver observador) {
		jugadores.add(observador);
		
	}

	public void eliminarObservador(IObserver observador) throws Exception{
		jugadores.remove(observador);
	}

	public void notificar() {
		for(IObserver jugador: jugadores)
			jugador.actualizar("loteria",boletoPremiado);
		for(IObserver periodico:periodicos )
			periodico.actualizar("loteria",boletoPremiado);
	}

	public ArrayList<IObserver> getPeriodicos() {
		return periodicos;
	}

	public void setPeriodicos(ArrayList<IObserver> periodicos) {
		this.periodicos = periodicos;
	}

}
