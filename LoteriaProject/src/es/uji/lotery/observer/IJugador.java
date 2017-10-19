package es.uji.lotery.observer;

public interface IJugador extends IObserver{
	
	int numeroAciertos(int[] boletoAComparar) throws Exception;
	
}
