package es.uji.lotery.observer;

public interface IObserver {
	
	public final static int OBSERVADOR_LOTERIA=1;
	public final static int OBSERVADOR_JUGADOR=2;
	
	void actualizar(String cadena, int[] boletoGanador);
}
