package es.uji.lotery.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import es.uji.lotery.notificator.INotificator;
import es.uji.lotery.notificator.Periodico;
import es.uji.lotery.observer.IObserver;
import es.uji.lotery.observer.Jugador;
import es.uji.lotery.subject.ILoteria;
import es.uji.lotery.subject.LoteriaPrimitiva;

public class Main {

	private static final int NUM_JUGADORES=1000;
	
	public static void main(String[] args) {
		System.out.println("Enter para nuevo sorteo, -1 para finalizar: ");
		try{
			Scanner sc = new Scanner(System.in);
			String cadenaInput=sc.nextLine();
			
			while(cadenaInput.equals("") && !cadenaInput.trim().equals("-1")){
				
				Random randomGenerator = 
					new Random(
							GregorianCalendar.getInstance().get(Calendar.MILLISECOND)
							);
				
				LoteriaPrimitiva primitiva = new LoteriaPrimitiva();
				INotificator periodico = new Periodico();
				
				primitiva.registrarObervador(periodico);
				
				int jugadoresCreados = 0;
				while(jugadoresCreados < NUM_JUGADORES){
					
					String nombre = "Jugador número "+
					jugadoresCreados++;
					
					int[] boletoAJugar = new int[ILoteria.LENGTH];
					boletoAJugar[0] = IObserver.OBSERVADOR_JUGADOR;
					for(int i = 1 ; i<ILoteria.LENGTH ; i++)
						boletoAJugar[i] = 
							randomGenerator.nextInt(ILoteria.LAST_NUM)+ILoteria.FIRST_NUM;
	
					Jugador j = new Jugador(nombre,boletoAJugar);
					
					j.registrarObervador(periodico);
					primitiva.registrarObervador(j);
					
				}
				/**SORTEOS**/
				
					primitiva.nuevoSorteo();
					periodico.show();
					System.out.println("Enter para nuevo sorteo, -1 para finalizar: ");
					cadenaInput=sc.nextLine();
					
			}
			
			sc.close();
			System.exit(0);
		}catch(Exception ex){
			ex.printStackTrace();
			System.exit(-1);
		}
	}

}
