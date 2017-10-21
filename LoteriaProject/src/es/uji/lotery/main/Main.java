package es.uji.lotery.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import es.uji.lotery.observer.IObserver;
import es.uji.lotery.observer.Jugador;
import es.uji.lotery.observer.Periodico;
import es.uji.lotery.subject.ILoteria;
import es.uji.lotery.subject.LoteriaPrimitiva;

public class Main {

	private static final int NUM_JUGADORES=10;
	
	public static void main(String[] args) {
		try{
			Random randomGenerator = 
				new Random(
						GregorianCalendar.getInstance().get(Calendar.MILLISECOND)
						);
			
			LoteriaPrimitiva primitiva = new LoteriaPrimitiva();
			Periodico periodico = new Periodico();
			primitiva.
			
			int jugadoresCreados = 0;
			while(jugadoresCreados < NUM_JUGADORES){
				
				String nombre = "Soy el jugador n�mero "+
				jugadoresCreados++;
				
				int[] boletoAJugar = new int[ILoteria.LENGTH];
				boletoAJugar[0] = IObserver.OBSERVADOR_JUGADOR;
				for(int i = 1 ; i<ILoteria.LENGTH ; i++)
					boletoAJugar[i] = 
						randomGenerator.nextInt(ILoteria.LAST_NUM)+ILoteria.FIRST_NUM;

				Jugador j = new Jugador(nombre,boletoAJugar);
				
				primitiva.registrarObervador(j);
			}
			
			/**1º SORTEO**/
			primitiva.nuevoSorteo();
			/**2º SORTEO**/
			primitiva.nuevoSorteo();
			/**3º SORTEO**/
			primitiva.nuevoSorteo();
			/**4º SORTEO**/
			primitiva.nuevoSorteo();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
